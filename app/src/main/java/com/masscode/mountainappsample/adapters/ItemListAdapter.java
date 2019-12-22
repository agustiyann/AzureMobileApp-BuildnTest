package com.masscode.mountainappsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masscode.mountainappsample.R;
import com.masscode.mountainappsample.model.Mountain;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private Context context;
    private ArrayList<Mountain> listMountain;

    public ItemListAdapter(Context context) {
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
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        return new ItemViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        holder.tvName.setText(getListMountain().get(position).getName());
        holder.tvRemarks.setText(getListMountain().get(position).getRemarks());
        Glide.with(context).load(getListMountain().get(position).getPhoto()).into(holder.imgPhoto);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
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

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout relativeLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_list);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}
