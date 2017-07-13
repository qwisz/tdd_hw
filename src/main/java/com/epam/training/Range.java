package com.epam.training;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
public class Range implements IRange {

    private long lower;
    private long upper;

    public Range(long lower, long upper) {
        if (lower > upper)
            throw new IllegalArgumentException();
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public boolean isBefore(Range otherRange) {
        return this.upper < otherRange.lower;
    }

    @Override
    public boolean isAfter(Range otherRange) {
        return this.lower > otherRange.upper;
    }

    @Override
    public boolean isConcurrent(Range otherRange) {
        return !this.isAfter(otherRange) && !this.isBefore(otherRange);
    }

    @Override
    public long getLowerBound() {
        return this.lower;
    }

    @Override
    public long getUpperBound() {
        return this.upper;
    }

    @Override
    public boolean contains(long value) {
        return value >= lower &&
                value <= upper;
    }

    @Override
    public List<Long> asList() {
        List<Long> result = new ArrayList<>();
        asIterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public Iterator<Long> asIterator() {
        return new Iterator<Long>() {

            private long curInd = lower;

            @Override
            public boolean hasNext() {
                return curInd <= upper;
            }

            @Override
            public Long next() {
                return curInd++;
            }
        };
    }
}
