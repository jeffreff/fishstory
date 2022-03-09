package com.github.jeffreff.fishstory.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.jeffreff.fishstory.domain.Fish;
import com.github.jeffreff.fishstory.service.FishService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

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
        when(service.create(testFish)).thenReturn(testFish);

        assertThat(testFish).isEqualTo(controller.create(testFish));

        verify(service, times(1)).create(testFish);
    }

    @Test
    public void getFishTest() {
        List<Fish> testFishList = new ArrayList<>();

        when(service.readAll()).thenReturn(testFishList);

        assertThat(testFishList).isEqualTo(controller.getFish());

        verify(service, times(1)).readAll();
    }
}
