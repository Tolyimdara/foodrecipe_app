package com.tangeamseng.foodsstore.model;

public class headmodel {
    private int headimage;
    private String headtittle;

    public headmodel(int headimage, String headtittle) {
        this.headimage = headimage;
        this.headtittle = headtittle;
    }

    public int getHeadimage() {
        return headimage;
    }

    public void setHeadimage(int headimage) {
        this.headimage = headimage;
    }

    public String getHeadtittle() {
        return headtittle;
    }

    public void setHeadtittle(String headtittle) {
        this.headtittle = headtittle;
    }
}
