package test.liuyang.com.zhbj.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import test.liuyang.com.zhbj.base.BasePager;

/**
 * Created by Administrator on 2016/9/20.
 */
public class SmartPager extends BasePager {
    public SmartPager(Activity activity) {
        super(activity);
    }


    @Override
    public void initData() {

        // 要給

        TextView  view=new TextView(mActiviy);
        view.setText("智慧服務");
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);
        fm_content.addView(view);

        tv_title.setText("智慧服務");
        img_menu.setVisibility(View.INVISIBLE);

    }
}
