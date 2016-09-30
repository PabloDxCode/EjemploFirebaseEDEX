package com.example.pgutierrezd.loginfirebasemvp.login;

/**
 * Created by pgutierrezd on 30/09/2016.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
