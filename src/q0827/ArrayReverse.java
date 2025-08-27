package q0827;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReverse
{
    public static void main(String[] args)
    {
        String[] member={"이","하","나"};
        System.out.println("처음 배열: "+ Arrays.toString(member));

        Collections.reverse(Arrays.asList(member));     //asList를 사용해 배열 member를 list형태로 만든 후 요소의 값을 역으로 나타냄
        System.out.println("나중 배열: "+ Arrays.toString(member));
    }
}
