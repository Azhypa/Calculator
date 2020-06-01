package com.lab.minishop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.lab.minishop.R;
import com.lab.minishop.interfaces.OnChangeListener;
import com.lab.minishop.models.Good;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodHolder> {

    private List<Good> goods;
    private OnChangeListener listener;

    public GoodsAdapter(List<Good> goods, OnChangeListener listener) {
        this.goods = goods;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GoodHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_good,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GoodHolder holder, final int position) {
        holder.bind(goods.get(position));
        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goods.get(position).setChecked(isChecked);
                if (listener != null)
                    listener.changeChecked();
            }
        });
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    public int getCheckedSize() {
        int size = 0;
        for (Good good : goods)
            if (good.isChecked())
                size++;
        return size;
    }

    public ArrayList<Good> getCheckedGoods() {
        ArrayList<Good> checked = new ArrayList<>();
        for (Good good : goods)
            if (good.isChecked())
                checked.add(good);
        return checked;
    }

    static class GoodHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.checkbox)
        public CheckBox checkbox;
        @BindView(R.id.txtNumber)
        AppCompatTextView txtNumber;
        @BindView(R.id.txtName)
        AppCompatTextView txtName;
        @BindView(R.id.txtPrice)
        AppCompatTextView txtPrice;

        GoodHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Good good) {
            txtName.setText(itemView.getContext().getString(R.string.name, good.getName()));
            txtNumber.setText(itemView.getContext().getString(R.string.number, good.getNumber()));
            txtPrice.setText(itemView.getContext().getString(R.string.price, good.getPrice()));
            checkbox.setChecked(good.isChecked());
            checkbox.setVisibility(View.VISIBLE);
        }
    }
}
