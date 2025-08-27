package q0827;

import java.util.Arrays;

public class CloneArray
{
    public static void main(String[] args)
    {
        String[] originStr1={"머리","가슴","배"};
        String[] originStr2=originStr1;

        originStr1[1]="파스타";
        originStr2[2]="돈가스";

        System.out.println(Arrays.toString(originStr1));
        System.out.println(Arrays.toString(originStr2));

        //
        String[] originStr3={"하나","두","세","네","다서"};
        String[] cloneStr=originStr3.clone();

        originStr3[2]="fuck";
        cloneStr[3]="fuck";

        System.out.println(Arrays.toString(originStr3));
        System.out.println(Arrays.toString(cloneStr));
    }
}
