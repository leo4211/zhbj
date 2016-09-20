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
public class SettingsPager extends BasePager {
    public SettingsPager(Activity activity) {
        super(activity);
    }


    @Override
    public void initData() {

        // 要給

        TextView  view=new TextView(mActiviy);
        view.setText("設置初始化");
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);
        fm_content.addView(view);

        tv_title.setText("設置");

        img_menu.setVisibility(View.INVISIBLE);
    }
}
