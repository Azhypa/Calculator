package com.lab.taxi.presentation.personal.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.lab.taxi.data.MyPreferences;
import com.lab.taxi.presentation.personal.mvp.view.PersonalView;

@InjectViewState
public class PersonalPresenter extends MvpPresenter<PersonalView> {

    private MyPreferences myPreferences;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        myPreferences = MyPreferences.getPreferences();
        setPersonalData();
    }

    public void clickPath() {
        getViewState().openPathScreen();
    }

    public void clickCall() {
        getViewState().showIsRequested();
    }

    public void setPath(String path) {
        getViewState().setPath(path);
        if (!path.isEmpty())
            getViewState().setCallEnabled();
    }

    private void setPersonalData() {
        String fullName = myPreferences.getName() + " " + myPreferences.getSurName();
        getViewState().setName(fullName);
        getViewState().setNumber(myPreferences.getNumber());
    }
}
