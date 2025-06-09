// File: DetailActivity.java
package com.example.ditichhanoi; // Thay bằng package của bạn

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    private ImageView siteImageView;
    private TextView summaryTextView;
    private Button directionsButton, youtubeButton, backButton;
    private HistoricalSite currentSite;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Liên kết các view từ layout
        siteImageView = findViewById(R.id.siteImageView);
        summaryTextView = findViewById(R.id.summaryTextView);
        directionsButton = findViewById(R.id.directionsButton);
        youtubeButton = findViewById(R.id.youtubeButton);
        backButton = findViewById(R.id.backButton);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        currentSite = (HistoricalSite) intent.getSerializableExtra("SITE_DATA");

        if (currentSite != null) {
            // Đặt tiêu đề cho Activity
            getSupportActionBar().setTitle(currentSite.getName());

            // Cập nhật giao diện với dữ liệu
            siteImageView.setImageResource(currentSite.getImageResourceId());
            summaryTextView.setText(currentSite.getSummary());

            // Xử lý sự kiện cho các nút
            setupButtonListeners();
        } else {
            Toast.makeText(this, "Lỗi: Không nhận được dữ liệu di tích.", Toast.LENGTH_SHORT).show();
            finish(); // Đóng activity nếu không có dữ liệu
        }
    }

    private void setupButtonListeners() {
        // Nút chỉ đường
        directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(currentSite.getGeoUri());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Bỏ dòng setPackage để cho phép mở bất kỳ ứng dụng bản đồ nào
                // mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    // Thay đổi câu thông báo cho chính xác hơn
                    Toast.makeText(DetailActivity.this, "Không tìm thấy ứng dụng bản đồ nào.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nút xem YouTube
        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=" + currentSite.getYoutubeId()));
                try {
                    startActivity(webIntent);
                } catch (Exception e) {
                    Toast.makeText(DetailActivity.this, "Lỗi khi mở YouTube.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nút quay về
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại và quay về màn hình trước đó
            }
        });
    }
}