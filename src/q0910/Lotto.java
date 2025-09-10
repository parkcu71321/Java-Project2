package q0910;

import java.util.ArrayList;

public class Lotto
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size()<6)
        {
            int rnm = (int)(Math.random()*45+1);        //1~45 랜덤 숫자 뽑기

            if(list.contains(rnm))      //배열에 해당 숫자 있음 다시 뽑기
                continue;
            else
                list.add(rnm);              //배열에 숫자 저장
        }
        System.out.println("로또 번호: "+list);
    }
}

//숫자 뽑기
//중복 숫자 다시 뽑기
//배열 저장
//출력