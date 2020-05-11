package com.lab.taxi.presentation.auth.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.lab.taxi.R;
import com.lab.taxi.presentation.auth.mvp.presenter.AuthPresenter;
import com.lab.taxi.presentation.auth.mvp.view.AuthView;
import com.lab.taxi.presentation.base.BaseActivity;
import com.lab.taxi.presentation.personal.activity.PersonalActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AuthActivity extends BaseActivity implements AuthView {

    @InjectPresenter
    AuthPresenter presenter;

    @BindView(R.id.edtNumber)
    AppCompatEditText edtNumber;
    @BindView(R.id.edtName)
    AppCompatEditText edtName;
    @BindView(R.id.edtSurName)
    AppCompatEditText edtSurName;
    @BindView(R.id.btnEnter)
    AppCompatButton btnEnter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    protected String getTag() {
        return "AuthActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupListener();
    }

    @OnClick(R.id.btnEnter)
    public void onViewClicked() {
        presenter.clickEnter();
    }

    @Override
    public void setRegister() {
        btnEnter.setText(R.string.register);
    }

    @Override
    public void setLogIn() {
        btnEnter.setText(R.string.log_in);
    }

    @Override
    public void setData(String number, String name, String surname) {
        edtNumber.setText(number);
        edtName.setText(name);
        edtSurName.setText(surname);
    }

    @Override
    public void openPersonalData() {
        startActivity(new Intent(this, PersonalActivity.class));
        finish();
    }

    @Override
    public void setDisabledButton() {
        btnEnter.setEnabled(false);
    }

    @Override
    public void setEnabledButton() {
        btnEnter.setEnabled(true);
    }

    private void setupListener() {
        edtSurName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.setSurname(s.toString());
            }
        });
        edtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.setNumber(s.toString());
            }
        });
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.setName(s.toString());
            }
        });
    }
}
