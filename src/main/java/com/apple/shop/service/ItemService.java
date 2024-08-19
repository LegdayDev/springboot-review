package com.apple.shop.service;

import com.apple.shop.entity.Item;
import com.apple.shop.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(String title, Integer price){
        Item item = new Item();
        if (title.length() > 0 && !title.isBlank() && !title.isEmpty() && price > 0) {
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }
    }

    public Item findItem(String id) {
        Optional<Item> findItem = itemRepository.findById(Long.parseLong(id));
        if (!findItem.isPresent()) {
            throw new EntityNotFoundException("엔티티를 찾을 수 없습니다!");
        }

        return findItem.get();
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    @Transactional
    public void updateItem(String id, String title, Integer price) {
        Item item = findItem(id);

        item.setTitle(title);
        item.setPrice(price);
    }

    @Transactional
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }
}
