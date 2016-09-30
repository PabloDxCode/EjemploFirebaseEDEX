package com.example.pgutierrezd.loginfirebasemvp.login;

/**
 * Created by pgutierrezd on 30/09/2016.
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
