package q0917;

//io - 자바 파일 입출력
import java.io.FileWriter;      //파일에 문자 쓰는 클래스
import java.io.IOException;     //입출력 작업 중 오류 발생시 던지는 예외

public class FileWriteTest01
{
    public static void main(String[] args)
    {
        FileWriter fw = null;
        String line=null;
        try
        {
            fw =new FileWriter("C:/JavaProjects/MyData2.txt");

            line="같이 가자 어디든";
            fw.write(line+"\n");

            line="너무 높아 이 기분";
            fw.write(line+"\n");

            line="손을 잡아 fly away";
            fw.write(line+"\n");
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
