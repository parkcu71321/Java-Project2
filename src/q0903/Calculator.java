package q0903;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.print("첫 번째 숫자 입력해 주세요: ");
            int num1 = sc.nextInt();

            System.out.print("연산자 입력해 주세요: ");
            String op = sc.next();

            if(op.equals("e"))          //문자열은 객체이므로 주소값이 있다. 그래서 ==을 사용하면 주소값을 비교함으로 .equals를 사용해 내용을 비교한다.
            {
                System.out.println("알파벳 e 입력 시 종료");
                break;
            }

            System.out.print("두 번째 숫자 입력해 주세요: ");
            int num2 = sc.nextInt();


            double result=calc(num1,num2,op);       //함수 호출 후 계산

            System.out.println("결과: "+result);
        }
        sc.close();
    }
    public static double calc(int n1, int n2, String op)
    {
        switch(op)
        {
            case "+":
                return n1+n2;
            case "-":
                return n1-n2;
            case "/":
                if(n2==0)
                {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return 0;
                }
                return (double)n1/n2;
            case "*":
                return n1*n2;
            default:
                System.out.println("잘못된 연산자입니다.");
                return 0;
        }
    }
}