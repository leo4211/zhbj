package test.liuyang.com.zhbj.impl.menu;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import test.liuyang.com.zhbj.base.BaseMenuDetailPager;
import test.liuyang.com.zhbj.pojo.area;

/**
 * Created by Administrator on 2016/9/21.
 */
public class TabDetailPager extends BaseMenuDetailPager{

    private  area a;
    public TabDetailPager(Activity activity,area a) {
        super(activity);
        this.a=a;

    }
    TextView tv_tile;
    @Override
    public View initView() {

        tv_tile =new TextView(mActivity);

        tv_tile.setTextColor(Color.RED);
        tv_tile.setTextSize(20);
        tv_tile.setGravity(Gravity.CENTER);


        return tv_tile;
    }

    @Override
    public void initData() {


        System.out.println("++++++执行获取数据"+a.getName()+"============");
        tv_tile.setText(a.getName());

    }
}
