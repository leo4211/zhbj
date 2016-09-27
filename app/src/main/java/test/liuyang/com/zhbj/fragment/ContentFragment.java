package test.liuyang.com.zhbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import test.liuyang.com.zhbj.MainActivity;
import test.liuyang.com.zhbj.R;
import test.liuyang.com.zhbj.base.BasePager;
import test.liuyang.com.zhbj.base.MyViewPager;
import test.liuyang.com.zhbj.customview.SlidingMenu;
import test.liuyang.com.zhbj.impl.GovaffPager;
import test.liuyang.com.zhbj.impl.HomePager;
import test.liuyang.com.zhbj.impl.NewsPager;
import test.liuyang.com.zhbj.impl.SettingsPager;
import test.liuyang.com.zhbj.impl.SmartPager;

/**
 * Created by Administrator on 2016/9/14.
 */
public class ContentFragment extends  BaseFragment {

    List<BasePager>  list;
    MyViewPager viewpager;
    private RadioGroup rgb;




    @Override
    public View initView() {

        final View view = LayoutInflater.from(mActivity).inflate(R.layout.contentfragment, null);

        viewpager= (MyViewPager) view.findViewById(R.id.mviewpager);

        rgb = (RadioGroup) view.findViewById(R.id.rgb);



        rgb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        switch (i){

                            case  R.id.zhengwu:{

                                viewpager.setCurrentItem(3,false);

                            } break;
                            case  R.id.news:{
                                viewpager.setCurrentItem(1,false);
                            }
                            break;
                            case  R.id.setting:{
                                viewpager.setCurrentItem(4,false);
                            }
                            break;
                            case  R.id.smart_service:{
                                viewpager.setCurrentItem(2,false);


                            }
                            break;
                            case  R.id.rb_home:{

                                viewpager.setCurrentItem(0,false);
                            }
                            break;


                        }






            }
        });


        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {

                BasePager pager = list.get(position);
//                View mRootView = pager.mRootView;
                pager.initData();
                MainActivity mainUI= (MainActivity) mActivity;
                mainUI.sdmenu.position=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

    @Override
    public void initData() {

        list=new ArrayList<BasePager>();

        list.add(new HomePager(mActivity));
        list.add(new NewsPager(mActivity));
        list.add(new SmartPager(mActivity));
        list.add(new GovaffPager(mActivity));
        list.add(new SettingsPager(mActivity));


        viewpager.setAdapter(new MyPagerAdapter());




    }


    class MyPagerAdapter extends  PagerAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            BasePager pager = list.get(position);
//            pager.initData();

            View view4 = pager.mRootView;
            container.addView(view4);

            return view4;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            View view4 = list.get(position).mRootView;
            container.removeView(view4);

        }

    }
}
