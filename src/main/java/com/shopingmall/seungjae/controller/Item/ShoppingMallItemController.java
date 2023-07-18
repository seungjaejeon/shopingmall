package com.shopingmall.seungjae.controller.Item;

import com.shopingmall.seungjae.controller.Member.SessionConst;
import com.shopingmall.seungjae.domain.Item;
import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.ItemRepository;
import com.shopingmall.seungjae.repository.ItemRepositoryImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public String AddPage(@ModelAttribute Item item,Model model) {
        model.addAttribute("items", item);
        return "item/addItemForm";
    }

    @PostMapping("/add")
    public String AddItem(@ModelAttribute Item item, BindingResult bindingResult, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        if (!StringUtils.hasText(item.getItemName())){
            bindingResult.addError(new FieldError("items","itemName", "상품 이름이 올바르지 않습니다."));
        }
        if (item.getPrice()<0){
            bindingResult.addError(new FieldError("items","price", "상품 가격이 올바르지 않습니다."));
        }
        if (!StringUtils.hasText(item.getItemName())){
            bindingResult.addError(new FieldError("items","itemDescription", "상품 설명이 올바르지 않습니다."));
        }
        if (bindingResult.hasErrors()) {
            log.info("상품 추가 오류 발생 bindingResult = {}",bindingResult);
            return "item/addItemForm";
        }
        item.setSellerName(loginMember.getName());
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
    public String ItemDelete(@PathVariable(name = "itemName") String findItemName, Model model,
                             @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        Optional<Item> item = itemRepository.findByName(findItemName);
        Item itemNotNull = item.orElse(null); // Optional 객체 언랩
        if(loginMember.getName().equals(itemNotNull.getSellerName())&&loginMember!=null&&itemNotNull!=null) {
            log.info("deleteItem = {}", itemNotNull);
            itemRepository.delete(itemNotNull.getItemId());
            return "redirect:/items";
        }
        else{
            model.addAttribute("item", itemNotNull);
            model.addAttribute("deleteError","본인의 제품이 아닐경우 삭제하실 수 없습니다.");
            return "item/item";
        }
    }

}
