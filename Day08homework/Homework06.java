/*
���𲽼�8Ԫ��3KM���ڣ�
����3KM��������ÿ����1.2Ԫ
����5KM��������ÿ����1.5Ԫ
���ڼ����Ͻ��չ��������ó��ܼۡ�
*/
public class Homework06
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.printf("����������ʻ�Ĺ�������");
		int i=s.nextInt();
		if(i<=3)
			System.out.printf("�������Ϊ8Ԫ��");
		else if(i>3&&i<=5)
		{
			double j=8+(i-3)*1.2;
			System.out.printf("�������Ϊ"+j+"Ԫ��");
		}
		else
		{
			double k=8+2*1.2+(i-5)*1.5;
			System.out.printf("�������Ϊ"+k+"Ԫ��");
		}

	}
}