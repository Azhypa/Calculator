package com.lab.taxi.presentation.path.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.lab.taxi.R;
import com.lab.taxi.common.consts.Const;
import com.lab.taxi.presentation.base.BaseActivity;
import com.lab.taxi.presentation.path.mvp.presenter.PathPresenter;
import com.lab.taxi.presentation.path.mvp.view.PathView;

import butterknife.BindView;
import butterknife.OnClick;

public class PathActivity extends BaseActivity implements PathView {

    @InjectPresenter
    PathPresenter presenter;

    @BindView(R.id.edtFromStreet)
    AppCompatEditText edtFromStreet;
    @BindView(R.id.edtFromHouse)
    AppCompatEditText edtFromHouse;
    @BindView(R.id.edtFromFlat)
    AppCompatEditText edtFromFlat;
    @BindView(R.id.edtToStreet)
    AppCompatEditText edtToStreet;
    @BindView(R.id.edtToHouse)
    AppCompatEditText edtToHouse;
    @BindView(R.id.edtToFlat)
    AppCompatEditText edtToFlat;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_path;
    }

    @Override
    protected String getTag() {
        return "PathActivity";
    }

    @OnClick(R.id.btnEnter)
    public void onViewClicked() {
        presenter.clickEnter();
    }

    @Override
    public void getData() {
        if (edtFromFlat.getText() == null || edtFromHouse.getText() == null || edtFromStreet.getText() == null ||
                edtToFlat.getText() == null || edtToHouse.getText() == null || edtToStreet.getText() == null)
            showError();
        else
            presenter.checkData(edtFromStreet.getText().toString(), edtFromHouse.getText().toString(),
                    edtFromFlat.getText().toString(), edtToStreet.getText().toString(),
                    edtToHouse.getText().toString(), edtToFlat.getText().toString());
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.not_filled, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendData(String fromStreet, String fromHouse, String fromFlat, String toStreet, String toHouse, String toFlat) {
        String path = getString(R.string.path, fromStreet, fromHouse, fromFlat, toStreet, toHouse, toFlat);
        Intent intent = new Intent();
        intent.putExtra(Const.PATH, path);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
