package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.tree.DefaultMutableTreeNode;

public class MGetinfo {

	public MGetinfo() {

	}

	public ResultSet getinfo(String courseName) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sugang", "root", "1234");
		Statement statement = connection.createStatement();
		ResultSet resultset = statement
				.executeQuery("SELECT 캠퍼스명, 대학명, 학과명, 강좌명, 강의시간, 교수명, 학점 FROM 강좌 WHERE 강좌명 = '" + courseName + "'");
		return resultset;
	}

}
