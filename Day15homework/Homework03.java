/*
(��װ)��֪һ���� Student �������£�
class Student{
    String name;
    int age;
    String address;
    String zipCode;
    String mobile;
}
Ҫ��
    1����Student �����Զ���Ϊ˽�У����ṩget/set �����Լ��ʵ��Ĺ��췽����
    2��ΪStudent �����һ��getPostAddress ������Ҫ�󷵻�Student ����ĵ�ַ���ʱࡣ
*/
public class Homework03{
	public static void main(String[] args){
		Student s=new Student();
		System.out.println(s.getName()+","+s.getPostAddress());
	}
}
class Student{
   private String name;
   private int age;
   private String address;
   private String zipCode;
   private String mobile;

	public Student(){
	 
	}
	public Student(String name,int age,String address,String zipCode,String mobile){
		this.name=name;
		this.age=age;
		this.address=address;
		this.zipCode=zipCode;
		this.mobile=mobile;
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setZipCode(String zipCode){
		this.zipCode=zipCode;
	}
	public String getZipCode(){
		return zipCode;
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	public String getMobile(){
		return mobile;
	}

	public String getPostAddress(){
		return "��ַ��"+this.getAddress()+",�ʱࣺ"+this.getZipCode();
	}
}