package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import DTO.userDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import utils.DbUtils;

public class userDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private String email_regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // 🔹 Lấy thông tin user theo userName
    public userDTO getUserById(String userName) {
        userDTO user = null;
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUser WHERE userName = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, userName);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = new userDTO();
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("userFullname"));
                user.setPassword(rs.getString("userPassword"));
                user.setDateOfBirth(rs.getDate("dateOfBirth"));
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // 🔹 Kiểm tra đăng nhập
    public boolean login(String userName, String password) {
        try {
            userDTO user = getUserById(userName);
            if (user != null) { // chỉ cho phép nếu user đang active
                return user.getPassword().equals(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔹 Thêm user mới vào database
    public boolean insertUser(userDTO user) {
        boolean check = false;

        try {
            con = DbUtils.getConnection();
            if (con != null) {
                String userID = "CM" + String.format("%06d", new Random().nextInt(100000000));
                
                if (user.getEmail() == null || !user.getEmail().matches(email_regex)) {
                    System.out.println("❌ Email không hợp lệ hoặc bị trống: " + user.getEmail());
                    return false;
                }
                String sql = "INSERT INTO tblUser(userId, userFullname, userName,userPassword, email , dateOfBirth) "
                        + "VALUES(?, ?, ?, ?, ?, ?)";

                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, user.getFullName());
                ps.setString(3, user.getUserName());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getEmail());
                ps.setDate(6, user.getDateOfBirth());

                check = ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public userDTO checkAccountExist(String userName) {
        userDTO user = null;
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUser WHERE userName = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, userName);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = new userDTO();
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("userFullname"));
                user.setPassword(rs.getString("userPassword"));
                user.setDateOfBirth(rs.getDate("dateOfBirth"));
                return user;
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        userDAO dao = new userDAO();
      
        System.out.println();
    }
}
