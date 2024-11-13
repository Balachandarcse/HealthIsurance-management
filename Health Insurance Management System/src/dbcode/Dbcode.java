package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import policy.Policy;
import mysql.DBconnection;

public class Dbcode {
	 public int checkLogin(String userName,String passWord) {
		  String query="select * from admin where name= ? and password = ?";
		  try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			  pst.setString(1, userName);
			  pst.setString(2, passWord );
			  ResultSet res=pst.executeQuery();
			  if(res.next()) {
				  return res.getInt("id");
			  }else {
				  return 0;
			  }
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return 0;
	  }
	 public void createPolicy(String policyname,String duration,String coverage) {
		 String query="insert into policy (name,duration,coverage) values(?,?,?)";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setString(1,policyname);
			 pst.setString(2,duration);
			 pst.setString(3, coverage);
			 System.out.println(pst.executeUpdate());
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public ArrayList<Policy> getpolicies(){
		 ArrayList<Policy>Policy_data=new ArrayList<>();
		 String query="select * from policy";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 ResultSet res=pst.executeQuery();
			 while( res.next()) {
		         
	               Policy obj=new Policy();
	               obj.id=res.getInt("id");
	               obj.name=res.getString("name");
	               obj.duration=res.getString("duration");
	               obj.coverage=res.getString("coverage");
	              
	         Policy_data.add(obj);
	        }
			 return Policy_data;
			 
		 }
		 catch(Exception e) {
			 System.out.println("Can't get the policies!");
		 }
		 return null;
	 }
	 public void updatename(String uname,String name) {
		 String query="update user set name=? where name=?";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setString(1, name);
			 pst.setString(2, uname);
			 System.out.println("name updated successfully!");
			 
		 }
		 catch(Exception e) {
			 System.out.println("can't update policy"+e);
		 }
	 }
	 public void updatepassword(String uname,String password) {
		 String query="update user set password=? where name=?";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setString(1, password);
			 pst.setString(2, uname);
			 System.out.println("password updated successfully!");
			 
		 }
		 catch(Exception e) {
			 System.out.println("can't update policy"+e);
		 }
	 }
	 public void updateage(String uname,int age) {
		 String query="update user set age=? where name=?";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setInt(1, age);
			 pst.setString(2, uname);
			 System.out.println("age updated successfully!");
			 
		 }
		 catch(Exception e) {
			 System.out.println("can't update policy"+e);
		 }
	 }
	 public void updatephone(String uname,long num) {
		 String query="update user set phone=? where name=?";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setLong(1, num);
			 pst.setString(2, uname);
			 System.out.println("phone number updated successfully!");
			 
		 }
		 catch(Exception e) {
			 System.out.println("can't update policy"+e);
		 }
	 }
	 public void updateaddress(String uname,String address) {
		 String query="update user set address=? where name=?";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setString(1, address);
			 pst.setString(2, uname);
			 System.out.println("address updated successfully!");
			 
		 }
		 catch(Exception e) {
			 System.out.println("can't update policy"+e);
		 }
	 }
	 
	 
	 public void updatepolicy(String uname,int id) {
		 String query="update user set curr_policy=? where name=?";
		 String q2="select name from policy where id=?";
		 String a;
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query);
				 PreparedStatement pst1=con.prepareStatement(q2)){
			 pst1.setInt(1, id);
			 ResultSet res=pst1.executeQuery();
			 if(res.next()) {
				  a=res.getString("name");
			 }
			 else {
				 a=null;
			 }
			 pst.setString(1, a);
			 pst.setString(2, uname);
			 System.out.println("policy added successfully!");
			 
		 }
		 catch(Exception e) {
			 System.out.println("can't update policy"+e);
		 }
		 
	 }
	 
	 public ArrayList<Integer> checkid(int id){
		 ArrayList<Integer>data=new ArrayList<>();
		 String query="select * from policy where id=?";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setInt(1, id);
			 ResultSet res=pst.executeQuery();
			 while( res.next()) {
	               int a=res.getInt("id");
	              
	         data.add(a);
	        }
			 return data;
			 
		 }
		 catch(Exception e) {
			 System.out.println("Invaild id !");
		 }
		 return null;
	 }
	 
	 public void adduser(String name,String password,String CurrentPolicy,String Address,long PhoneNo,int age) {
		 String query ="insert into user (name,password,age,curr_policy,phone,address) values(?,?,?,?,?,?)";
		 try(Connection con = new DBconnection().getConnection();
				  PreparedStatement pst=con.prepareStatement(query)){
			 pst.setString(1,name);
			 pst.setString(2,password);
			 pst.setInt(3,age);
			 pst.setString(4,CurrentPolicy);
			 pst.setLong(5,PhoneNo);
			 pst.setString(6,Address);
			 System.out.println(pst.executeUpdate());
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
	 }
}
