package q0827;
import java.util.Arrays;

public class ChangeLengthArray
{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println("현재 배열의 길이: " + arr.length);
        for (int i=0; i< arr.length; i++)
        {
            System.out.print(arr[i]+"\t");
        }

        arr=Arrays.copyOf(arr,arr.length+2);

        System.out.println("\n복사 후 배열의 길이: " + arr.length);
        for (int i=0; i< arr.length; i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }
}
