package com.lab.minishop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.lab.minishop.R;
import com.lab.minishop.models.Good;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckedGoodsAdapter extends RecyclerView.Adapter<CheckedGoodsAdapter.GoodHolder> {

    private List<Good> goods;

    public CheckedGoodsAdapter(ArrayList<Good> goods) {
        this.goods = goods;
    }

    @NonNull
    @Override
    public CheckedGoodsAdapter.GoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheckedGoodsAdapter.GoodHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_good,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CheckedGoodsAdapter.GoodHolder holder, final int position) {
        holder.bind(goods.get(position));
    }

    @Override
    public int getItemCount() {
        return goods.size();
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
            checkbox.setVisibility(View.GONE);
        }
    }
}
