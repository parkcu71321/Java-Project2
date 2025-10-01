package q0924;

import java.io.*;

public class FileCopy1
{
    public static void main(String[] args)
    {
        FileReader fr = null;       //파일을 읽는 도구 자리, 객체 연결을 안 해 null로 처리
        FileWriter fw = null;       //파일을 쓰는 도구 자리
        BufferedReader br = null;   //파일을 한 줄씩 읽기 위해

        try {           //예외가 발생할 수 있는 블록
            fr = new FileReader("C:/JavaProjects/Mydata1.txt");       //파일을 읽어옴
            br=new BufferedReader(fr);      //한 줄 씩 읽기
            fw=new FileWriter("C:/JavaProjects/CopyFile1.txt");
            String line;

            while((line=br.readLine())!=null)       //파일 끝에 도달하면 null 값 전달
            {
                fw.write(line+"\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못 했습니다");      //파일 리더의 예외- FileReader
        } catch (IOException e) {
            System.out.println("한 줄을 읽어올 수 없습니다");      //파일 읽는 도중, 파일 쓰는 도중 예외-br.readLinde,fw.write
        }

        try
        {
            br.close();
            fw.close();
            System.out.println("복사 잘 됨.");
        } catch (IOException e) {
            System.out.println("reader와 writer가 close 되지 못 했습니다.");
        }
    }
}
