package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import control.CLogin;
import model.MAccount;

public class Skeleton {
	private final int port;
	HashMap<String, Object> objectMap;

	public Skeleton() {
		this.port = 12345;
		this.objectMap = new HashMap<String, Object>();
		this.objectMap.put("cLogin", new CLogin());
		this.objectMap.put("SMain", new SMain());

	}

	public void process() {

		try {
//서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("서버가 시작되었습니다. 포트:" + port);
			while (true) {
				// 클라이언트 연결 대기
				Socket clientSocket = serverSocket.accept();
				System.out.println("클라이언트가 연결되었습니다" + clientSocket.getInetAddress());

				Session session = new Session(clientSocket, objectMap);
				session.start();

			}
//	serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class Session extends Thread {
		private Socket clientSocket;
		private HashMap<String, Object> objectMap;

		public Session(Socket clientSocket, HashMap<String, Object> objectMap) {
			this.clientSocket = clientSocket;
			this.objectMap = objectMap;

		}

		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

				String objectName = reader.readLine();
				String methodName = reader.readLine();
				String args = reader.readLine();
				String userId = reader.readLine();
				String password = reader.readLine();
				System.out.println("클라이언트로 부터 받은 메세지:" + objectName + methodName + args + userId + password);
//클라이언트로부터 메세지 받기
				Object object = this.objectMap.get(objectName);
				String result;

				result = (String) object.getClass().getMethod(methodName, String.class, String.class).invoke(object, userId, password);
				
				writer.println(result);

				clientSocket.close();

				System.out.println("클라이언트 종료" + clientSocket.getInetAddress());
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
					| IOException e) {
				System.out.println("오류");
				e.printStackTrace();
			}

		}
	}
}
