package test.liuyang.com.zhbj.impl.menu;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import test.liuyang.com.zhbj.R;
import test.liuyang.com.zhbj.XhttpUtils.HttpUtlis;
import test.liuyang.com.zhbj.base.BaseMenuDetailPager;
import test.liuyang.com.zhbj.customview.NewsViewpager;
import test.liuyang.com.zhbj.pojo.area;

/**
 * Created by Administrator on 2016/9/21.
 */
public class NewsMenuDetail extends BaseMenuDetailPager{


    public NewsViewpager pager;

    private List<area> alist;

    private  List<TabDetailPager> tlist;

    public NewsMenuDetail(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {



        View view = View.inflate(mActivity, R.layout.pager_news_details,null);


        pager = (NewsViewpager) view.findViewById(R.id.pager_news_menu);

        initData();
        return view;
    }

    @Override
    public void initData() {
        System.out.println("页面标签数据"+HttpUtlis.alist.size());

        alist= HttpUtlis.alist;

        tlist=new ArrayList<TabDetailPager>();

        System.out.println("======是否执行========");
        for (int i=0;i<HttpUtlis.alist.size();i++){
            System.out.println(HttpUtlis.alist.get(i).getName()+"hhh标签数据");

            TabDetailPager tp=new TabDetailPager(mActivity,HttpUtlis.alist.get(i));

            tlist.add(tp);

        }

        System.out.println(tlist.size()+"数据:"+alist.size());


        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return tlist.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {

                System.out.println("显示数据");
                return view==object;
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {


                System.out.println("执行了么");
                TabDetailPager pager = tlist.get(position);

                View view = pager.initView();

                pager.initData();
                container.addView(view);

                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);

                container.removeView((View) object);

            }
        });

        System.out.println(tlist.size()+"=========最后测试数据==========");



    }

    class   NewsAdapter extends  PagerAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }



}
