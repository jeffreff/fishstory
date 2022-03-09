package com.github.jeffreff.fishstory.repo;

import com.github.jeffreff.fishstory.domain.Fish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepo extends JpaRepository<Fish, Long> {

}
