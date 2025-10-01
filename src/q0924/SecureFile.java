package q0924;

import java.util.Scanner;
import java.io.*;

public class SecureFile
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        FileWriter fw=null;
        String line1="";        //읽어오는 변수


        try {
            fw=new FileWriter("C:/JavaProjects/secure1.txt");

            while(true)
            {
                System.out.print("Enter Message(null 값 입력 시 종료): ");
                line1=sc.nextLine();
                if(line1.equals(""))
                    break;
                String line2="";        //쓰는 변수
                for(int i=0; i<line1.length(); i++)
                {
                    int code=(int)line1.charAt(i);
                    code+=100;
                    line2+=(char)code;
                }
                fw.write(line2+"\n");
            }
        } catch (IOException e) {
            System.out.println("File Write Error");
        }

        try
        {
            fw.close();
            System.out.println("Generated SecureFile");
            sc.close();
        } catch (IOException e) {
            System.out.println("Closing File Error");
        }
    }
}
