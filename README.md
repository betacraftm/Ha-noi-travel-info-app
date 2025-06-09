# Di Tích Hà Nội - Ứng dụng Android

![Java](https://img.shields.io/badge/Language-Java-orange.svg)
![Platform](https://img.shields.io/badge/Platform-Android-green.svg)
![API](https://img.shields.io/badge/API-24%2B-blue.svg)

Đây là một ứng dụng Android đơn giản được xây dựng nhằm giới thiệu các di tích lịch sử và văn hóa nổi bật tại thủ đô Hà Nội, Việt Nam. Ứng dụng cho phép người dùng khám phá, tìm hiểu thông tin chi tiết, xem hình ảnh và nhận chỉ dẫn đường đi tới các địa điểm này.

## Tính năng chính

* **Danh sách Di tích:** Hiển thị danh sách các di tích lịch sử theo dạng lưới (1 cột) với hình ảnh và tên gọi.
* **Màn hình Chi tiết:** Khi chọn một di tích, ứng dụng sẽ hiển thị màn hình chi tiết bao gồm:
    * Hình ảnh lớn, đại diện cho di tích.
    * Tóm tắt đầy đủ về lịch sử và ý nghĩa.
    * Nút **Chỉ Dẫn Đường Đi** để mở Google Maps (hoặc ứng dụng bản đồ khác).
    * Nút **Xem Video Youtube** để mở video giới thiệu liên quan.
* **Giao diện Hiện đại:**
    * Sử dụng các thành phần Material Design như `CardView`, `Toolbar`.
    * Giao diện "tràn viền" (edge-to-edge) nhưng vẫn đảm bảo nội dung không bị che khuất bởi thanh trạng thái hay camera.
    * Giao diện được cố định ở Chế độ Sáng (Light Mode) để đảm bảo tính nhất quán.
* **Trải nghiệm người dùng:**
    * Biểu tượng ứng dụng (icon) tùy chỉnh hình Khuê Văn Các.
    * Màn hình chờ (Splash Screen) với hiệu ứng động khi khởi động ứng dụng.

## Công nghệ sử dụng

* **Ngôn ngữ:** Java
* **Kiến trúc:** Giao diện cơ bản với 2 Activity (`MainActivity` & `DetailActivity`).
* **Giao diện (UI):**
    * XML Layouts
    * Material Design Components
    * `RecyclerView` với `GridLayoutManager` để hiển thị danh sách dạng lưới.
    * `CardView` để tạo giao diện thẻ hiện đại.
    * `Toolbar` để làm thanh tiêu đề tùy chỉnh.
* **Thư viện chính:**
    * `androidx.appcompat`
    * `com.google.android.material:material`
    * `androidx.recyclerview:recyclerview`
    * `androidx.cardview:cardview`
    * `androidx.core:core-splashscreen` (cho màn hình chờ)