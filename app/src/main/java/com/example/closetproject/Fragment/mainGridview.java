package com.example.closetproject.Fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridView;

public class mainGridview extends GridView {
    boolean expanded = false;

    public mainGridview(Context context) {
        super(context);
    }

    public mainGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mainGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public boolean isExpanded(){
        return expanded;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        if (isExpanded()){
            int expandSpen = MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK,
                    MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpen);

            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = getMeasuredHeight();
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
    public void setExpanded(boolean expanded){
        this.expanded = expanded;
    }

    public class ExpandableHeightGridView {
    }
}
