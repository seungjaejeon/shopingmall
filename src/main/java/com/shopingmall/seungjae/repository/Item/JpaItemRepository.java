package com.shopingmall.seungjae.repository.Item;

import com.shopingmall.seungjae.domain.Item;
import com.shopingmall.seungjae.repository.Item.ItemRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class JpaItemRepository implements ItemRepository {
    private final EntityManager em;
    @Autowired
    public JpaItemRepository(EntityManager em) {
        this.em = em;
    } // 생성자 주입

    @Override
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public List<Item> findByName(String itemName) {
        List<Item> items = em.createQuery("select i from Item i where i.itemName = :itemName",Item.class)
                .setParameter("itemName", itemName)
                .getResultList();
        return items;
    }

    @Override
    public Item findById(Long itemId) {
        Item item = em.find(Item.class, itemId);
        return item;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = em.createQuery("select i from Item i", Item.class).getResultList();
        return items;
    }

    @Override
    public void delete(Long deleteId) {
        Item item = findById(deleteId);
        em.remove(item);
    }

}
