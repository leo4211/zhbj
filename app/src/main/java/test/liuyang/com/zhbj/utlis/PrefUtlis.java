package test.liuyang.com.zhbj.utlis;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by leo on 2016/9/13.
 *
 *
 */
public class PrefUtlis {

    public  static boolean   getBoolean(Context context,String key,boolean defaultvalue){


        SharedPreferences config = context.getSharedPreferences("config", context.MODE_PRIVATE);

        boolean b = config.getBoolean(key, defaultvalue);

        return  b;
    }

    public  static void    setBoolean(Context context,String key,boolean defaultvalue){


        SharedPreferences config = context.getSharedPreferences("config", context.MODE_PRIVATE);

        SharedPreferences.Editor editor = config.edit();

        editor.putBoolean(key,false);

        editor.commit();

    }


}
