package com.epam.training;

import java.util.Iterator;
import java.util.List;

public interface IRange {

    boolean isBefore(Range otherRange);

    boolean isAfter(Range otherRange);

    boolean isConcurrent(Range otherRange);

    long getLowerBound();

    long getUpperBound();

    boolean contains(long value);

    List<Long> asList();

    Iterator<Long> asIterator();
}
