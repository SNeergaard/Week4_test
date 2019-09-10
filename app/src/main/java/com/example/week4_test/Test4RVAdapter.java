package com.example.week4_test;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4_test.model.samsong.Samsong;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Test4RVAdapter extends RecyclerView.Adapter<Test4RVAdapter.ViewHolder> {
    private List<Samsong> samsong;
    private Context context;


    public Test4RVAdapter(Context context, List<Samsong> samsong){
        this.samsong = samsong;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        TextView tvSamsong;
        ImageView ivSamsong;
        CheckBox cbSamsong;
        Samsong item;

        public void setItem(Samsong item) {this.item = item;}

        @Override
        public void onClick(View view) {
            populateView(item);
            cbSamsong.setVisibility(View.VISIBLE);
        }

        private void populateView(Samsong item){
            String title = item.getTitle();
            tvSamsong.setText(title);
            cbSamsong.setVisibility(View.VISIBLE);
        }

        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            tvSamsong = itemView.findViewById(R.id.tvSamsong);
            ivSamsong = itemView.findViewById(R.id.ivSamsong);
            cbSamsong = itemView.findViewById(R.id.cbSamsong);
            itemView.setOnClickListener(this);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.samsong_item, parent, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Samsong currentSamsong = samsong.get(position);
        //holder.tvSamsong.setText(currentSamsong.getTitle());
        Picasso.get().load(currentSamsong.getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.ivSamsong);
        holder.setItem(currentSamsong);
    }

    @Override
    public int getItemCount() {
        return samsong.size();
    }

}
