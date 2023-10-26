package com.example.secure.secureapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemController {

    @GetMapping("")
    public ResponseEntity<ItemsDto> getAllItems() {
        var items = new ItemsDto(List.of("Samsung Smart phone", "Samsung Smart watch", "M1 Macbook AIR"));
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
