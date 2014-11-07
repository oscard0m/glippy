package com.glippy.shopping.services;

import com.glippy.domain.ItemRepository;
import com.glippy.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    // Requets for ALL --- Items

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getAllItems(ModelMap model) {
        model.addAttribute("items", itemRepository.findAll());
        return "/allItems";
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAllItems(ModelMap model) {
        //TODO
        //model.addAttribute("items", itemsRepository.update());
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllItems() {
        itemRepository.deleteAll();
    }


    // Requests BY NAME --- Shopping Lists

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody Item item, ModelMap model) {
        itemRepository.save(item);
    }

    @RequestMapping(value = {"/{itemName}"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getItem(@PathVariable String itemName, ModelMap model) {
        model.addAttribute("item", itemRepository.findByName(itemName));
        return "/allItems";
    }

    @RequestMapping(value = {"/{itemName}"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@PathVariable String itemName, @RequestBody Item item, ModelMap model) {
        //TODO
        //itemRepository.update(itemName, item);
    }

    @RequestMapping(value = "/{itemName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable String itemName) {
        itemRepository.deleteByName(itemName);
    }
}