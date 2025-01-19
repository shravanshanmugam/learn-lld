package com.shravan.learn.rating;

import lombok.Getter;

import java.util.Objects;

@Getter
public class RatingNumber {
    private final int number;

    public RatingNumber(int number) {
        if (number < 1 || number > 5) throw new IllegalArgumentException();
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RatingNumber)) return false;
        RatingNumber that = (RatingNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "{" +
                "number=" + number +
                '}';
    }
}
