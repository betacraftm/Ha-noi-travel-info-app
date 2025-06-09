// File: HistoricalSite.java
package com.example.ditichhanoi; // Thay bằng package của bạn

import java.io.Serializable;

public class HistoricalSite implements Serializable { // Implement Serializable để truyền đối tượng qua Intent
    private String name;
    private int imageResourceId;
    private String summary;
    private String geoUri; // Ví dụ: "geo:21.0285,105.8542?q=Hồ Hoàn Kiếm"
    private String youtubeId; // Chỉ cần ID của video, ví dụ: "abcdef12345"

    public HistoricalSite(String name, int imageResourceId, String summary, String geoUri, String youtubeId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.summary = summary;
        this.geoUri = geoUri;
        this.youtubeId = youtubeId;
    }

    // Getters
    public String getName() { return name; }
    public int getImageResourceId() { return imageResourceId; }
    public String getSummary() { return summary; }
    public String getGeoUri() { return geoUri; }
    public String getYoutubeId() { return youtubeId; }
}