/*
�Ӽ��̽���һ��������������������Ϊ�������������ͼ��
    *
   ***
  *****
 *******
*********
���磺����5�����ӡ����ͼ5�С�
*/
public class Homework05
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		int m,n;
		for(m=1;m<=i;m++)
		{
			for(n=1;n<=i-m;n++)
				System.out.print(" ");
			for(n=1;n<=m*2-1;n++)
				System.out.print("*");
			System.out.println();
		}
		

	}
}