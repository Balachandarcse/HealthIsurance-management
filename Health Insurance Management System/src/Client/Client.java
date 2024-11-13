package Client;
import java.util.*;
import user.Users;
import InsuranceProvider.Admin;
import policy.Policy;
public class Client {
	public static void main(String args[]) {
		boolean flag=true;
		Users obj=new Users("bala","12345", 20,"xxxx", 3456789,"yyyy");
		Admin A_obj=new Admin("a1","12345",2324354,1001);
		while(flag) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1. User.\n2. Admin\n3.Exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("-----Enter the user details to login-----\n\n");
			System.out.println("Enter user name:");
			String Uname=sc.next();
			System.out.println("Enter user password:");
			String Password=sc.next();
			if(obj.CheckUser(Uname,Password))
			{
				boolean flag0=true;
				while(flag0) 
				{ 
				System.out.println("------login successful------");
				System.out.println("Enter the choice");
				System.out.println("1. View Available Policies\n"
						+ "2. Register for Policy\n"
						+ "3. Update Personal Detail\n"
						+ "4. Logout"
						);
				
				int userChoice=sc.nextInt();
				switch(userChoice) {
				case 1:
					ArrayList<Policy> arr=A_obj.viewPolicies();
					for(Policy ob: arr) {
						System.out.println(ob.id+" "+ob.name+" "+ob.duration+" "+ob.coverage);
					}
					break;
				case 2:
					System.out.println("enter the id of the policy: ");
					int id=sc.nextInt();
					Users ob=new Users();
					ArrayList<Integer> arr1=new ArrayList<>();
					arr1=ob.checkid(id);
					if(arr1.contains(id)) {
						ob.updatePolicy(Uname,id);
					}
					else {
						System.out.println("enter vaild id!");
					}
					break;
				case 3:
					obj.updateProfile(Uname);
					break;
				case 4:
					flag0=false;
					break;
					
				}//user switch case end
				}//while loop end
			}//if block end
			else {
				System.out.println("invaild username or password");
			}
			break;
			//case 1 end
		case 2:
			System.out.println("-----Enter Adimn details to login-----\n\n");
			System.out.println("Enter Admin name:");
			String Aname=sc.next();
			System.out.println("Enter Admin password:");
			String APassword=sc.next();
			int id=A_obj.CheckAdmin(Aname,APassword);
			if(id!=0) 
			{
				boolean flag1=true;
				while(flag1)
				{
				System.out.println("------login successful with id "+id+"-------");
				System.out.println("1. Create New Policy\n"
						+ "2. View All Policies\n"
						+ "3. Adduser\n"
						+ "4. Logout\n");
				int Achoice=sc.nextInt();
				switch(Achoice) 
				{
				case 1://creating new policies
					A_obj.createPolicy();
					break;
				case 2://view policies
					ArrayList<Policy> arr=A_obj.viewPolicies();
					for(Policy ob: arr) {
						System.out.println(ob.id+" "+ob.name+" "+ob.duration+" "+ob.coverage);
					}
					break;
				case 3:
					A_obj.Adduser();
					break;
				case 4:
					flag1=false;
					break;
				default:
					break;
				}
				System.out.println("logout successful");
				}//while loop end
			}
			else {
				System.out.println("invaild AdminName or password");
			}
			break;
		case 3:
			flag=false;
			break;
		default:
			System.out.println("invalid choice");
			break;	
		}//switch case end
		System.out.println("exiting....");
		}//while loop end
		
		}
	
}
