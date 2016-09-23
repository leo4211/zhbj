package test.liuyang.com.zhbj.XhttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import test.liuyang.com.zhbj.pojo.area;

/**
 * Created by Administrator on 2016/9/22.
 */
public class HttpUtlis {

    public static List<area> alist;
    public   void  getList(){
        alist=new ArrayList<area>();
        RequestParams params=new RequestParams("https://route.showapi.com/170-48");
//        https://route.showapi.com/170-48?showapi_appid=18603&showapi_timestamp=20160922171051&showapi_sign=55e2a42d1183b1953fcf58dac9d8da4a
//        https://route.showapi.com/170-48?showapi_appid=18603&showapi_timestamp=20160923160926&showapi_sign=69e97cd4dfaeb70cc85b0d8a98e84655
        params.addBodyParameter("showapi_appid",String.valueOf(18603));
        params.addBodyParameter("showapi_timestamp","");
        params.addBodyParameter("showapi_sign","69e97cd4dfaeb70cc85b0d8a98e84655");


        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                System.out.println("获得结果："+result);

                try {
                    JSONObject jsonObject=new JSONObject(result);

                    JSONObject res_body = jsonObject.getJSONObject("showapi_res_body");
                    System.out.println("=="+res_body+"====");

                    JSONArray list = res_body.getJSONArray("cityList");

                    System.out.println(list.length());
                    for (int i=0;i<list.length();i++){

                        JSONObject object = list.getJSONObject(i);

                        String name = object.getString("areaName");

                        String areaId = object.getString("areaId");

                        System.out.println(name+areaId+"=====");
                        area a=new area(areaId,name);

                        alist.add(a);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


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
