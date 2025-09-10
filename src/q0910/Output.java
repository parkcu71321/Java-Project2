package q0910;

import java.util.ArrayList;

public class Output
{
    public static String calc(ArrayList<Integer> arrInt)
    {
        int result1=0;
        int result2=1;

        for(int i=0; i<arrInt.size(); i++)
        {
            result1+=arrInt.get(i);
        }

        for(int i=0; i<arrInt.size(); i++)
        {
            result2=result2*arrInt.get(i);
        }
        return "덧셈: "+result1+"\t곱셉: "+result2;
    }
}
