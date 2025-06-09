// File: SiteAdapter.java
package com.example.ditichhanoi; // Thay bằng package của bạn

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.SiteViewHolder> {

    private Context context;
    private ArrayList<HistoricalSite> siteList;
    private OnItemClickListener listener;

    // Interface để xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SiteAdapter(Context context, ArrayList<HistoricalSite> siteList) {
        this.context = context;
        this.siteList = siteList;
    }

    @NonNull
    @Override
    public SiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo view bằng cách inflate layout của một card
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_card, parent, false);
        return new SiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteViewHolder holder, int position) {
        // Lấy dữ liệu từ vị trí position và gán vào các view trong card
        HistoricalSite currentSite = siteList.get(position);

        holder.imageView.setImageResource(currentSite.getImageResourceId());
        holder.titleTextView.setText(currentSite.getName());
        holder.summaryTextView.setText(currentSite.getSummary());
    }

    @Override
    public int getItemCount() {
        return siteList.size();
    }

    // Lớp ViewHolder để giữ các tham chiếu đến view của mỗi card
    public class SiteViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;
        public TextView summaryTextView;

        public SiteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardImageView);
            titleTextView = itemView.findViewById(R.id.cardTitleTextView);
            summaryTextView = itemView.findViewById(R.id.cardSummaryTextView);

            // Bắt sự kiện click trên toàn bộ card
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}