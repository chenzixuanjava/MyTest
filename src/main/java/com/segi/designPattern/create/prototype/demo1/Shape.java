package com.segi.designPattern.create.prototype.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 4:53
 */
public abstract class Shape implements Cloneable{
    protected String type;
    private String id;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
}
