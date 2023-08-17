package com.shopingmall.seungjae.repository.Item;

import com.shopingmall.seungjae.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository {
    Item save(Item item);
    List<Item> findByName(String itemName);
    Item findById(Long itemId);
    List<Item> findAll();
    void delete(Long deleteId);
}
