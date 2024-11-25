package Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBdirectory {
    public DefaultMutableTreeNode getDirectoryTree() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
            return null;
        }

        // MySQL 데이터베이스에 연결
        String url = "jdbc:mysql://localhost:3306/sugang";
        String username = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // 트리 노드 생성
            DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("캠퍼스");

            try (Statement stmtCampus = conn.createStatement()) {
                ResultSet rsCampus = stmtCampus.executeQuery("SELECT DISTINCT 캠퍼스명 FROM 캠퍼스");
                while (rsCampus.next()) {
                    String campusName = rsCampus.getString("캠퍼스명");
                    DefaultMutableTreeNode campusNode = new DefaultMutableTreeNode(campusName, true);
                    rootNode.add(campusNode);

                    // 대학 목록 가져오기
                    try (Statement stmtUniversity = conn.createStatement()) {
                        ResultSet rsUniversity = stmtUniversity.executeQuery(
                                "SELECT DISTINCT 대학명 FROM 대학 WHERE 캠퍼스명 = '" + campusName + "'");
                        while (rsUniversity.next()) {
                            String universityName = rsUniversity.getString("대학명");
                            DefaultMutableTreeNode universityNode = new DefaultMutableTreeNode(universityName, true);
                            campusNode.add(universityNode);

                            // 학과 목록 가져오기
                            try (Statement stmtDepartment = conn.createStatement()) {
                                ResultSet rsDepartment = stmtDepartment.executeQuery(
                                        "SELECT DISTINCT 학과명 FROM 학과 WHERE 캠퍼스명 = '" + campusName
                                                + "' AND 대학명 = '" + universityName + "'");
                                while (rsDepartment.next()) {
                                    String departmentName = rsDepartment.getString("학과명");
                                    DefaultMutableTreeNode departmentNode = new DefaultMutableTreeNode(departmentName,
                                            true);
                                    universityNode.add(departmentNode);

                                    // 강좌 목록 가져오기
                                    try (Statement stmtCourse = conn.createStatement()) {
                                        ResultSet rsCourse = stmtCourse.executeQuery("SELECT 강좌명, 교수명, 학점, 강의시간 FROM 강좌 WHERE 캠퍼스명 = '"
                                                + campusName + "' AND 대학명 = '" + universityName
                                                + "' AND 학과명 = '" + departmentName + "'");
                                        while (rsCourse.next()) {
                                            String courseName = rsCourse.getString("강좌명");
                                            String professor = rsCourse.getString("교수명");
                                            int credit = rsCourse.getInt("학점");
                                            String lectureTime = rsCourse.getString("강의시간");

                                            String courseInfo = courseName + " (교수: " + professor + ", 학점: " + credit
                                                    + ", 시간: " + lectureTime + ")";

                                            DefaultMutableTreeNode courseNode = new DefaultMutableTreeNode(courseInfo);
                                            departmentNode.add(courseNode);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return rootNode; // Return the root node
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
