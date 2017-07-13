package com.epam.training;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RangeTest {

    private Range range;
    private Range nRange;
    private Range pRange;

    @Before
    public void setUp() throws Exception {
        range = new Range(-100, 100);
        nRange = new Range(-200, - 1);
        pRange = new Range(1, 300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatWeCantCreateWithIllegalParameters() {
        Range r = new Range(30, 20);
    }

    @Test
    public void testThatWeCanCreateWithOneElement() {
        Range r = new Range(30, 30);

    }

    @Test
    public void testThatIsBeforeMethodWorksCorrectly() {
        Range r = new Range(-300, -201);
        Range rr = new Range(-100, 0);

        assertTrue(r.isBefore(nRange));
        assertTrue(r.isBefore(range));

        assertTrue(rr.isBefore(pRange));
        assertFalse(rr.isBefore(range));
        assertFalse(rr.isBefore(nRange));
    }

    @Test
    public void testThatIsAfterMethodWorksCorrectly() {
        Range r = new Range(301, 303);
        Range rr = new Range(110, 200);

        assertTrue(r.isAfter(range));
        assertTrue(r.isAfter(pRange));
        assertTrue(r.isAfter(nRange));

        assertFalse(rr.isAfter(pRange));
        assertTrue(rr.isAfter(range));
    }

    @Test
    public void testThatIsConcurrentMethodWorksCorrectly() {
        Range r = new Range(301, 303);
        Range rr = new Range(50, 200);

        assertFalse(r.isConcurrent(range));
        assertFalse(r.isConcurrent(pRange));
        assertFalse(r.isConcurrent(nRange));

        assertTrue(rr.isConcurrent(range));
        assertTrue(rr.isConcurrent(pRange));
        assertFalse(rr.isConcurrent(nRange));
    }

    @Test
    public void testThatGetLowerMethodWorksCorrectly() {

        assertEquals(-100, range.getLowerBound());
        assertEquals(-200, nRange.getLowerBound());
        assertEquals(1, pRange.getLowerBound());
    }

    @Test
    public void testThatGetUpperMethodWorksCorrectly() {

        assertEquals(100, range.getUpperBound());
        assertEquals(-1, nRange.getUpperBound());
        assertEquals(300, pRange.getUpperBound());
    }

    @Test
    public void testThatContainsMethodWorksCorrectly() {
        for (int i = -100; i < 101; i++) {
            assertTrue(range.contains(i));
        }
        assertFalse(range.contains(1000));

        assertFalse(nRange.contains(-100000));
        assertFalse(pRange.contains(100000));
    }

    @Test
    public void testThatAsListMethodWorksCorrectly() {
        List<Long> list = new ArrayList<>();
        for (long i = range.getLowerBound(); i < range.getUpperBound() + 1; i++) {
            list.add(i);
        }

        assertEquals(list, range.asList());

        List<Long> list2 = new ArrayList<>();
        for (long i = pRange.getLowerBound(); i < pRange.getUpperBound() + 1; i++) {
            list2.add(i);
        }

        assertEquals(list2, pRange.asList());

        List<Long> list3 = new ArrayList<>();
        for (long i = nRange.getLowerBound(); i < nRange.getUpperBound() + 1; i++) {
            list3.add(i);
        }

        assertEquals(list3, nRange.asList());
    }
}
