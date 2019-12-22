package com.masscode.mountainappsample.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masscode.mountainappsample.R;
import com.masscode.mountainappsample.activities.DetailActivity;
import com.masscode.mountainappsample.model.Mountain;

import java.util.ArrayList;

public class ItemCardViewAdapter extends RecyclerView.Adapter<ItemCardViewAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Mountain> listMountain;

    public ItemCardViewAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Mountain> getListMountain() {
        return listMountain;
    }

    public void setListMountain(ArrayList<Mountain> listMountain) {
        this.listMountain = listMountain;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, final int position) {
        holder.tvName.setText(getListMountain().get(position).getName());
        holder.tvDescription.setText(getListMountain().get(position).getDeskripsi());
        Glide.with(context).load(getListMountain().get(position).getPhoto()).into(holder.imgPhoto);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(context, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_MOUNTAIN, listMountain.get(position));
                context.startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMountain().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        Button button;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_card);
            tvName = itemView.findViewById(R.id.tv_name_card);
            tvDescription = itemView.findViewById(R.id.tv_desc_card);
            button = itemView.findViewById(R.id.button);
        }
    }
}
