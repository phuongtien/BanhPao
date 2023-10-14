
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
   // Khai báo biến formater kiểu SimpleDateFormat, sử dụng để định dạng ngày tháng
static SimpleDateFormat formater = new SimpleDateFormat();

// Phương thức toDate chuyển đổi một chuỗi ngày tháng thành đối tượng Date dựa trên một mẫu định dạng cụ thể
public static Date toDate(String date, String pattern) {
    try {
        // Áp dụng mẫu định dạng vào biến formater
        formater.applyPattern(pattern);
        // Sử dụng formater để chuyển đổi chuỗi ngày tháng thành đối tượng Date
        return formater.parse(date);
    } catch (Exception ex) {
        // Xử lý ngoại lệ bằng cách ném ra RuntimeException
        throw new RuntimeException(ex);
    }
}

// Phương thức toString chuyển đổi đối tượng Date thành chuỗi ngày tháng dựa trên một mẫu định dạng cụ thể
public static String toString(Date date, String pattern) {
    // Áp dụng mẫu định dạng vào biến formater
    formater.applyPattern(pattern);
    // Sử dụng formater để định dạng đối tượng Date thành chuỗi ngày tháng
    return formater.format(date);
}

// Phương thức addDays thêm một số ngày vào một đối tượng Date và trả về đối tượng Date sau khi được thay đổi
public static Date addDays(Date date, long days) {
    // Tính toán số mili giây tương ứng với số ngày cần thêm và cộng vào ngày hiện tại
    date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
    // Trả về đối tượng Date đã được thay đổi
    return date;
}
}
