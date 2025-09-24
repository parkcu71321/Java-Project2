package q0924;

import java.io.*;

public class FileCopy2
{
    public static void CopyFile() throws IOException {          //throws는 예외를 던진다는 의미로 호출한 곳에서 예외 처리를 해줘야됨
        FileReader fr = null;       //파일을 읽는 도구 자리, 객체 연결을 안 해 null로 처리
        FileWriter fw = null;       //파일을 쓰는 도구 자리
        BufferedReader br = null;   //파일을 한 줄씩 읽기 위해

        fr = new FileReader("C:/JavaProjects/Mydata1.txt");       //파일을 읽어옴
        br=new BufferedReader(fr);      //한 줄 씩 읽기
        fw=new FileWriter("C:/JavaProjects/CopyFile1.txt");
        String line;

        while((line=br.readLine())!=null)       //파일 끝에 도달하면 null 값 전달
        {
            fw.write(line+"\n");
        }

        br.close();
        fw.close();
        System.out.println("복사 잘 됨.");

    }
    public static void main(String[] args)
    {
        try
        {
            CopyFile();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("파일 불러오지 못 함");
        }
        catch (IOException e) {
            System.out.println();
        }
    }
}
