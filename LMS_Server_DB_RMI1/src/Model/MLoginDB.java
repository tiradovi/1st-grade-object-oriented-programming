package Model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import valueObjectServer.VUserInfo;

public class MLoginDB {

	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/login";
	String user = "root";
	String passwd = "1234";

	public MLoginDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	/* 로그인 정보를 확인 */
	public VUserInfo logincheck(String ID, String password) {

	    String id = ID;
        String pwHash = hashPassword(password);  // 비밀번호를 해시화

        try {
            String checkingStr = "SELECT * FROM login WHERE 아이디='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            if (result.next()) {
                if (pwHash.equals(result.getString("암호화패스워드"))) {

                    VUserInfo vUserInfo = new VUserInfo();
                    vUserInfo.setUserId(result.getString("아이디"));
                    vUserInfo.setPassword(result.getString("패스워드"));
                    vUserInfo.setName(result.getString("이름"));

                    return vUserInfo;
                } else {

                    return null;
                }
            } else {

                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}