package com.example.closetproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class test_Dialog extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);

        btnShow = (Button) findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.test_dialog_option, null);
        final EditText etName = (EditText) alertLayout.findViewById(R.id.etName);
        final EditText etDate = (EditText) alertLayout.findViewById(R.id.etDate);
        final CheckBox cbHungry = (CheckBox) alertLayout.findViewById(R.id.cbHungry);
        final Spinner spSex = (Spinner) alertLayout.findViewById(R.id.spSex);
        final ImageButton btnDate = (ImageButton) alertLayout.findViewById(R.id.btnDate);

        class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                return new DatePickerDialog(getActivity(), this, yy, mm, dd);
            }

            @Override
            public void onDateSet(DatePicker view, int yy, int mm, int dd) {
                etDate.setText((mm + 1) + "/" + dd + "/" + yy);
            }
        }

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getSupportFragmentManager(), "DatePicker");
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Form");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String user = etName.getText().toString();
                String bday = etDate.getText().toString();
                String sex = String.valueOf(spSex.getSelectedItem());
                String hungry = (cbHungry.isChecked()) ? "Yes" : "No";
                Toast.makeText(getBaseContext(), "Name: " + user + "\nBirthday: " + bday + "\nSex: " + sex + "\nHungry: " + hungry, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
}


    }