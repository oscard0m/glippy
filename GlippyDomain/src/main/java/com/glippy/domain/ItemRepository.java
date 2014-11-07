package com.glippy.domain;

import com.glippy.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ItemRepository extends CrudRepository<Item, String> {

    ArrayList<Item> findByName(String itemName);

    ArrayList<Item> deleteByName(String itemName);
}
