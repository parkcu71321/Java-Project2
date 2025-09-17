package q0917;
import java.io.*;

public class FileReadTest02
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = null;

        String line=null;

        int time=1;

        try
        {
            br = new BufferedReader(new FileReader(new File("C:/JavaProjects/MyData1.txt")));
            while(true)
            {
                line = br.readLine();
                if(line == null)
                    break;
                sb.append(time+" : "+line+"\n");
                time++;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Line read Error");
        }

        //sb.reverse();
        System.out.println(sb);

        try
        {
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Closing file Error");
        }
    }
}
