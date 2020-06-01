package com.lab.taxi.presentation.personal.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.lab.taxi.R;
import com.lab.taxi.common.consts.Const;
import com.lab.taxi.presentation.base.BaseActivity;
import com.lab.taxi.presentation.path.activity.PathActivity;
import com.lab.taxi.presentation.personal.mvp.presenter.PersonalPresenter;
import com.lab.taxi.presentation.personal.mvp.view.PersonalView;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalActivity extends BaseActivity implements PersonalView {

    @InjectPresenter
    PersonalPresenter presenter;

    @BindView(R.id.txtName)
    AppCompatTextView txtName;
    @BindView(R.id.txtNumber)
    AppCompatTextView txtNumber;
    @BindView(R.id.txtPath)
    AppCompatTextView txtPath;
    @BindView(R.id.btnCall)
    AppCompatButton btnCall;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected String getTag() {
        return "PersonalActivity";
    }

    @OnClick({R.id.btnPath, R.id.btnCall})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPath:
                presenter.clickPath();
                break;
            case R.id.btnCall:
                presenter.clickCall();
                break;
        }
    }

    @Override
    public void setName(String name) {
        txtName.setText(name);
    }

    @Override
    public void setNumber(String number) {
        txtNumber.setText(number);
    }

    @Override
    public void setPath(String path) {
        txtPath.setText(path);
    }

    @Override
    public void openPathScreen() {
        startActivityForResult(new Intent(this, PathActivity.class), Const.PATH_REQUESTED_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Const.PATH_REQUESTED_CODE && resultCode == Activity.RESULT_OK && data != null)
            presenter.setPath(data.getStringExtra(Const.PATH));
    }

    @Override
    public void showIsRequested() {
        Toast.makeText(this, R.string.requested, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setCallEnabled() {
        btnCall.setEnabled(true);
    }
}
