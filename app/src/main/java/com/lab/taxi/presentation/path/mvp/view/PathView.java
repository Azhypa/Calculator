package com.lab.taxi.presentation.path.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface PathView extends MvpView {
    void getData();

    void showError();

    void sendData(String fromStreet, String fromHouse, String fromFlat,
                  String toStreet, String toHouse, String toFlat);
}
