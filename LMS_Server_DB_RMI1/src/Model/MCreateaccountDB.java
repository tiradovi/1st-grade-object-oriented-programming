
package Model;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class MCreateaccountDB {
    private static final String url = "jdbc:mysql://localhost/login";
    private static final String user = "root";
    private static final String passwd = "1234";

    public void createAccount(String id, String password, String name) {
        try (Connection con = DriverManager.getConnection(url, user, passwd)) {
            // 암호화 코드 추가
            String encryptedPassword = hashPassword(password);

            String query = "INSERT INTO login (아이디, 패스워드, 이름,암호화패스워드) VALUES (?, ?, ?,?)";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, id);
                pstmt.setString(2, password); // 암호화된 패스워드 저장
                pstmt.setString(3, name);
                pstmt.setString(4, encryptedPassword);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 패스워드 암호화 메서드 추가
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}