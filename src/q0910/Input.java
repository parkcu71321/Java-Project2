package q0910;
import java.util.ArrayList;
import java.util.Scanner;

public class Input
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];

        for(int i=0; i<num.length; i++)
        {
            System.out.print((i+1)+"번 째 숫자 입력: ");
            num[i]=sc.nextInt();
        }

        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(num[0]);
        arrInt.add(num[1]);
        arrInt.add(num[2]);

        System.out.println(Output.calc(arrInt));
    }
}
