/*
����ָ���·ݣ���ӡ���·������ļ��ڡ�
    3,4,5 ���� 
    6,7,8 �ļ� 
    9,10,11 �＾ 
    12, 1, 2 ����
 
    if��switch��дһ��
*/
public class Homework01
{
	public static void main(String[] args)
	{
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.print("�����������·ݣ�");
		int i=s.nextInt();
		if(i>=1&&i<=12)
		{
			switch(i)
			{
				case 3:case 4:case 5:
					System.out.println("���������·��Ǵ�����");
					break;
				case 6:case 7:case 8:
					System.out.println("���������·����ļ���");
					break;
				case 9:case 10:case 11:
					System.out.println("���������·����＾��");
					break;
				case 1:case 2:case 12:
					System.out.println("���������·��Ƕ�����");
					break;
			}
			/*����if��
			if(i>=3&&i<=5)
			{
				System.out.println("���������·��Ǵ�����");
			}
			else if(i>=6&&i<=8)
			{
				System.out.println("���������·����ļ���");
			}
			else if(i>=9&&i<=11)
			{
				System.out.println("���������·����＾��");
			}
			else
			{
				System.out.println("���������·��Ƕ�����");
			}
			*/
		}
		else
		{
			System.out.println("�����·����󣬳����˳���");
		}
	}
}