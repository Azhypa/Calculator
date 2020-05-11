package com.lab.taxi.presentation.auth.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.lab.taxi.data.MyPreferences;
import com.lab.taxi.presentation.auth.mvp.view.AuthView;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthView> {

    private String name = "";
    private String number = "";
    private String surname = "";
    private MyPreferences myPreferences;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        myPreferences = MyPreferences.getPreferences();
        checkState();
    }

    public void clickEnter() {
        setData();
    }

    public void setName(String name) {
        this.name = name;
        checkData();
    }

    public void setNumber(String number) {
        this.number = number;
        checkData();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        checkData();
    }

    private void setData() {
        myPreferences.setName(name);
        myPreferences.setNumber(number);
        myPreferences.setSurName(surname);
        getViewState().openPersonalData();
    }

    private void checkState() {
        if (myPreferences.getNumber().isEmpty())
            setRegisterState();
        else
            setLoginState();
    }

    private void setRegisterState() {
        getViewState().setRegister();
    }

    private void setLoginState() {
        getViewState().setLogIn();
        getViewState().setData(
                myPreferences.getNumber(),
                myPreferences.getName(),
                myPreferences.getSurName()
        );
        getViewState().setEnabledButton();
    }

    private void checkData() {
        if (name.isEmpty() || surname.isEmpty() || number.isEmpty())
            getViewState().setDisabledButton();
        else
            getViewState().setEnabledButton();
    }
}
