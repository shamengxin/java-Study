/*
�ӿ���̨����һ�����������жϸ������Ƿ�Ϊ����
������������ָ�ڴ���1����Ȼ���У�����1�����������ⲻ����������������Ȼ����
*/
public class Homework04
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		int i=s.nextInt();
		int j=0;
		boolean k=true;
		for(j=2;j<i;j++)
		{
			if(i%j==0)
				k=false;
			   break;
		}
		if(k==true)
			System.out.println(i+"������");
		else
			System.out.println(i+"��������");
	}
}