package com.github.jeffreff.fishstory.service;

import java.util.List;
import java.util.Optional;

public interface CRUDServiceInterface<T> {
    T create(T t);

    List<T> readAll();

    Optional<T> readById(Long id);

    T update(Long id, T t);

    boolean delete(Long id);
}
