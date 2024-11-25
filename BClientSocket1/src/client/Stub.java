package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class Stub {
	private String serverIP;
	private int serverPort;
	public Stub(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}

	public String request(String objectName, String methodName, String args, String userId, String password) {
		try {

			Socket socket = new Socket(serverIP, serverPort);
			System.out.println("스텁과 스켈레톤 연결");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			out.println(objectName);
			out.println(methodName);
			out.println(args);
			out.println(userId);
			out.println(password);
			System.out.println("스텁이 스켈레톤으로 보낸 메시지: " + objectName + methodName + args + userId + password);

			String userInfo = in.readLine();
			System.out.println("서버로부터 받은 응답: " + userInfo);
			System.out.println("수강신청을 원하는 경우 1 입력");
			Scanner scanner = new Scanner(System.in);
			String choice = scanner.next();
			if (choice.equals("1")) {
				
				CLogin cLogin = new CLogin();
				cLogin.getUserInfo1(scanner, choice, choice);

			}
			socket.close();

			return userInfo;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String request1(String objectName, String methodName, String args, String userId, String password) {
		try {

			Socket socket = new Socket(serverIP, serverPort);
			System.out.println("스텁과 스켈레톤 연결");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			out.println(objectName);
			out.println(methodName);
			out.println(args);
			System.out.println("스텁이 스켈레톤으로 보낸 메시지: " + objectName + methodName + args);

			String userInfo = in.readLine();

			socket.close();

			return userInfo;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}