package com.github.jeffreff.fishstory.controller;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.service.FishService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FishController {

    private FishService service;

    public FishController(FishService service) {
        this.service = service;
    }

    @PostMapping("/createFish")
    public Fish create(@RequestBody Fish newFish) {
        return this.service.createFish(newFish);
    }

    @GetMapping("/findFish")
    public List<Fish> getFish() {
        return this.service.readAllFish();
    }

    @PutMapping("/gutFish/{id}")
    public Fish gutFish(@PathVariable Long id) {
        return this.service.gutFish(id);
    }
}
