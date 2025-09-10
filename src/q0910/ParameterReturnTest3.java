package q0910;

import java.util.ArrayList;

public class ParameterReturnTest3
{
    public static void main(String[] args)
    {
        int[] arr={120,34,546};

        Calc1 c1 = new Calc1();
        int result = c1.plus(arr);

        System.out.println("출력값: "+result);

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(12);
        list.add(13);
        list.add(154);

        result=c1.plus(list);
        System.out.println("출력 값: "+result);
    }
}
