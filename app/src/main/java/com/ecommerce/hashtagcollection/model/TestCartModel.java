package com.ecommerce.hashtagcollection.model;

public class TestCartModel {
    private int productId;
    private String productTitle;
    private String productDesc;
    private int productItems;
    private int productPrice;
    private int productImage;


    public TestCartModel(int productId, String productTitle, String productDesc, int productItems, int productPrice, int productImage) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productItems = productItems;
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle)
    {
        this.productTitle = productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductItems() {
        return productItems;
    }

    public void setProductItems(int productItems) {
        this.productItems = productItems;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
