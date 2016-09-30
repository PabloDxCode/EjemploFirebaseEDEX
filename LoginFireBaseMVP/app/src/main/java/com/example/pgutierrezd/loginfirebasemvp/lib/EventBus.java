package com.example.pgutierrezd.loginfirebasemvp.lib;

/**
 * Created by pgutierrezd on 30/09/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unRegister(Object subscriber);
    void post(Object event);
}
