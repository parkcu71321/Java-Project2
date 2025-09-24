package q0924;

import java.io.*;

public class ImageFileCopy
{
    public static void main(String[] args)
    {
        FileInputStream fis = null;     //바이트 단위로 파일 읽기 전용
        FileOutputStream fos = null;    //바이트 단위로 파일 쓰기 전용

        try {
            fis=new FileInputStream("C:/JavaProjects/르클렐르.jpg");
            fos=new FileOutputStream("C:/JavaProjects/CopyImageFile1.jpg");
            int ch;     //한 바이트씩 복제를 해야됨

            while((ch=fis.read())!=-1)      //파일 끝에 도달하면 -1 출력
            {
                fos.write(ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");      //FileInputStream의 예외
        } catch (IOException e) {
            System.out.println("Reading Character Error");          //
        }

        try
        {
            fis.close();
            fos.close();
            System.out.println("복사 잘 됨");
        }catch (IOException e) {
            System.out.println("Input Output Closing Error");
        }
    }
}
