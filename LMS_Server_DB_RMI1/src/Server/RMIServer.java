package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import Control.CCreateaccount;
import Control.CDBdirectory;
import Control.CGetInfo;
import Control.CLogin;
import inter.IDBdirectory;
import inter.ILogin;
import inter.Iaccount;
import inter.Igetinfo;

public class RMIServer {

	public void Server() {
		try {
			ILogin clogin = new CLogin();
			Iaccount ccreateaccount = new CCreateaccount();
			IDBdirectory cdbdirectory = new CDBdirectory();
			Igetinfo cgetInfo= new CGetInfo();  
			LocateRegistry.createRegistry(1099);
			Naming.rebind("CLogin", clogin);
			Naming.rebind("CCreateaccount", ccreateaccount);
			Naming.rebind("CDBdirectory", cdbdirectory);
			Naming.rebind("CGetInfo", cgetInfo);
			System.out.println("서버가 실행중입니다.");
		} catch (Exception e) {
			System.err.println("서버 오류");

		}

	}

}
