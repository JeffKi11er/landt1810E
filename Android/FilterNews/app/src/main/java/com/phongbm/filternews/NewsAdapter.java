package com.phongbm.filternews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
    private ArrayList<News> data;
    private LayoutInflater inflater;

    public NewsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_view, viewGroup, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        News item = data.get(i);
        newsHolder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        private ImageView imNews;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvDate;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imNews = itemView.findViewById(R.id.im_news);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }

        public void bindData(News item){
            tvTitle.setText(item.getTitle());
            tvDate.setText(item.getPubDate());
            tvDesc.setText(item.getDesc());
            Glide.with(imNews)
                    .load(item.getImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imNews);
        }
    }
}
