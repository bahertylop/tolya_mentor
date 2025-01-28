package org.example.glav3.complex_number;

import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ComplexNumber that)) return false;
        return Double.compare(re, that.re) == 0 && Double.compare(im, that.im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}