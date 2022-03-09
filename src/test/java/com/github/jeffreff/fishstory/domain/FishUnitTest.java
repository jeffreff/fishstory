package com.github.jeffreff.fishstory.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class FishUnitTest {

    private Fish testFish;
    private Object notFish;

    @BeforeEach
    void testSetUp() {
        testFish = new Fish(1L, "Salmon", 4.5, false);
    }

    @Test
    void gettersTest() {
        assertEquals(1L, testFish.getId());
        assertEquals("Salmon", testFish.getType());
        assertEquals(4.5, testFish.getWeight());
        assertFalse(testFish.isGutted());
    }

    @Test
    void settersTest() {
        assertNotNull(testFish.getId());
        assertNotNull(testFish.getType());

        testFish.setId(null);
        assertNull(testFish.getId());
        testFish.setType(null);
        assertNull(testFish.getType());
        testFish.setWeight(0);
        assertEquals(0, testFish.getWeight());
        testFish.setGutted(true);
        assertTrue(testFish.isGutted());
    }

    @Test
    void emptyConstructorTest() {
        Fish defaultFish = new Fish();
        assertNull(defaultFish.getId());
        assertEquals("DEFAULT", defaultFish.getType());
        assertEquals(99.99, defaultFish.getWeight());
        assertFalse(defaultFish.isGutted());
    }

    @Test
    void fullConstructorTest() {
        Fish myFish = new Fish(5L, "Carp", 50.50, false);
        assertEquals(5L, myFish.getId());
        assertEquals("Carp", myFish.getType());
        assertEquals(50.50, myFish.getWeight());
        assertFalse(myFish.isGutted());
    }

    @Test
    void noIdConstructorTest() {
        Fish myFish = new Fish("Carp", 50.50, false);
        assertNull(myFish.getId());
        assertEquals("Carp", myFish.getType());
        assertEquals(50.50, myFish.getWeight());
        assertFalse(myFish.isGutted());
    }

    @Test
    void equalsSameObjectTest() {
        assertTrue(testFish.equals(testFish));
    }

    @Test
    void equalsMissingObjectTest() {
        assertFalse(testFish.equals(notFish));
    }

    @Test
    void equalsTrueTest() {
        Fish testFish2 = new Fish(1L, "Salmon", 4.5, false);
        assertTrue(testFish.equals(testFish2));
    }

    @Test
    void equalsFalseTest() {
        Fish testFish2 = new Fish(7L, "Carp", 10.10, false);
        assertFalse(testFish.equals(testFish2));
    }

    @Test
    void hashCodeTest() {
        int testHash = Objects.hash(testFish.getId(), testFish.getType(), testFish.getWeight(), testFish.isGutted());
        assertEquals(testHash, testFish.hashCode());
    }

    @Test
    void toStringTest() {
        String toString = "Fish{id=1, type='Salmon', weight=4.5, isGutted=false}";
        assertEquals(toString, testFish.toString());

    }
}