package com.example.egor.lab2.by.bstu.piskunou.basejava;

/**
 * Created by Egor on 26.09.2017.
 */

public class WrapperString {
    private String prv;

    public WrapperString() {
    }

    public String getPrv() {
        return prv;
    }

    public void setPrv(String prv) {
        this.prv = prv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WrapperString that = (WrapperString) o;

        return prv != null ? prv.equals(that.prv) : that.prv == null;

    }

    @Override
    public int hashCode() {
        return prv != null ? prv.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "prv='" + prv + '\'' +
                '}';
    }
}
