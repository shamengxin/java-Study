/*
С��������ÿ�����2.5ԪǮ������������������ǣ�ÿ����һ���Ǵ�Ǯ�ĵ�5��
����5�ı����Ļ��������Ứȥ6ԪǮ�����ʣ����������죬С���ſ��Դ浽100ԪǮ��
*/
public class Homework06
{
	public static void main(String[] args)
	{
		int day=0;
		double deposit=0;
		while(true)
		{
			day++;
			deposit=deposit+2.5;
			if(day%5==0)
				deposit=deposit-6;
			if(deposit>=100)
			{
				System.out.println("��Ҫ����"+day+"��ſ��Դ浽100Ԫ");
				break;
			}
			
		}
	}
}