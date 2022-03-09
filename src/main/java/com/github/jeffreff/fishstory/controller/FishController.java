package com.github.jeffreff.fishstory.controller;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.service.FishService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController {

    private FishService service;

    public FishController(FishService service) {
        this.service = service;
    }

    @PostMapping("/createFish")
    public Fish create(@RequestBody Fish newFish) {
        return this.service.create(newFish);
    }
}