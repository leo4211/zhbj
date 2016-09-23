package test.liuyang.com.zhbj.pojo;

import test.liuyang.com.zhbj.impl.menu.TabDetailPager;

/**
 * Created by Administrator on 2016/9/22.
 */
public class area {

    private  String id;
    private String name;

    public area(String id, String name) {
        this.id=id;
        this.name = name;
    }

    public area() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
