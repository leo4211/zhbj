package test.liuyang.com.zhbj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import test.liuyang.com.zhbj.utlis.PrefUtlis;

/**
 * creat by leo
 *     闪屏页面
 */

public class Splashctivity extends AppCompatActivity {



    private RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        root = (RelativeLayout) findViewById(R.id.rl_root);


        RotateAnimation  animRotate=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        animRotate.setDuration(2000);

        animRotate.setFillAfter(true);




        ScaleAnimation  scaleAnimation=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        scaleAnimation.setDuration(2000);

        scaleAnimation.setFillAfter(true);


        AnimationSet  set=new AnimationSet(true);

        set.addAnimation(scaleAnimation);
        set.addAnimation(animRotate);


        root.startAnimation(set);


        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            /**
             *
             * @param animation
             */
            @Override
            public void onAnimationEnd(Animation animation) {

                // 如果是第一次判断

//                SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
//
//                boolean is_first_enter = config.getBoolean("is_first_enter", true);

                boolean is_first_enter = PrefUtlis.getBoolean(Splashctivity.this, "is_first_enter", true);


                if(is_first_enter){

                      //新手引导页
//                    PrefUtlis.setBoolean(Splashctivity.this,"is_first_enter",false);



                    startActivity(new Intent(Splashctivity.this,GuideActivity.class));
                    finish();

                }else{

                        //  进入主页


                    startActivity(new Intent(Splashctivity.this,MainActivity.class));

                    finish();



                }



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }
}
