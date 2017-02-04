package com.shopping.domain;

/**
 * Created by 22arsh on 1/25/17.
 */
public class product {
    private int id;
    private String name;
    private String code;
    private double price;
    private int stock;

    public product(int id,String name,String code,double price,int stock)
    {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.stock = stock;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
