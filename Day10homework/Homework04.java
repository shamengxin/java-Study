/*
��Ŀ��һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�������£�
�����ڵ�10�����ʱ��������������
*/
public class Homework04{
	public static void main(String[] args){
		double sum=100;
		double high=100.0;
		for(int i=0;i<10;i++){
			high*=0.5;
			sum=sum+high*2;
		}
		System.out.println("һ������"+sum+"��");
	}
}