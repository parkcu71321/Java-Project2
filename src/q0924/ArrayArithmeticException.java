package q0924;

public class ArrayArithmeticException
{
    public static void main(String[] args)
    {
        int [] arr ={12,12,13};

        try
        {
            arr[3]=10;          //예외가 발생하면 그 밑 코드는 실행 안 하고 바로 catch문으로 돌아감
            arr[2]=10/0;

            for(int i=0; i<arr.length; i++)
            {
                System.out.println(arr[i]+"\t");
            }
        }catch(ArrayIndexOutOfBoundsException e)            //상속 관계 아닐 시 catch문 순서 중요하지 않음
        {
            System.out.println("배열의 인덱스 번호가 벗어남");
        }
        catch(ArithmeticException e)
        {
            System.out.println("나누는 수는 0일 수 없음");
        }
        catch(Exception e)
        {
            System.out.println("부모 클래스의 catch문은 자식이 실행되면 실행 안됨. Exception e는 모든 예외의 부모 클래스 ");
        }
        finally
        {
            System.out.println("프로그램 종료");
        }

    }
}
