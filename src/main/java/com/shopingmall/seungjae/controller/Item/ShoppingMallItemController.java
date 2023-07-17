package com.shopingmall.seungjae.controller.Item;

import com.shopingmall.seungjae.domain.Item;
import com.shopingmall.seungjae.repository.ItemRepository;
import com.shopingmall.seungjae.repository.ItemRepositoryImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/items")
@RequiredArgsConstructor
public class ShoppingMallItemController {
    ItemRepository itemRepository = new ItemRepositoryImpl();
    @GetMapping
    public String ItemList(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        log.info("items ={}",items);
        return "item/itemList";
    }

    @GetMapping("/add")
    public String AddPage() {
        return "item/addItemForm";
    }

    @PostMapping("/add")
    public String AddItem(@ModelAttribute Item item, Model model) {
        item.setSellerName("me");
        itemRepository.save(item);
        log.info("item add ={}",item);
        return "redirect:/items";
    }

    @GetMapping("/item/{itemName}")
    public String ItemInformation(@PathVariable(name = "itemName") String findItemName, Model model) {
        Optional<Item> item = itemRepository.findByName(findItemName);
        Item itemNotNull = item.orElse(null); // Optional 객체 언랩
        log.info("findItem = {}",itemNotNull);
        model.addAttribute("item", itemNotNull);
        return "item/item";
    }

    @PostMapping("/item/{itemName}")
    public String ItemDelete(@PathVariable(name = "itemName") String findItemName, Model model) {
        Optional<Item> item = itemRepository.findByName(findItemName);
        Item itemNotNull = item.orElse(null); // Optional 객체 언랩
        log.info("deleteItem = {}",itemNotNull);
        itemRepository.delete(itemNotNull.getItemId());
        return "redirect:/items";
    }

}
