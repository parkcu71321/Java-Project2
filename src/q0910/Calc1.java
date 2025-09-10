package q0910;

import java.util.ArrayList;
import java.util.List;

public class Calc1
{
    static int plus(int n1, int n2)
    {
        int result;
        result=n1+n2;
        return result;
    }

    static int plus(int n1, int n2,int n3)
    {
        int result;
        result=n1+n2+n3;
        return result;
    }

    static int plus(int[] arr)              //int[] arr => List<Integer> 배열명   --  동적배열
    {
        int result =0;
        for(int i=0; i<arr.length; i++)
        {
            result=result+arr[i];
        }
        return result;
    }
    static int plus(ArrayList<Integer> arr)              //int[] arr => List<Integer> 배열명   --  동적배열
    {
        int result =0;
        for(int i=0; i<arr.size(); i++)
        {
            result=result+ arr.get(i);
        }
        return result;
    }
}
