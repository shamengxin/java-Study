/*
��һ��������5λ����������
Ҫ��
һ�������Ǽ�λ��
���������ӡ����λ����
*/
public class Homework08{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		int num=s.nextInt();
		int i=0;
		if(num>99999)
			System.out.print("����ֵ����");
		else{
			while(num>0){
				System.out.print(num%10+" ");
				i++;
				num/=10;
			}
			System.out.println();
			System.out.print("����"+i+"λ��");
		}
	}
}