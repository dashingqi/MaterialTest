package com.example.materialdemo1;

/**
 * @ProjectName: MaterialTest
 * @Package: com.example.materialdemo1
 * @ClassName: Fruit
 * @Author: DashingQI
 * @CreateDate: 2018/12/15 11:17 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/15 11:17 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Fruit {
    private String name;
    private int src;

    public Fruit(String name, int
            src) {
        this.name = name;
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public int getSrc() {
        return src;
    }
}
