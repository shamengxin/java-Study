
/*
��дһ����Book������̲�: 
    1.�������ԣ����ƣ�title����ҳ����pageNum��
    2.����ҳ����������200ҳ���������������Ϣ��������Ĭ��ֵ200
    3.Ϊ�������ṩ��ֵ��ȡֵ����
    4.���з���:detail�������ڿ���̨���ÿ���̲ĵ����ƺ�ҳ��
    5.��д������BookTest���в��ԣ�ΪBook��������Ը����ʼֵ����
	   ����Book�����detail��������������Ƿ���ȷ
*/
public class Homework01{
	public static void main(String[] args){
		Book b1=new Book("��ѧ",243);
		b1.detail();
	}
}

class Book
{
	private String title;
	private int pageNum;

	public Book(){
		title="δ֪";
		pageNum=200;
	
	}
	
	public Book(String s,int i){
		title=s;
		if(i<200){
			pageNum=200;
			System.out.println("����ҳ����������200ҳ,Ĭ�ϸ�ֵ200");
		}else{
			pageNum=i;
		}
		
	}

	public void setTitle(String s){
		title=s;
	}
	public String getTitle(){
		return title;
	}
	public void setPageNum(int i){
		if(i<200){
			System.out.println("����ҳ����������200ҳ,Ĭ�ϸ�ֵ200");
			pageNum=200; 
			return;
		}
		pageNum=i;
	}
	public int getPageNum(){
		return pageNum;
	}

	public void detail(){
		System.out.println("�̲����ƣ�"+title+",��ҳ��Ϊ"+pageNum);
	}
}