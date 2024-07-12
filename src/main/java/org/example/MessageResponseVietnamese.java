package org.example;

public class MessageResponseVietnamese {
    public static String greeting = "Chúc phước nhiều, anh chị em hãy bấm nút Điểm danh cầu nguyện bên dưới để điểm danh cầu nguyện cho ngày hôm nay nhé!";
    public static String attendance_ok = "Điểm danh cầu nguyện đã hoàn tất. Hãy cầu nguyện chăm chỉ và thường xuyên lên Cha Mẹ để nhận được ân điển từ họ nhé!";
    public static String attendance_error = "Điểm danh cầu nguyện đã không thành công. Hãy cầu nguyện lên Cha Mẹ và cầu mong họ giúp đỡ nhé!";
    public static String attendance_btn = "Điểm danh cầu nguyện";
    public static String bot_done = "Cảm ơn anh chị em. Chúc anh chị em có một ngày tốt lành.";
    public static String help_text =
            "Bot này sẽ giúp bạn điểm danh, đếm số lần cầu nguyện cũng như thống kê số lần cầu nguyện theo các mốc thời gian (quý, tuần, tháng hoặc cả năm).\n" +
                    "\n" +
                    "Lưu ý chỉ quản trị viên mới có thể tổng kết số lần cầu nguyện theo các mốc thời gian của **TẤT CẢ CÁC THÀNH VIÊN**, những người khác chỉ có thể nhìn thấy thông tin của chính họ.\n" +
                    "\n" +
                    "**LƯU Ý: CÓ NHỮNG TÍNH NĂNG CHỈ QUẢN TRỊ VIÊN MỚI ĐƯỢC SỬ DỤNG. KHI BẠN SỬ DỤNG CÁC TÍNH NĂNG NÀY MÀ BẠN KHÔNG PHẢI QUẢN TRỊ VIÊN, BẠN SẼ NHẬN ĐƯỢC THÔNG BÁO LỖI**\n" +
                    "\n" +
                    "Đây là các lệnh mà bot hỗ trợ. Lưu ý chỉ các lệnh được hỗ trợ, nếu lệnh đó cần đối số, bạn chỉ có thể nhập đối số sau khi nhập lệnh. \n" +
                    "\n" +
                    "**/start** - Bắt đầu bot\n" +
                    "**/help** - Hiển thị trợ giúp này\n" +
                    "**/addquotes (CHỈ QUẢN TRỊ VIÊN)** - Thêm các câu quote (chỉ quản trị viên). Lệnh yêu cầu 1 đối số duy nhất là câu quotes dưới dạng văn bản\n" +
                    "**/sum** - Đưa ra thống kê về số lần cầu nguyện. Số lần cầu nguyện sẽ được cộng dồn và sẽ được đặt trở lại về 0 vào lúc 12:00AM ngày 1/1. Lệnh yêu cầu 1 đối số là mốc thời gian.\n" +
                    "**/showquotes** - Hiển thị câu quote. Mỗi lần sử dụng lệnh sẽ đưa ra một câu quote mới.\n";
}
