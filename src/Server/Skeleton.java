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
//���� ���� ����
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("������ ���۵Ǿ����ϴ�. ��Ʈ:" + port);
			while (true) {
				// Ŭ���̾�Ʈ ���� ���
				Socket clientSocket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�" + clientSocket.getInetAddress());

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
				System.out.println("Ŭ���̾�Ʈ�� ���� ���� �޼���:" + objectName + methodName + args + userId + password);
//Ŭ���̾�Ʈ�κ��� �޼��� �ޱ�
				Object object = this.objectMap.get(objectName);
				String result;

				result = (String) object.getClass().getMethod(methodName, String.class, String.class).invoke(object, userId, password);
				
				writer.println(result);

				clientSocket.close();

				System.out.println("Ŭ���̾�Ʈ ����" + clientSocket.getInetAddress());
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException
					| IOException e) {
				System.out.println("����");
				e.printStackTrace();
			}

		}
	}
}
