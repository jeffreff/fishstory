package com.github.jeffreff.fishstory.service;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.repo.FishRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishService implements CRUDServiceInterface<Fish> {

    private FishRepo repo;

    public FishService(FishRepo repo) {
        this.repo = repo;
    }

    @Override
    public Fish create(Fish fish) {
        return this.repo.save(fish);
    }

    @Override
    public List<Fish> readAll() {
        return null;
    }

    @Override
    public Optional<Fish> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public Fish update(Long id, Fish fish) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
