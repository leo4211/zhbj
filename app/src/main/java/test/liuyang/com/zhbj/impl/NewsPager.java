package test.liuyang.com.zhbj.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import test.liuyang.com.zhbj.base.BasePager;

/**
 * Created by Administrator on 2016/9/20.
 */
public class NewsPager extends BasePager {
    public NewsPager(Activity activity) {
        super(activity);
    }


    @Override
    public void initData() {

        // 要給

//        TextView  view=new TextView(mActiviy);
//        view.setText("新聞中心");
//        view.setTextColor(Color.RED);
//        view.setGravity(Gravity.CENTER);
//        fm_content.addView(view);

        System.out.println("加载新闻中心");

        tv_title.setText("新聞中心");
        RequestParams  params=new RequestParams("https://route.showapi.com/170-48");
//        ?n=10&showapi_appid=18603&showapi_timestamp=20160921092912&showapi_sign=5f81e3f9fa9fb92a75f9a03bc5794da9
//        ?showapi_appid=18603&showapi_timestamp=20160921111823&showapi_sign=61e09f7c2ab261a804c1e04573482354
//        params.addBodyParameter("n",String.valueOf(1));
        params.addBodyParameter("showapi_appid",String.valueOf(18603));
        params.addBodyParameter("showapi_timestamp","20160921111823");
        params.addBodyParameter("showapi_sign","61e09f7c2ab261a804c1e04573482354");


        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                System.out.println("网络结果"+result);




            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
