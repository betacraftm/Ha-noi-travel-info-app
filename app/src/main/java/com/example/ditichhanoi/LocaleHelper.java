// File: LocaleHelper.java
package com.example.ditichhanoi; // Đảm bảo package này đúng với dự án của bạn

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

public class LocaleHelper {

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    private static final String PREFS_NAME = "user_prefs";

    // Hàm này được gọi trong attachBaseContext của mỗi Activity
    // Nó sẽ đọc ngôn ngữ đã lưu và trả về một Context mới đã được cấu hình
    public static Context onAttach(Context context) {
        String lang = getPersistedData(context, Locale.getDefault().getLanguage());
        return setLocale(context, lang);
    }

    // Lấy ngôn ngữ đang được lưu
    public static String getLanguage(Context context) {
        return getPersistedData(context, Locale.getDefault().getLanguage());
    }

    // Hàm này được gọi khi người dùng gạt Switch
    // Nó chỉ lưu lựa chọn mới, việc áp dụng sẽ do lệnh `recreate()` trong Activity thực hiện
    public static void persist(Context context, String language) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    // Hàm setLocale bây giờ sẽ trả về một Context mới
    private static Context setLocale(Context context, String language) {
        // Lưu lại lựa chọn ngôn ngữ mới (nếu có)
        // persist(context, language);

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration config = new Configuration(resources.getConfiguration());
        config.setLocale(locale);

        // Dòng quan trọng nhất: tạo và trả về một Context mới với cấu hình ngôn ngữ đã thay đổi
        return context.createConfigurationContext(config);
    }

    private static String getPersistedData(Context context, String defaultLanguage) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage);
    }
}