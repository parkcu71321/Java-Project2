package q0917;

//io - 자바 파일 입출력
import java.io.FileWriter;      //파일에 문자 쓰는 클래스
import java.io.IOException;     //입출력 작업 중 오류 발생시 던지는 예외
import java.util.Scanner;

public class FileWriteTest02
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = null;
        String line=null;

        try
        {
            fw =new FileWriter("C:/JavaProjects/MyData3.txt");

            while(true)
            {
                System.out.print("좋아하는 음식은?(q 입력 시 종료) : ");

                line=sc.nextLine();

                if(line.equals("q"))
                    break;

                fw.write(line+"\n");
            }
        }
        catch(IOException e)
        {
            System.out.println("FileWriter Generation Error");
        }

        try
        {
            fw.close();
        }catch(IOException e)
        {
            System.out.println("Closing Error");
        }
    }
}
