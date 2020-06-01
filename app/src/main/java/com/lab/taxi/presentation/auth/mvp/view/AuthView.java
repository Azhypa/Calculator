package com.lab.taxi.presentation.auth.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface AuthView extends MvpView {
    void setRegister();
    void setLogIn();
    void setData(String number, String name, String surname);
    void openPersonalData();
    void setDisabledButton();
    void setEnabledButton();
}
