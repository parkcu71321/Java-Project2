package q0820;

public class Array2Test
{
    public static void main(String[] args)
    {
        int [][] arr1=new int[2][3];
        int cnt=1;

        for(int i=0; i<arr1.length; i++)
        {
            for(int j=0; j<arr1[i].length; j++)
            {
                arr1[i][j]=cnt++;
                System.out.print(arr1[i][j]);
            }
            System.out.println();
        }
    }
}
