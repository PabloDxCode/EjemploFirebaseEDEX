package com.example.pgutierrezd.loginfirebasemvp.login;

import com.example.pgutierrezd.loginfirebasemvp.login.events.LoginEvent;

/**
 * Created by pgutierrezd on 30/09/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
