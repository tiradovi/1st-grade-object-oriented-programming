package model;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VLogin;
import valueObject.VUserInfo;

public class MAccount  {

    public VUserInfo login(VLogin vLogin) {
        VUserInfo vUserInfo = null;

        try {
            Scanner scanner = new Scanner(new FileReader("Account/account"));

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                if (tokens[0].equals(vLogin.getUserId())) {
                    if (tokens[1].equals(vLogin.getPassword())) {
                        vUserInfo = new VUserInfo();
                        vUserInfo.setName(tokens[2]);
                        vUserInfo.setPassword(tokens[1]);
                        vUserInfo.setUserId(tokens[0]);
                        break;
                    }
                }
            }
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없거나 찾을 수 없습니다");
            e.printStackTrace();
        }
        
        
        return vUserInfo;
    }
    public void updateUserInfo(VUserInfo vUserInfo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Account/account"));
            writer.write(vUserInfo.getUserId() + " " + vUserInfo.getPassword() + " " + vUserInfo.getName());
            writer.newLine();
            writer.close();
            System.out.println("사용자 정보가 업데이트되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 업데이트 오류");
            e.printStackTrace();
        }
    }
   
}