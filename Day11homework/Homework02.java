/*
��дһ���������������ĳ��������n����С��������
˼�����������Ӧ����ʲô���֣�����������β���ʲô�������ķ���ֵ������ʲô��
*/
public class Homework02{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		int n=s.nextInt();
		printMinPrimeNumber(n);
	}
	public static boolean primeNumber(int n){
		for(int i=2;i<n;i++){
			if(n%i==0)
				return false;
		}
		return true;
	}

	public static void printMinPrimeNumber(int n){
		while(true){
			n++;
			boolean i=primeNumber(n);
			if(i){
				System.out.println(n);
				break;
			}
		}
	}
}