package com.apple.shop.web;

import com.apple.shop.entity.Item;
import com.apple.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model){
        for (Item item : itemRepository.findAll()) {
            System.out.println("item = " + item);
        }
        model.addAttribute("items", itemRepository.findAll());
        return "list";
    }
}
