/*
��д�����ɼ����������������ֱ�������num1,num2,num3�У������ǽ�������
ʹ��if-else�ṹ��������С�����˳�����
*/
public class Homework05
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.println("����������������");
		int num1=s.nextInt();
		int num2=s.nextInt();
		int num3=s.nextInt();
		if(num1>num2)
		{
			int tmp=num1;
			num1=num2;
			num2=tmp;
		}
		if(num1>num3)
		{
			int tmp=num1;
			num1=num3;
			num3=tmp;
		}
		if(num2>num3)
		{
			int tmp=num2;
			num2=num3;
			num3=tmp;
		}
		System.out.println(num1+" "+num2+" "+num3);
	}
}