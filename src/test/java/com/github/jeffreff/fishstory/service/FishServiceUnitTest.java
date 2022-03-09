package com.github.jeffreff.fishstory.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void createTest() {

        when(repo.save(testFish)).thenReturn(testFish);

        assertThat(testFish).isEqualTo(service.create(testFish));

        verify(repo, times(1)).save(testFish);
    }
}
