package test.liuyang.com.zhbj.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import test.liuyang.com.zhbj.R;
import test.liuyang.com.zhbj.base.BasePager;
import test.liuyang.com.zhbj.customview.SlidingMenu;
import test.liuyang.com.zhbj.impl.menu.NewsMenuDetail;
import test.liuyang.com.zhbj.impl.menu.TabDetailPager;

/**
 * Created by Administrator on 2016/9/20.
 */
public class NewsPager extends BasePager {
    public NewsPager(Activity activity) {
        super(activity);
    }

    private SlidingMenu sd;
    boolean  flag;


    @Override
    public View initView() {

//        View.inflate()

        return super.initView();
    }

    @Override
    public void initData() {

        // 要給

//        TextView  view=new TextView(mActiviy);
//        view.setText("新聞中心");
//        view.setTextColor(Color.RED);
//        view.setGravity(Gravity.CENTER);
//        fm_content.addView(view);

//        TabDetailPager tp=new TabDetailPager(mActiviy);

//        fm_content.removeAllViews();

        NewsMenuDetail detail = new NewsMenuDetail(mActiviy);

        View view = detail.initView();

        fm_content.addView(view);
        System.out.println("加载新闻中心");

        tv_title.setText("新聞中心");

        img_menu.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                if(!flag){
                    System.out.println("触发了啊=====");
                    sd = (SlidingMenu) mActiviy.findViewById(R.id.sl_01);

                    sd.smoothScrollTo(0,0);

//                    sd.invalidate();

                    flag=true;
                }else{


                    sd.scrollTo(520,0);
                    flag=false;

                }



            }
        });

    }
}
