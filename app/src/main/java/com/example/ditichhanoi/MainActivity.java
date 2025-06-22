// File: MainActivity.java
package com.example.ditichhanoi; // Thay bằng package của bạn

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.splashscreen.SplashScreen;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SiteAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private SiteAdapter siteAdapter;
    private ArrayList<HistoricalSite> siteList;

    @Override
    protected void attachBaseContext(Context newBase) {
        // Áp dụng ngôn ngữ trước khi Activity được tạo
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); // Tối ưu hiệu năng
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Hiển thị dạng danh sách dọc

        siteList = new ArrayList<>();
        populateSiteList();

        siteAdapter = new SiteAdapter(MainActivity.this, siteList);
        recyclerView.setAdapter(siteAdapter);

        // Set listener cho adapter
        siteAdapter.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.language_switch_item);
        SwitchCompat languageSwitch = (SwitchCompat) item.getActionView();

        String currentLanguage = LocaleHelper.getLanguage(this);
        languageSwitch.setChecked("en".equals(currentLanguage));
        languageSwitch.setText(getString(R.string.language_switch));

        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Chỉ cần LƯU lựa chọn mới, không cần gọi setLocale ở đây nữa
            if (isChecked) {
                LocaleHelper.persist(this, "en");
            } else {
                LocaleHelper.persist(this, "vi");
            }

            // Yêu cầu Activity tự vẽ lại để áp dụng thay đổi
            // Khi vẽ lại, hàm attachBaseContext sẽ được gọi và đọc ngôn ngữ đã lưu
            recreate();
        });

        return true;
    }

    // Hàm này không thay đổi, giữ nguyên dữ liệu của bạn
    private void populateSiteList() {
        // Thêm di tích 1
        siteList.add(new HistoricalSite(
                getString(R.string.van_mieu_title),              // Lấy title từ resources
                R.drawable.van_mieu,
                getString(R.string.van_mieu_summary),             // Lấy summary từ resources
                "geo:21.0281225,105.8330943?q=Văn Miếu - Quốc Tử Giám",
                "PFQQY9l3E6Y"
        ));

        // Thêm di tích 2
        siteList.add(new HistoricalSite(
                getString(R.string.ho_guom_title),
                R.drawable.den_ngoc_son,
                getString(R.string.ho_guom_summary),
                "geo:21.0287797,105.8497898?q=Hồ Hoàn Kiếm",
                "HzJzot766_g"
        ));

        // Thêm di tích 3
        siteList.add(new HistoricalSite(
                getString(R.string.hoang_thanh_title),
                R.drawable.hoang_thanh_thang_long,
                getString(R.string.hoang_thanh_summary),
                "geo:21.035228,105.8353885?q=Hoàng Thành Thăng Long",
                "IlpjNXbzvao"
        ));

        // Thêm di tích 4
        siteList.add(new HistoricalSite(
                getString(R.string.lang_bac_title),
                R.drawable.lang_bac,
                getString(R.string.lang_bac_summary),
                "geo:21.0369023,105.8320918?q=Lăng Chủ tịch Hồ Chí Minh",
                "bLS2JinHaEE"
        ));

        // Thêm di tích 5
        siteList.add(new HistoricalSite(
                getString(R.string.nha_tu_hoa_lo_title),
                R.drawable.hoa_lo,
                getString(R.string.nha_tu_hoa_lo_summary),
                "geo:21.0253346,105.8416072?q=Di tích Nhà tù Hỏa Lò",
                "vjoLSxuH1zU"
        ));

        // Thêm di tích 6
        siteList.add(new HistoricalSite(
                getString(R.string.chua_mot_cot_title),
                R.drawable.chua_mot_cot,
                getString(R.string.chua_mot_cot_summary),
                "geo:21.0358327,105.8310457?q=Chùa Một Cột",
                "tYXe1AnQQxk"
        ));

        // Thêm di tích 7
        siteList.add(new HistoricalSite(
                getString(R.string.chua_tran_quoc_title),
                R.drawable.chua_tran_quoc,
                getString(R.string.chua_tran_quoc_summary),
                "geo:21.047876,105.8342989?q=Chùa Trấn Quốc",
                "6zmwC97ThFQ"
        ));

        // Thêm di tích 8
        siteList.add(new HistoricalSite(
                getString(R.string.nha_hat_lon_title),
                R.drawable.nha_hat_lon_ha_noi,
                getString(R.string.nha_hat_lon_summary),
                "geo:21.0242488,105.8550505?q=Nhà hát Lớn Hà Nội",
                "LahITOwSR8c"
        ));

        // Thêm di tích 9
        siteList.add(new HistoricalSite(
                getString(R.string.bao_tang_dth_title),
                R.drawable.bao_tang_dan_toc_hoc,
                getString(R.string.bao_tang_dth_summary),
                "geo:21.0403472,105.7961605?q=Bảo tàng Dân tộc học Việt Nam",
                "pnHKs7NiEFk"
        ));

        // Thêm di tích 10
        siteList.add(new HistoricalSite(
                getString(R.string.den_quan_thanh_title),
                R.drawable.den_quan_thanh,
                getString(R.string.den_quan_thanh_summary),
                "geo:21.0430225,105.8339713?q=Đền Quán Thánh",
                "TsKgFV9Yf6E"
        ));
    }

    // Xử lý sự kiện click được gọi từ Adapter
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        HistoricalSite clickedSite = siteList.get(position);
        intent.putExtra("SITE_DATA", clickedSite);
        startActivity(intent);
    }
}