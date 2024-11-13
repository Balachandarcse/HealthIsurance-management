package InsuranceProvider;
import Interfaces.AdminInterface;
import dbcode.Dbcode;
import java.util.*;
import policy.Policy;
public class Admin implements AdminInterface{
	Scanner sc=new Scanner(System.in);
	private String AdminName;
	private String AdminPassword;
	private long Phone;
	private int AdminId;

	public Admin(String Aname,String Apassword,long phone,int id){
		this.AdminId=id;
		this.AdminName=Aname;
		this.AdminPassword=Apassword;
		this.Phone=phone;
	}
	
	public int CheckAdmin(String name,String password) {
		Dbcode adminDBCalls=new Dbcode();
		return adminDBCalls.checkLogin(name,password);
	}

	public void createPolicy() {
		System.out.println("Enter the policy name:");
		String policyname=sc.nextLine();
		System.out.println("Enter the valid duration:");
		String duration=sc.nextLine();
		System.out.println("Enter the coverage:");
		String coverage=sc.nextLine();
		Dbcode adminDBCalls=new Dbcode();
		adminDBCalls.createPolicy(policyname,duration,coverage);
		
	}
	public ArrayList<Policy> viewPolicies() {
		Dbcode adminDBCalls=new Dbcode();
		return adminDBCalls.getpolicies();
	}
	public void processClaim() {
		
	}
	public void verify() {
		
	}
	public void viewReports() {
		
	}
	public void Adduser() {
		System.out.println("Enter the user name:");
		String name=sc.nextLine();
		System.out.println("Enter the password:");
		String password=sc.nextLine();
		System.out.println("Enter the policy name:");
		String CurrentPolicy=sc.nextLine();
		System.out.println("Enter the Address:");
		String Address=sc.nextLine();
		System.out.println("Enter the phone number:");
		long PhoneNo=sc.nextLong();
		System.out.println("Enter the age:");
		int age=sc.nextInt();
		Dbcode adminDBCalls=new Dbcode();
		adminDBCalls.adduser(name,password,CurrentPolicy,Address,PhoneNo,age);
	}
}
