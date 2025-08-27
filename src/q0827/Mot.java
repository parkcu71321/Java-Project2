package q0827;

public class Mot
{
    public static void main(String[] args)
    {
        String[] strAry = {"성찰하지 않는 삶은 살 가치가 없다","가장 훌륭한 선은 물과 같다",
                "아는 것을 안다고 하고, 모르는 것을 모른다고 하는 것. 이것이 곧 아는 것이다","인생은 B(Birth)와 D(Death) 사이의 C(Choice)이다"};

        int ranNum = (int)(Math.random()*3+1);

        System.out.println("오늘의 명언: "+strAry[ranNum]);
    }
}
