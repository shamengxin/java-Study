/*
һ����λ����ǡ�õ���ȥ��������λ����֮����ʣ����λ����3�������
��λ���Ƕ��٣�
*/
public class Homework05{
	public static void main(String[] args){
		for(int i=1000;i<10000;i++){
			int n=i%1000;
			if(n*3==i){
				System.out.println("�����λ���ǣ�"+i);
			}
		}
	}
}