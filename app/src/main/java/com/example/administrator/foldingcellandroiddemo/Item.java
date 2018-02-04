package com.example.administrator.foldingcellandroiddemo;

import java.util.ArrayList;

/**
 * Simple POJO model for example
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Item {

    private int titleImage;
    private String titleText;
    private int cotentImage;
    private int contentText1;
    private int contentText2;

    public Item() {
    }

    public Item(int titleImage, String titleText, int cotentImage, int contentText1, int contentText2) {
        this.titleImage = titleImage;
        this.titleText = titleText;
        this.cotentImage = cotentImage;
        this.contentText1 = contentText1;
        this.contentText2 = contentText2;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(int titleImage) {
        this.titleImage = titleImage;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public int getCotentImage() {
        return cotentImage;
    }

    public void setCotentImage(int cotentImage) {
        this.cotentImage = cotentImage;
    }

    public int getContentText1() {
        return contentText1;
    }

    public void setContentText1(int contentText1) {
        this.contentText1 = contentText1;
    }

    public int getContentText2() {
        return contentText2;
    }

    public void setContentText2(int contentText2) {
        this.contentText2 = contentText2;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.san_miguel_de_allende2, "聖米格爾德阿連德", R.drawable.san_miguel_de_allende5, R.string.content_area_san_miguel_de_allende, R.string.content_introduction_san_miguel_de_allende));
        items.add(new Item(R.drawable.florence2, "佛羅倫斯", R.drawable.florence5, R.string.content_area_florence, R.string.content_introduction_florence));
        items.add(new Item(R.drawable.ubud2, "烏布", R.drawable.ubud5, R.string.content_area_ubud, R.string.content_introduction_ubud));
        items.add(new Item(R.drawable.luang_prabang2, "龍坡邦", R.drawable.luang_prabang5, R.string.content_area_luang_prabang, R.string.content_introduction_luang_prabang));
        items.add(new Item(R.drawable.rome2, "羅馬", R.drawable.rome5, R.string.content_area_rome, R.string.content_introduction_rome));
        items.add(new Item(R.drawable.barcelona2, "巴賽隆納", R.drawable.barcelona5, R.string.content_area_barcelona, R.string.content_introduction_barcelona));
        return items;
    }
}
