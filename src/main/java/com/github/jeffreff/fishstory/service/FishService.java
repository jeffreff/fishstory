package com.github.jeffreff.fishstory.service;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.repo.FishRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishService implements FishServiceInterface<Fish> {

    private FishRepo repo;

    public FishService(FishRepo repo) {
        this.repo = repo;
    }

    @Override
    public Fish createFish(Fish fish) {
        return this.repo.save(fish);
    }

    @Override
    public List<Fish> readAllFish() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Fish> readByIdFish(Long id) {
        return this.repo.findById(id);
    }

    @Override
    public Fish updateFish(Long id, Fish fish) {
        return null;
    }

    @Override
    public Fish gutFish(Long id) {
        Optional<Fish> existingFish = this.repo.findById(id);
        Fish changedFish = existingFish.orElseThrow();

        changedFish.setGutted(true);
        return this.repo.save(changedFish);
    }

    @Override
    public boolean deleteAllFish() {
        List<Fish> existingFishList = this.repo.findAll();

        if (!existingFishList.isEmpty()) {
            this.repo.deleteAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByIdFish(Long id) {
        Optional<Fish> existingOptional = this.repo.findById(id);

        if (existingOptional.isPresent()) {
            this.repo.deleteById(id);
            return !(this.repo.existsById(id));
        }
        return false;
    }
}
