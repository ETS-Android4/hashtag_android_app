package com.ecommerce.hashtagcollection.model;

public class CartModel {
    private String productId;
    private String productTitle;
    private int productItems;
    private int totalPrice;
    private int productImage;
    private int productInStock;
    private int productPerItemPrice;

    public CartModel(String productId, String productTitle, int productItems, int totalPrice, int productImage, int productInStock, int productPerItemPrice) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productItems = productItems;
        this.totalPrice = totalPrice;
        this.productImage = productImage;
        this.productInStock = productInStock;
        this.productPerItemPrice = productPerItemPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductItems() {
        return productItems;
    }

    public void setProductItems(int productItems) {
        this.productItems = productItems;
    }

    public int getProductPrice() {
        return totalPrice;
    }

    public void setProductPrice(int productPrice) {
        this.totalPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(int productInStock) {
        this.productInStock = productInStock;
    }

    public int getProductPerItemPrice() {
        return productPerItemPrice;
    }

    public void setProductPerItemPrice(int productPerItemPrice) {
        this.productPerItemPrice = productPerItemPrice;
    }
}