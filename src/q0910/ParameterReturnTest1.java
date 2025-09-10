package q0910;
import java.util.Scanner;

public class ParameterReturnTest1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자 입력: ");
        int n1 = sc.nextInt();

        System.out.print("두 번째 숫자 입력: ");
        int n2 = sc.nextInt();

        Calc1 calc1 = new Calc1();
        int result = calc1.plus(n1,n2);

        System.out.println("출력값: "+result);
    }
}
