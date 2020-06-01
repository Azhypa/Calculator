package com.lab.taxi.presentation.personal.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface PersonalView extends MvpView {
    void setName(String name);

    void setNumber(String number);

    void setPath(String path);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void openPathScreen();

    void showIsRequested();

    void setCallEnabled();
}
