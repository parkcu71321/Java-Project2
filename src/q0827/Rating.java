package q0827;
import java.util.Scanner;

public class Rating
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        float ave=0;      //평균 점수
        float sum=0;      //총점
        int[] scores=new int[5];        //점수 저장 배열

        System.out.println("심사를 시작해 주세요. (1~10점)");

        for(int i=0; i<scores.length; i++)
        {
            System.out.print("점수: ");
            scores[i]=sc.nextInt();
            sum=sum+scores[i];
        }

        ave=sum/scores.length;

        System.out.println("평균 점수: "+ave);
    }
}
