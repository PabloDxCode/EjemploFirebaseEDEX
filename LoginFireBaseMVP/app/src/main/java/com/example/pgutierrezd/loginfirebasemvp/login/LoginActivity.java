package com.example.pgutierrezd.loginfirebasemvp.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.pgutierrezd.loginfirebasemvp.R;
import com.example.pgutierrezd.loginfirebasemvp.contactlist.ContactListActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp;
    private ProgressBar progressBar;
    private RelativeLayout container;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    private void findViews() {
        inputEmail = (EditText) findViewById(R.id.editTxtEmail);
        inputPassword = (EditText) findViewById(R.id.editTxtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignin);
        btnSignUp = (Button) findViewById(R.id.btnSignup);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        container = (RelativeLayout) findViewById(R.id.layoutMainContainer);
        handleSignUp();
        handleSignIn();
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void handleSignUp() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.registerNewUser(inputEmail.getText().toString(),
                                                inputPassword.getText().toString());
                Log.d("TAG","Se presiono boton");
            }
        });
    }

    @Override
    public void handleSignIn() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.validateLogin(inputEmail.getText().toString(),
                                            inputPassword.getText().toString());
            }
        });
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ContactListActivity.class));
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin),error);
        inputPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(container, R.string.login_notice_message_signup,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void newUserError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup),error);
        inputPassword.setError(msgError);
    }

    private void setInputs(boolean enable){
        inputEmail.setEnabled(enable);
        inputPassword.setEnabled(enable);
        btnSignIn.setEnabled(enable);
        btnSignUp.setEnabled(enable);
    }
}
