/*
�����ɷ��� Husband �������� Wife��
�ɷ�������԰��������֤�ţ��������������ڣ����ӡ�
����������԰��������֤�ţ��������������ڣ��ɷ�
�ֱ�����������ṩ���췽�����޲������췽�����в������췽����Ҫ�ṩ����
��д���Գ��򣬴����ɷ����Ȼ���ٴ������Ӷ����ɷ����������Ӷ���
���Ӷ�������ɷ����Ҫ���ܹ����������ɷ���󡱵����ӵ����֣�
�����ܹ������������Ӷ��󡱵��ɷ�����֡�Ҫ���ܹ���������ִ�й��̵��ڴ�ͼ��
����Ҫ���ڳ�������ʾ����ָ���쳣��Ч����
*/
public class Homework05
{
	public static void main(String[] args){
		Husband h=new Husband("11111","����","1998-3-4",null);
		Wife w=new Wife("22222","С��","1994-3-2",null);
		h.wife=w;
		w.husband=h;
		System.out.println(h.name+"��������"+h.wife.name);
		System.out.println(w.name+"���ɷ���"+w.husband.name);
	}
} 
class Husband
{
	String idCard;
	String name;
	String brith;
	Wife wife;
	public Husband(){

	}
	public Husband(String s1,String s2,String s3,Wife w){
		idCard=s1;
		name=s2;
		brith=s3;
		wife=w;
	}
}
class Wife
{
	String idCard;
	String name;
	String brith;
	Husband husband;
		public Wife(){

	}
	public Wife(String s1,String s2,String s3,Husband h){
		idCard=s1;
		name=s2;
		brith=s3;
		husband=h;
	}
}
