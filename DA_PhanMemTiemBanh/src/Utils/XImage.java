
package Utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class XImage {
   // Phương thức getAppIcon trả về một đối tượng hình ảnh (Image) đại diện cho biểu tượng ứng dụng
public static Image getAppIcon() {
    // Sử dụng XImage.class.getResource() để lấy URL của biểu tượng ứng dụng từ tài nguyên
    URL url = XImage.class.getResource("/img/Cake.jpg");
    // Tạo một đối tượng ImageIcon từ URL và lấy hình ảnh từ nó
    return new ImageIcon(url).getImage();
}

// Phương thức save sao chép một tệp từ vị trí nguồn (src) đến vị trí đích (dst)
public static void save(File src) {
    // Tạo một đối tượng File đích (dst) trong thư mục "Images" với tên tệp giống tên tệp nguồn (src)
    File dst = new File("img", src.getName());
    
    // Kiểm tra xem thư mục cha của tệp đích có tồn tại hay không, nếu không tồn tại thì tạo thư mục cha
    if (!dst.getParentFile().exists()) {
        dst.getParentFile().mkdirs();
    }
    
    try {
        // Sử dụng Java NIO để sao chép tệp từ nguồn đến đích, với tùy chọn REPLACE_EXISTING để ghi đè nếu tệp đích đã tồn tại
        Path from = Paths.get(src.getAbsolutePath());
        Path to = Paths.get(dst.getAbsolutePath());
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception ex) {
        // Xử lý ngoại lệ bằng cách ném ra RuntimeException
        throw new RuntimeException(ex);
    }
}

// Phương thức read đọc một tệp hình ảnh từ thư mục "Images" dựa trên tên tệp (fileName) và trả về một đối tượng ImageIcon
public static ImageIcon read(String fileName) {
    // Tạo một đối tượng File từ thư mục "Images" và tên tệp
    File path = new File("img", fileName);
    // Tạo một đối tượng ImageIcon từ đường dẫn tệp và trả về nó
    return new ImageIcon(path.getAbsolutePath());
}

}
