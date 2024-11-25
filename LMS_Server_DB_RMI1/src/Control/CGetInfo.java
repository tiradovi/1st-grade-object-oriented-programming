package Control;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.MGetinfo;
import inter.Igetinfo;

public class CGetInfo extends UnicastRemoteObject implements Igetinfo {

    private static final long serialVersionUID = 1L;

    public CGetInfo() throws RemoteException {
        super();
    }

    @Override
    public List<Object[]> getinfo(String courseName) throws RemoteException {
        try {
            MGetinfo mGetinfo = new MGetinfo();
            ResultSet resultSet = mGetinfo.getinfo(courseName);

            List<Object[]> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getString("캠퍼스명"),
                        resultSet.getString("대학명"),
                        resultSet.getString("학과명"),
                        resultSet.getString("강좌명"),
                        resultSet.getString("강의시간"),
                        resultSet.getString("교수명"),
                        resultSet.getInt("학점")
                };
                resultList.add(rowData);
            }

            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("SQL Exception: " + e.getMessage());
        }
    }
}
