package q0827;
import java.util.Arrays;
import static java.util.Collections.reverseOrder;

public class SortArray
{
    public static void main(String[] args)
    {
        int[] arr1 = {3,5,1,4,2,6,7,9};
        Arrays.sort(arr1);

        for(int i : arr1)
        {
            System.out.print(i+"\t");
        }

        System.out.println();

        String[] arr2 = {"a","y","e","b","w"};
        Arrays.sort(arr2,reverseOrder());

        for(String i : arr2)
        {
            System.out.print(i+"\t");
        }
    }
}
