package com.apple.shop.web;

import com.apple.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class ItemController {
    private final ItemService itemService;

    @GetMapping({"/list", "/"})
    public String list(Model model) {
        model.addAttribute("items", itemService.findAllItem());
        return "list";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam Integer price) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        try {
            model.addAttribute("item", itemService.findItem(id));
            return "detail";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/list";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("item", itemService.findItem(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @RequestParam String title, @RequestParam Integer price) {
        try {
            itemService.updateItem(id, title, price);
            return "redirect:/detail/" + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/list";
        }

    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            itemService.deleteItem(itemService.findItem(id));
            return ResponseEntity.ok().body("삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("삭제 실패");
        }
    }
}

