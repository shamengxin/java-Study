/*
3���ӿ���̨����һ������������������Ľ׳ˡ���������5���׳�Ϊ 5*4*3*2*1
*/
public class Homework03
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		int result=1;
		for(int j=2;j<=i;j++)
		{
			result*=j;
		}
		System.out.println(result);
	}
}