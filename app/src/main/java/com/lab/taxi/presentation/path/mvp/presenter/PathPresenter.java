package com.lab.taxi.presentation.path.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.lab.taxi.presentation.path.mvp.view.PathView;

@InjectViewState
public class PathPresenter extends MvpPresenter<PathView> {

    public void clickEnter() {
        getViewState().getData();
    }

    public void checkData(String fromStreet, String fromHouse, String fromFlat,
                          String toStreet, String toHouse, String toFlat) {
        if (fromStreet.isEmpty() || fromHouse.isEmpty() || fromFlat.isEmpty() ||
                toFlat.isEmpty() || toHouse.isEmpty() || toStreet.isEmpty())
            getViewState().showError();
        else
            getViewState().sendData(fromStreet, fromHouse, fromFlat, toStreet, toHouse, toFlat);
    }
}
