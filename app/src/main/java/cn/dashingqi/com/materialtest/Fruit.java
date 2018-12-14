package cn.dashingqi.com.materialtest;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/14<p>
 * <p>更改时间：2018/12/14<p>
 * <p>版本号：1<p>
 */
public class Fruit {
    private int src;
    private String name;

    public Fruit(int src, String name) {
        this.src = src;
        this.name = name;
    }

    public int getSrc() {
        return src;
    }

    public String getName() {
        return name;
    }
}
