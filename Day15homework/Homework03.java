/*
(封装)已知一个类 Student 代码如下：
class Student{
    String name;
    int age;
    String address;
    String zipCode;
    String mobile;
}
要求：
    1、把Student 的属性都作为私有，并提供get/set 方法以及适当的构造方法。
    2、为Student 类添加一个getPostAddress 方法，要求返回Student 对象的地址和邮编。
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
		return "地址："+this.getAddress()+",邮编："+this.getZipCode();
	}
}