package com.lab.minishop;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lab.minishop.adapters.CheckedGoodsAdapter;
import com.lab.minishop.models.Good;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    AppCompatTextView txtTitle;
    @BindView(R.id.recyclerGoods)
    RecyclerView recyclerGoods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        txtTitle.setText(R.string.basket);
        setupGoods(getIntent().<Good>getParcelableArrayListExtra(MainActivity.GOODS));
    }

    private void setupGoods(ArrayList<Good> goods) {
        recyclerGoods.setLayoutManager(new LinearLayoutManager(this));
        recyclerGoods.setAdapter(new CheckedGoodsAdapter(goods));
    }
}
