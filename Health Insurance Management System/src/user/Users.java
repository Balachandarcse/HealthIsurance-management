package user;
import java.util.*;
import dbcode.Dbcode;
import Interfaces.UserInterface;
public class Users implements UserInterface {
	private String UserName;
	private String Password;
	private int age;
	private String CurrentPolicy;
	private long PhoneNo;
	private String Address;
	public Users() {}
	public Users(String UserName, String Password, int age, String CurrentPolicy, long PhoneNo,String Address) {
		this.UserName=UserName;
		this.Password=Password;
		this.age=age;
		this.CurrentPolicy=CurrentPolicy;
		this.PhoneNo=PhoneNo;
		this.Address=Address;
	}
	Scanner sc=new Scanner(System.in);
	public boolean CheckUser(String name,String password) {
		return this.UserName.equals(name)&&this.Password.equals(password);
	}
	public ArrayList<Integer> checkid(int id) {
		Dbcode ob=new Dbcode();
		return ob.checkid(id);
	}
	public void updatePolicy(String uname,int id) {
		Dbcode ob=new Dbcode();
		ob.updatepolicy(uname,id);
	}

	public void updateProfile(String Uname) {
		System.out.println("enter what you need to update\n 1.name\n2.password\n3.age\n4.phone\n5.address");
		int ch=sc.nextInt();
		Dbcode ob=new Dbcode();
		switch(ch) {
		case 1:
			System.out.println("enter the new name:");
			String name=sc.next();
			ob.updatename(Uname,name);
			break;
		case 2:
			System.out.println("enter the new password:");
			String pass=sc.next();
			ob.updatepassword(Uname,pass);
			break;
		case 3:
			System.out.println("enter the new age:");
			int age=sc.nextInt();
			ob.updateage(Uname,age);
			break;
		case 4:
			System.out.println("enter the new phone number:");
			Long num=sc.nextLong();
			ob.updatephone(Uname,num);
			break;
		case 5:
			System.out.println("enter the new address:");
			String address=sc.next();
			ob.updateaddress(Uname,address);
			break;
		}
	}
} 
