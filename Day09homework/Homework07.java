/*
һ�������ǡ�õ�����������֮�ͣ�������������������� 6 = 1 + 2 + 3�����
�ҳ�1000�����е�����
*/
public class Homework07{
	public static void main(String[] args){
		System.out.print("1000���ڵ�������");
		for(int i=2;i<=1000;i++){
			int tmp=0;
			for(int n=1;n<i;n++){
				if(i%n==0)
					tmp+=n;
			}
			if(i==tmp)
				System.out.print(i+" ");
		}
	}
}