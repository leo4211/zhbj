package test.liuyang.com.zhbj.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import test.liuyang.com.zhbj.R;

/**
 * Created by Administrator on 2016/9/20.
 */
public class BasePager {

    public  View mRootView;
    public Activity mActiviy;

    public BasePager(Activity activity){

        this.mActiviy=activity;

        mRootView = initView();


    }

    public TextView  tv_title;
    public ImageView  img_menu;
    public FrameLayout fm_content;

    //初始化布局文件
    public View initView() {

        View view = View.inflate(mActiviy, R.layout.base_pager, null);

        tv_title = (TextView) view.findViewById(R.id.tv_title);

         img_menu = (ImageView) view.findViewById(R.id.img_menu_button);

         fm_content = (FrameLayout) view.findViewById(R.id.fm_content);

        initData();
        return  view;

    }

    public void initData() {


    }


}
