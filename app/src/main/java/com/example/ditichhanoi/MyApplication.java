package com.example.ditichhanoi; // Đảm bảo package này đúng với dự án của bạn

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Đặt chế độ sáng cho toàn bộ ứng dụng ngay tại thời điểm khởi tạo
        // Đây là nơi chạy sớm nhất và sẽ hoạt động trên mọi thiết bị
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}