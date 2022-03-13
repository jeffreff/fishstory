package com.github.jeffreff.fishstory.service;

import java.util.List;
import java.util.Optional;

public interface FishServiceInterface<T> {
    T createFish(T t);

    List<T> readAllFish();

    Optional<T> readByIdFish(Long id);

    T updateFish(Long id, T t);

    T gutFish(Long id);

    boolean deleteAllFish();

    boolean deleteByIdFish(Long id);
}
