/*
��Ŀ��һ��5λ�����ж����ǲ��ǻ���������12321�ǻ�������
��λ����λ��ͬ��ʮλ��ǧλ��ͬ
*/
public class Homework01{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		System.out.print("������һ��5λ��:");
		int k=s.nextInt();
		int i=k;
		int num=0;
		if(i<9999||i>99999)
			System.out.println("����ֵ�Ƿ���");
		else{
			while(i!=0){
				int tmp=i%10;
				num=num*10+tmp;
				i/=10;
			}
			if(k==num){
				System.out.println(k+"��һ��������");
			}
			else{
				System.out.println(k+"����һ��������");
			}
		}
	}
}