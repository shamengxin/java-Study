/*
��Ŀ������ 1! + 2! + 3! + 4! +... + 10!
    ˵����4! ��ʾ4�Ľ׳ˡ�4�Ľ׳��ǣ�1 * 2 * 3 * 4
*/
public class Homework03{
	public static void main(String[] args){
		int sum=0;
		for(int i=1;i<=10;i++){
			int tmp=1;
			for(int k=1;k<=i;k++){
				tmp*=k;
			}
			sum+=tmp;
		}
		System.out.println("1! + 2! + 3! + 4! +... + 10!���Ϊ"+sum);
	}
}