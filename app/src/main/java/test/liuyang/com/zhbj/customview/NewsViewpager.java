package test.liuyang.com.zhbj.customview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/9/27.
 */
public class NewsViewpager extends ViewPager {

    private float startX;
    private float startY;

    public NewsViewpager(Context context) {
        super(context);
    }

    public NewsViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = ev.getRawX();
                startY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                //判断是左右滑动还是上下滑动
                float endX = ev.getRawX();
                float endY = ev.getRawY();
                if (Math.abs(endX - startX) > Math.abs(endY - startY) ){
                    //如果是左右滑动，请求父控件不要拦截自己的
                    System.out.println("滑动到下一个");
                    getParent().requestDisallowInterceptTouchEvent(true);
                }else {
                    //如果是上下滑动，拦截设置为false
                    getParent().requestDisallowInterceptTouchEvent(false);
                }


                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }


}
