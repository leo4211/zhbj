package test.liuyang.com.zhbj.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/9/14.
 */
public class SlidingMenu extends HorizontalScrollView {

    private LinearLayout mWapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private  int mScreen;
    private  int mMenuRightPadding=100;
    private  int mMenuwidth;
    private  boolean once;
    public   int position;
    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);

        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);

        mScreen=metrics.widthPixels;

        mMenuRightPadding= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,context.getResources().getDisplayMetrics());


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if(!once){
            mWapper= (LinearLayout) getChildAt(0);
            mMenu= (ViewGroup) mWapper.getChildAt(0);
            mContent= (ViewGroup) mWapper.getChildAt(1);
            mMenuwidth=mMenu.getLayoutParams().width=mScreen-mMenuRightPadding;
            mContent.getLayoutParams().width=mScreen;
            mWapper.getLayoutParams().width=mScreen;
            once=true;
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        System.out.println("触发了数据的改变");

        if (changed){

            System.out.println(mMenuwidth+"========拉长的距离=====");

            this.scrollTo(mMenuwidth,0);

        }

    }


    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {

        System.out.println("滑动拦截=====");
        return false;
    }




    @Override
    public boolean onTouchEvent(MotionEvent ev) {


        int action = ev.getAction();

        switch (action){
            case  MotionEvent.ACTION_MOVE:{

                if(position==0||position==4){

                    return true;
                }else{

                    return super.onTouchEvent(ev);

                }
            }


            case  MotionEvent.ACTION_UP:{

                int scrollx=getScrollX();


                    if(scrollx>=mMenuwidth/2){

                        this.smoothScrollTo(mMenuwidth,0);

                    }else{

                        this.smoothScrollTo(0,0);
                    }

                return true;

            }



        }




        return super.onTouchEvent(ev);
    }



}
