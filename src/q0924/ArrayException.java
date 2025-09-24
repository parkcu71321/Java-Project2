package q0924;

public class ArrayException
{
    public static void main(String[] args)
    {
           int [] arr ={12,12,13};

        try
        {
           arr[3]=10;
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("배열의 인덱스 번호가 벗어남");
        }
        for(int i=0; i<arr.length; i++)
        {
            System.out.println(arr[i]+"\t");
        }

    }
}
