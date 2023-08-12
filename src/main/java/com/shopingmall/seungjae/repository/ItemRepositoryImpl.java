//package com.shopingmall.seungjae.repository;
//
//import com.shopingmall.seungjae.domain.Item;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@Slf4j
//@RequiredArgsConstructor
//public class ItemRepositoryImpl implements ItemRepository{
//
//    private static HashMap<Long, Item> itemStore = new HashMap<>();
//    private static long sequence = 0L;
//
//    @Override
//    public Item findById(Long itemId) {
//        Item item = itemStore.get(itemId);
//        return item;
//    }
//    @Override
//    public Item save(Item item) {
//        item.setItemId(++sequence);
//        itemStore.put(item.getItemId(), item);
//        log.info("item save ={}",item);
//        return item;
//    }
//
//    @Override
//    public List<Item> findByName(String name) {
//        return findAll().stream()
//                .filter(
//                item -> item.getItemName().equals(name)
//        ).findFirst();
//    }
//
//    @Override
//    public List<Item> findAll() {
//        return new ArrayList<>(itemStore.values());
//    }
//
//    @Override
//    public void delete(Long deleteId) {
//        itemStore.remove(deleteId);
//    }
//
//    @Override
//    public void clearStore() {
//        itemStore.clear();
//    }
//}
