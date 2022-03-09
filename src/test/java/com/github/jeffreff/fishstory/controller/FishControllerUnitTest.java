package com.github.jeffreff.fishstory.controller;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.service.FishService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FishControllerUnitTest {

    private Fish testFish;

    @MockBean
    private FishService service;

    @Autowired
    private FishController controller;

    @BeforeEach
    void testSetUp() {
        testFish = new Fish(1L, "Salmon", 4.5, false);
    }

    @Test
    public void createTest() {
        when(service.createFish(testFish)).thenReturn(testFish);

        assertThat(testFish).isEqualTo(controller.create(testFish));

        verify(service, times(1)).createFish(testFish);
    }

    @Test
    public void getFishTest() {
        List<Fish> testFishList = new ArrayList<>();

        when(service.readAllFish()).thenReturn(testFishList);

        assertThat(testFishList).isEqualTo(controller.getFish());

        verify(service, times(1)).readAllFish();
    }

    @Test
    public void gutFishTest() {
        Long id = 1L;

        when(service.gutFish(id)).thenReturn(testFish);

        assertThat(testFish).isEqualTo(controller.gutFish(id));

        verify(service, times(1)).gutFish(id);
    }

    @Test
    public void deleteFishByIdTest() {
        Long id = 1L;

        when(service.deleteFishById(id)).thenReturn(true);

        boolean actual = this.controller.deleteFishById(id);

        assertThat(actual).isTrue();

        verify(service, times(1)).deleteFishById(id);
    }
}
