package Interfaces;
import policy.Policy;
import java.util.*;
public interface AdminInterface {
	void createPolicy();
	ArrayList<Policy> viewPolicies();
	void verify();
	void viewReports();
	void Adduser();
}
