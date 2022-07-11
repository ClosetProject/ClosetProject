package com.example.closetproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.closetproject.Retrofit_API.RetrofitClient;
import com.example.closetproject.Retrofit_API.RetrofitInterface;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalysisActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> resultLauncher;
    private Button btn_runmodel;
    private ImageView imgViewAnaly;

    private String imageFilePath;
    private Uri photoUri;
    private String m_email = "ddd@naver.com";
    private RetrofitInterface retrofitAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        checkPermission(); // 이중 권한 체크

        btn_runmodel = findViewById(R.id.btn_runmodel);
        imgViewAnaly = findViewById(R.id.imgViewAnaly);

        // intent 양방향 통신 리스너
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Intent 콜백 시, 동작할 함수
                        if(result.getResultCode() == RESULT_OK){
                            imgViewAnaly.setImageURI(photoUri);

                            // 서버에 이미지 저장
                            String[] temp = m_email.split("@|\\.");
                            String file_name = temp[0] + "_" + temp[1];

                            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), new File(imageFilePath));
                            MultipartBody.Part imgBody = MultipartBody.Part.createFormData("file", file_name + ".jpg", requestFile);
                            RequestBody emailText = RequestBody.create(MediaType.parse("text/plain"), m_email);

                            Log.d("emailText",emailText.toString());

                            RetrofitClient retrofitClient = RetrofitClient.getInstance();
                            if(retrofitClient != null){
                                retrofitAPI = RetrofitClient.getRetrofitAPI();
                                retrofitAPI.imageUpload(emailText, imgBody).enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        if(response.isSuccessful()){
                                            // (추가)진단페이지로 넘어가도록 추후 수정
                                            Toast.makeText(AnalysisActivity.this, "업로드에 성공하였습니다", Toast.LENGTH_SHORT);

                                        }else{
                                            Log.d("Res Failure","실패");
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Log.d("failure message", t.getMessage());
                                    }
                                });
                            }
                        }
                    }
                });

        btn_runmodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTakePhotoIntent();
            }
        });
    }
    
    /**
     * 사진 기능 실행 및 이미지 로컬 저장소에 저장
     * */
    private File createImageFile() throws IOException{

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "PERSONAL_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg",   /* suffix */
                storageDir      /* directory */
        );
        imageFilePath = image.getAbsolutePath();
        return image;
    }

    private void sendTakePhotoIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();

            } catch (IOException ex) {
                // Error occurred while creating the File
                Log.d("fail to savePhoto", ex.getMessage());
            }

            if (photoFile != null) {
                photoUri = FileProvider.getUriForFile(this, getPackageName(), photoFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                resultLauncher.launch(takePictureIntent);
            }
        }
    }

    /**
     * 권한 확인
     * */
    private void checkPermission(){
        int camera_prms = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int wStorage_prms = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int rStorage_prms = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        // 권한이 열려있는지 확인
        if (camera_prms == PackageManager.PERMISSION_DENIED || wStorage_prms == PackageManager.PERMISSION_DENIED || rStorage_prms == PackageManager.PERMISSION_DENIED) {
            // 마쉬멜로우 이상버전부터 권한을 물어본다
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                        1000);
            }
            return;
        }
    }

    // 권한 체크 이후로직
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grandResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grandResults);
        if (requestCode == 1000) {
            boolean check_result = true;

            // 모든 퍼미션을 허용했는지 체크
            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }

            // 권한 체크에 동의를 하지 않으면 안드로이드 종료
            if (check_result == true) {

            } else {
                finish();
            }
        }
    }
}