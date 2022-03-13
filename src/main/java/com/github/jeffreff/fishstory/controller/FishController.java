package com.github.jeffreff.fishstory.controller;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.service.FishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FishController {

    private FishService service;

    public FishController(FishService service) {
        this.service = service;
    }

    @PostMapping("/createFish")
    public Fish createFish(@RequestBody Fish newFish) {
        return this.service.createFish(newFish);
    }

    @GetMapping("/readFish")
    public List<Fish> readFish() {
        return this.service.readAllFish();
    }

    @GetMapping("readFish/{id}")
    public Optional<Fish> readByIdFish(@PathVariable Long id) {
        return this.service.readByIdFish(id);
    }

    @PutMapping("/gutFish/{id}")
    public Fish gutFish(@PathVariable Long id) {
        return this.service.gutFish(id);
    }

    @DeleteMapping("/deleteFish/{id}")
    public Boolean deleteByIdFish(@PathVariable Long id) {
        return this.service.deleteByIdFish(id);
    }
}
