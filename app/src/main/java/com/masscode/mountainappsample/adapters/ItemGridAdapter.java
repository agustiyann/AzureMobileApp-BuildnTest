package com.masscode.mountainappsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masscode.mountainappsample.R;
import com.masscode.mountainappsample.model.Mountain;

import java.util.ArrayList;

public class ItemGridAdapter extends RecyclerView.Adapter<ItemGridAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Mountain> listMountain;

    public ItemGridAdapter(Context context) {
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
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {

        Glide.with(context)
                .load(getListMountain().get(position).getPhoto())
                .into(holder.imgPhoto);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, getListMountain().get(position).getName() + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMountain().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        LinearLayout linearLayout;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_grid);
            linearLayout = itemView.findViewById(R.id.linear_grid);
        }
    }
}
