/*
��дһ��������������n�Ľ׳ˣ�����5�Ľ׳���1*2*3*4*5
˼�����������Ӧ����ʲô���֣�����������β���ʲô�������ķ���ֵ������ʲô��
*/
public class Homework01{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		int n=s.nextInt();
		factoral(n);
	}
	public static void factoral(int n){
		int sum=1;
		for(int i=1;i<=n;i++){
			sum*=i;
		}
		System.out.println(n+"�Ľ׳�Ϊ��"+sum);
	}
}