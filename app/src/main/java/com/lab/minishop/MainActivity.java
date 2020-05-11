package com.lab.minishop;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lab.minishop.adapters.GoodsAdapter;
import com.lab.minishop.interfaces.OnChangeListener;
import com.lab.minishop.models.Good;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnChangeListener {

    public static final String GOODS = "goods";

    @BindView(R.id.txtTitle)
    AppCompatTextView txtTitle;
    @BindView(R.id.recyclerGoods)
    RecyclerView recyclerGoods;
    @BindView(R.id.txtCountGoods)
    AppCompatTextView txtCountGoods;

    private GoodsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txtTitle.setText(R.string.goods);
        setupList();
    }

    @OnClick(R.id.txtShow)
    public void onViewClicked() {
        openBasket();
    }

    @Override
    public void changeChecked() {
        txtCountGoods.setText(getString(R.string.checked, adapter.getCheckedSize()));
    }

    private void setupList() {
        recyclerGoods.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GoodsAdapter(getGoods(), this);
        recyclerGoods.setAdapter(adapter);
        changeChecked();
    }

    private List<Good> getGoods() {
        List<Good> goods = new ArrayList<>();
        goods.add(new Good(7863, "jsdh", 238));
        goods.add(new Good(3245, "dfsdxfa", 654));
        goods.add(new Good(4567, "ehvjusgf", 56));
        goods.add(new Good(6453, "dfvgsc", 546));
        goods.add(new Good(2343, "fgcsv g", 456));
        goods.add(new Good(5653, "cgsg", 342));
        goods.add(new Good(3455, "jsgvdh", 56));
        goods.add(new Good(5645, "svdhdj", 67865));
        goods.add(new Good(2343, "dfbjh", 64));
        return goods;
    }

    private void openBasket() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(GOODS, adapter.getCheckedGoods());
        startActivity(intent);
    }
}
