package sql;

import java.sql.*;
import java.util.Scanner;

public class RequestReagent {
	
	public static void main(String[] args) {
		
		Connection myConn = null;
		Statement myStmt = null;
		
		try {
			myConn = DriverManager.getConnection("", "sa", "920108");
			myConn.setAutoCommit(false);
			
			System.out.println("Please double check the infomation of the reagent that you are requesting.");
			showReagents(?);
			
			// Transaction Step 1: Delete the reagent from Reagents set
			myStmt = myConn.createStatement();
			myStmt.executeUpdate("delete from reagents where name rname='?' and lid='?'");
			// Transaction Step 2: Update the bbpoint balance of both requesting lab and giving lab.
			myStmt.executeUpdate("update labs set pbalance=? where lid='?'");
			
			System.out.println("Please confirm your request.");
			boolean ok = ifOkToSave();
			if (ok) {
				myConn.commit();
				System.out.println("Your request is received.");
			} else {
				myConn.rollback();
				System.out.println("Your request is canceled.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean ifOkToSave() {
		System.out.println("Is it "
	}

}
