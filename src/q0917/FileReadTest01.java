package q0917;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest01 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
//            파일 열기
            br = new BufferedReader(new FileReader("D:/FileTest/MyData1.txt"));
            int num = 1;
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.printf("%d : %s\n", num++, line);
            }
        }catch (FileNotFoundException e){
            System.out.println("현재 경로에서 파일을 찾을 수 없습니다.");
            return;
        }catch (IOException e){
            System.out.println("한 줄씩 읽는 동안 문제가 발생 했습니다.");
            return;
        }

        try {
            br.close();
        } catch (IOException e) {
            System.out.println("BufferedReader를 닫는데 문제가 발생했습니다.");
        }

    }
}
