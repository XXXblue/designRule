package com.designRule.utils;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2816:34
 * @Description: 临时的一个ExcelExportSXXSSF测试类
 * @Modified By:
 */
public class Ypxx {
    private String bm;
    private String mc;
    private float price;
    private String failMsg;

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public Ypxx(String bm, String mc, float price) {
        this.bm = bm;
        this.mc = mc;
        this.price = price;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
