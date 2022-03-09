package com.github.jeffreff.fishstory.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.repo.FishRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void createTest() {

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
    public void gutFishTest() {
        Long id = 1L;
        Fish testGuttedFish = new Fish(id, "Salmon", 4.5, true);
        Optional<Fish> testOptionalFish = Optional.ofNullable(testFish);

        when(repo.findById(id)).thenReturn(testOptionalFish);
        when(this.repo.save(any(Fish.class))).thenReturn(testGuttedFish);

        Fish result = this.service.gutFish(1L, testFish);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(testGuttedFish);


        verify(repo, times(1)).findById(id);
        verify(repo, times(1)).save(any(Fish.class));
    }
}
