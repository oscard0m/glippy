package com.glippy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Item {
    @Id
    private String id;

    @TextIndexed
    private String name;

    @TextIndexed
    private String description;

    private List<Price> prices = new ArrayList<Price>();



    // Constructors

    public Item(String id, String name, String description, ArrayList<Price> prices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prices = prices;
    }

    public Item(String itemName, double price, String supermarket) {
        this.name = itemName;
        this.prices.add(new Price(supermarket, price));
    }

    public Item(String itemName) {
        this.name = itemName;
        this.prices.add(new Price("mercadona",0.0));
    }

    public Item(String itemName, String supermarket, double price) {
        this.name = itemName;
        this.prices.add(new Price (supermarket,price));
    }

    public Item(String itemName, Price price) {
        this.name = itemName;
        this.prices.add(price);
    }


    // Getters

    public String getId() {
        return id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }



    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Equals & Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (!name.equals(item.name)) return false;
        if (prices != null ? !prices.equals(item.prices) : item.prices != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (prices != null ? prices.hashCode() : 0);
        return result;
    }


    // Other

    public void addPrice(String supermarket, double price) {
        this.prices.add(new Price(supermarket,price));
    }


















}
