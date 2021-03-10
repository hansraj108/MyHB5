package com.main;

import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class BankAccountTest {

	public static void main(String[] args) {
		
		try(Scanner scn=new Scanner(System.in))
		{
			System.out.println("option 1:open account \n Option 2:Account details \n Option 3:Fund transfer \n Option 5:Exit");
			System.out.println("choose option : ");
			switch (scn.nextInt()) {
			
			case 1: //create account
				
			//check first the account is exists or not 	
//				System.out.println("Enter the account NO :");
//				int accNo=scn.nextInt();
//				BankAccount a=new BankAccount(accNo);//create (accNo)parameterized const. 
//				boolean flag=accounts.contains(a) ? true: false;
				
				
				//generate random number
				Random ran=new Random();
				Integer ran_1=ran.nextInt(100);
				System.out.println("rand no :"+ran_1);
				
				BankAccount a=new BankAccount(ran_1);
				System.out.println(a);
				if(accounts.contains(a)==false) {
					
				System.out.println("Enter account Details :");
				//int accNo, AcType type, double balance, String customerName
				System.out.println("type, balance, customerName");
											//ValidateAccountID(scn.nextInt()
				BankAccount a1=new BankAccount(ran_1,AcType.valueOf(scn.next().toUpperCase()), 
						ValidateBal(scn.nextDouble()), scn.next());
				//add account :  validated
				//add a1 reference to accounts index
						accounts.add(a1);
						System.out.println("Account created successfully !!\n"+ a1);
						
						break;
						}
				else {
					break;
				}
						
			case 2 : //display the info of account 
				//2. Accept account id from user & display a/c summary if a/c exists. 
				//or throw custom exception & display error mesg via catch block.
				//I/P : acct no

				System.out.println("All account info :");
				for (BankAccount l : accounts)
					System.out.println(l);//to string of BankAccount class
				break;
			case 3: //fund transfer 
				
				System.out.println("Enter the Your account No: ");
				int src =scn.nextInt();
				
				BankAccount index_src=accounts.get(src);
				System.out.println(index_src);
				if (accounts.contains(src)==true) {
					//ListIterator<BankAccount> index_src=accounts.listIterator(src);
					
					
					System.out.println("Enter the Destination account No :");
				int dest=scn.nextInt();
				if (accounts.contains(dest)) {
					ListIterator<BankAccount> index_dest=accounts.listIterator(dest);
					
				break;}
				else {
					System.out.println("try again later !!!");break;
				}}
				else {
					System.out.println("enter valid account no !!!");break;
				}
				
			
			case 5: // exit
				exit =true;
			}
		}catch (Exception e) {
		System.out.println("error occured >>>"+e.getMessage());
			System.out.println("please try again !!!");
		}
			//read scanner's data till the end of line 
			//clear the scanner's buffer
			scn.nextLine();
	}
		
	}
	catch (Exception e) {
	e.printStackTrace();	
	}

}

	}
}
