package test.liuyang.com.zhbj;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import test.liuyang.com.zhbj.customview.SlidingMenu;
import test.liuyang.com.zhbj.fragment.ContentFragment;

public class MainActivity extends AppCompatActivity {


    private FrameLayout content;
    public SlidingMenu sdmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setMenu(toolbar,);

        content = (FrameLayout) findViewById(R.id.content);

        sdmenu = (SlidingMenu) findViewById(R.id.sl_01);


        initFragment();
    }


    private  void  initFragment(){


        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.content,new ContentFragment());

        ft.commit();



    }
}
