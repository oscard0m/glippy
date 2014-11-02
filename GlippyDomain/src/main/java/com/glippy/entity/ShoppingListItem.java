package com.glippy.entity;

/**
 * Created by oscar on 01/11/2014.
 */

public class ShoppingListItem {
    private String name;
    private int quantity;

    public ShoppingListItem() {
    }

    public ShoppingListItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ShoppingListItem(String itemName) {
        this.name = itemName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingListItem that = (ShoppingListItem) o;

        if (quantity != that.quantity) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
