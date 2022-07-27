/*
дһ����ΪAccount����ģ���˻���
��������Ժͷ���������ʾ��
������������ԣ��˻�id�����balance��������annualInterestRate��
�����ķ����������Ե�set��get������ȡ���withdraw()������deposit()
 
дһ�����Գ���
��1������һ��Customer�����ֽ�Jane Smith������һ���˺�Ϊ1000�����Ϊ2000��
������Ϊ1.23%���˻�
��2����Jane Smith������
����100Ԫ����ȡ��960Ԫ����ȡ��2000��
��ӡJane Smith�Ļ�����Ϣ
��Ϣ������ʾ��
�ɹ����룺100
�ɹ�ȡ����960
���㣬ȡǮʧ��
Customer [Smith��Jane] has a account ��id is 1000 annualInterestRate is 1.23% 
balance is 1140.0
*/
public class Homework02{
	public static void main(String[] args){
		Account a=new Account("1000",2000,1.23);
		Customer c=new Customer("Jane Smith",a);
		c.getAct().deposit(100);
		c.getAct().withdraw(960);
		c.getAct().withdraw(2000);
	}
}
class Account{
	private String id;
	private double balance;
	private double annualInterestRate;

	public Account(){
	
	}

	public Account(String id,double balance,double annualInterestRate){
		this.id=id;
		this.balance=balance;
		this.annualInterestRate=annualInterestRate;
	}

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate=annualInterestRate;
	}
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	//ȡ
	public void withdraw(double money){
		if(money>this.getBalance()){
			System.out.println("���㣬ȡǮʧ��");
			return;
		}
		this.setBalance(this.getBalance()-money);
		System.out.println("�ɹ�ȡ����"+money);
	}
	//��
	public void deposit(double money){
		//this.balance+=money;
		this.setBalance(this.getBalance()+money);
		System.out.println("�ɹ����룺"+money);
	}
}

class Customer{
	private String name;
	private Account act;
	
	public Customer(){
	
	}
	public Customer(String name,Account act){
		this.name=name;
		this.act=act;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAct(Account act){
		this.act=act;
	}
	public Account getAct(){
		return act;
	}

}