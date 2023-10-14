//package Utils;
//
//import Entity.NhanVien;
//import Entity.TaiKhoan;
//
//public class Auth {
//    // Khai báo một biến tĩnh (static) user của lớp NhanVien (người dùng) và gán giá trị ban đầu là null
//
//    public static NhanVien user = null;
//    public static TaiKhoan tK = null;
//
//// Phương thức clear để đặt biến user về giá trị null, đánh dấu việc người dùng đã đăng xuất
//    public static void clear() {
//        Auth.user = null;
//
//    }
//
//    public static void clearTK() {
//        Auth.tK = null;
//
//    }
//
//// Phương thức isLogin kiểm tra xem có người dùng nào đăng nhập hay không
//    public static boolean isLogin() {
//        return Auth.user != null;
//    }
//
//    public static boolean isLoginTK() {
//        return Auth.tK != null;
//    }
//
//// Phương thức isLogin kiểm tra xem có người dùng nào đăng nhập hay không
//// Phương thức isManager kiểm tra xem người dùng hiện tại có quyền quản lý hay không
//// Phương thức này kiểm tra nếu người dùng đã đăng nhập (sử dụng phương thức isLogin()) và có quyền quản lý (sử dụng user.getVaitro())
//    public static boolean isAdmin() {
//        return Auth.isLogin() && tK.getVaitro();
//    }
//
//}
