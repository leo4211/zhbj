package test.liuyang.com.zhbj.impl.menu;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.liuyang.com.zhbj.R;
import test.liuyang.com.zhbj.base.BaseMenuDetailPager;

/**
 * Created by Administrator on 2016/9/21.
 */
public class NewsMenuDetail extends BaseMenuDetailPager{


    public ViewPager pager;

    public NewsMenuDetail(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.pager_news_details,null);


        pager = (ViewPager) view.findViewById(R.id.pager_news_menu);


        return view;
    }

    @Override
    public void initData() {

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
