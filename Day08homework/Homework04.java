/*
������С�Ƚϣ����������������Ƚϴ�С��
    ��x>y ��� >
    ��x=y ��� =
    ��x<y ��� <
*/
public class Homework04
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.println("����������������");
		int x=s.nextInt();
		int y=s.nextInt();
		if(x>y)
		{
			System.out.println(">");
		}
		else if(x<y)
			System.out.println("<");
		else
			System.out.println("=");
	}
}