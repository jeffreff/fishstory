package com.github.jeffreff.fishstory.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.repo.FishRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class FishServiceUnitTest {

    private Fish testFish;

    @MockBean
    private FishRepo repo;

    @Autowired
    FishService service;

    @BeforeEach
    void testSetUp() {
        testFish = new Fish(1L, "Salmon", 4.5, false);
    }

    @Test
    public void createFishTest() {

        when(repo.save(testFish)).thenReturn(testFish);

        assertThat(testFish).isEqualTo(service.createFish(testFish));

        verify(repo, times(1)).save(testFish);
    }

    @Test
    public void readAllTest() {
        List<Fish> testFishList = new ArrayList<>();
        when(repo.findAll()).thenReturn(testFishList);

        assertThat(testFishList).isEqualTo(service.readAllFish());

        verify(repo, times(1)).findAll();
    }

    @Test
    public void readByIdFishTest() {
        Long id = 1L;
        Optional<Fish> testOptionalFish = Optional.ofNullable(testFish);

        when(repo.findById(id)).thenReturn(testOptionalFish);

        assertThat(testOptionalFish).isEqualTo(service.readByIdFish(id));

        verify(repo, times(1)).findById(id);
    }

    @Test
    public void gutFishTest() {
        Long id = 1L;
        Fish testGuttedFish = new Fish(id, "Salmon", 4.5, true);
        Optional<Fish> testOptionalFish = Optional.ofNullable(testFish);

        when(repo.findById(id)).thenReturn(testOptionalFish);
        when(this.repo.save(any(Fish.class))).thenReturn(testGuttedFish);

        Fish result = this.service.gutFish(1L);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(testGuttedFish);

        verify(repo, times(1)).findById(id);
        verify(repo, times(1)).save(any(Fish.class));
    }

    @Test
    public void deleteAllFishTest() {
        List<Fish> testFishList = List.of(
                new Fish(1L, "Salmon", 4.5, false),
                new Fish(2L, "Carp", 5.5, false),
                new Fish(3L, "Bass", 6.5, false));

        when(repo.findAll()).thenReturn(testFishList);

        this.service.deleteAllFish();

        assertThat(this.repo.count() == 0);
        verify(this.repo, times(1)).findAll();
        verify(this.repo, times(1)).deleteAll();
    }

    @Test
    public void deleteAllFishFalseTest() {
        List<Fish> testFishList = Collections.emptyList();

        when(repo.findAll()).thenReturn(testFishList);

        this.service.deleteAllFish();

        assertThat(this.repo.count() == 0);
        verify(this.repo, times(1)).findAll();
        verify(this.repo, times(0)).deleteAll();
    }

    @Test
    public void deleteByIdFishTest() {
        Long id = 1L;

        when(repo.findById(id)).thenReturn(Optional.of(testFish));

        this.service.deleteByIdFish(id);

        verify(this.repo, times(1)).deleteById(id);
    }

    @Test
    public void deleteByIdFishFalseTest() {
        Long id = 1L;

        when(repo.findById(id)).thenReturn(Optional.empty());

        this.service.deleteByIdFish(id);

        verify(this.repo, times(0)).deleteById(id);
    }
}
