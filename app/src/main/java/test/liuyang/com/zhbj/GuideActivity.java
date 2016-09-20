package test.liuyang.com.zhbj;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import test.liuyang.com.zhbj.utlis.PrefUtlis;

public class GuideActivity extends AppCompatActivity {

    private ViewPager pager;

    private  int pointDis;

    ArrayList<ImageView> imageViewArrayList;

    LinearLayout  lconter;

    private  int[] Imagesid={R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    private ImageView img_red_poiont;
    Button btn_experience;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);

        img_red_poiont = (ImageView) findViewById(R.id.img_red_point);
        btn_experience= (Button) findViewById(R.id.btn_experience);

        lconter= (LinearLayout) findViewById(R.id.ln_conter);

        initData();
        pager = (ViewPager) findViewById(R.id.viewpager);


        pager.setAdapter(new MyPagerAdapter());

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //页面滑动的过程中


                int dis= (int) (pointDis * positionOffset)+position*pointDis;

                RelativeLayout.LayoutParams  params= (RelativeLayout.LayoutParams) img_red_poiont.getLayoutParams();

                params.leftMargin=dis;

                img_red_poiont.setLayoutParams(params);

            }

            @Override
            public void onPageSelected(int position) {
            //页面被选中

                if (position==2){
                    btn_experience.setVisibility(View.VISIBLE);

                }else{
                    btn_experience.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            // 页面滑动状态发生变化


            }
        });

        img_red_poiont.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                img_red_poiont.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                pointDis=lconter.getChildAt(1).getLeft()-lconter.getChildAt(0).getLeft();

            }
        });

        btn_experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PrefUtlis.setBoolean(GuideActivity.this,"is_first_enter",false);

                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();



            }
        });


    }

    private   void  initData(){

        imageViewArrayList=new ArrayList<ImageView>();
        for (int i=0;i<Imagesid.length;i++){

            ImageView  view=new ImageView(this);
            view.setBackgroundResource(Imagesid[i]);
            imageViewArrayList.add(view);

            ImageView  point=new ImageView(this);
            point.setImageResource(R.drawable.shape_point_gray);

//            point.

            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            if(i>0){
                params.leftMargin=10;

            }

            point.setLayoutParams(params);
            lconter.addView(point);




        }

    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageViewArrayList.size();
        }


        //判断当前的Object 是否是一个view对象
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        //初始化item的布局
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView view = imageViewArrayList.get(position);
            container.addView(view);
            return view;
        }


        //销毁一个布局
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);

        }
    }
}
