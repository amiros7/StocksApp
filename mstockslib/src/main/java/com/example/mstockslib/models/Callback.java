package com.example.mstockslib.models;

public interface Callback<T> {
    void consume(T data);

    void error(Throwable e);
}