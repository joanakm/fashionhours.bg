package fashionHours;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


import fashionHours.product.*;
import fashionHours.shop.Shop;
public class User {

	private static final int MAX_CHARS_IN_PASS=8;
	private static int methodInvokeCounter=1;
	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;
	private String password;
	private String phone;
	private ArrayList<Order> orders;
	private Address address;
	private boolean isLoggedIn=false;
	private static Shop shop;
	
	private enum Gender{
		MALE, FEMALE
	}
	
    public User(Shop s) {
		this.shop=s;
	}
	private User( String email, String phone, Address address) {
		
		this.email = email;
		this.phone = phone;
		this.orders = new ArrayList<>();
		this.address = address;
		
	}

	
	public void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("EMAIL: ");
		String email=null;
		if(validateEmailAddress(email)) {
			System.out.println("PASSWORD: ");
			String pass=sc.nextLine();
			if(validatePassword(pass)) {
				if(this.email.equals(email) && this.password.equals(pass)) {
					isLoggedIn=true;
				}else {
					System.out.println("Please, try again.");
				}
			}
		}
	}
	
	public void logout() {
		isLoggedIn=false; 
	}
	
	private boolean validatePhone(String ph) {
		return ph.matches("[0-9]+") && ph.length()==9;	
	}
	
	private boolean validateName(String name) {
		//matches any kind of letter from any language
	    return name.matches("^[\\p{L} .'-]+$");	
	}
	
	private boolean validatePassword(String pass) {
		//at least one digit
		//at least one upper case letter and one lower case letter
		//special character must occur at least once (?=.*[@#$%^&+=])
		//no whitespaces allowed
		//at least 8 chars
	    return pass.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}");	
	}
	
	private boolean validateEmailAddress(String e) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(e);
        return m.matches();
	}
	
 	public boolean enterPassword() {
		Scanner sc=new Scanner(System.in);
		String pass=null;
		do {
			System.out.println("Please, enter your password: ");
			pass=sc.nextLine();
			if(pass!=null && !pass.isEmpty()) {
				//check if it has at least 8 chars
				if(pass.length()<MAX_CHARS_IN_PASS) {
					System.out.println("Your password must be at least 8 symbols long.");
					continue;
				}
				//end check for number of chars
				//check for digit
				if(!checkForDigit(pass)) {
					System.out.println("Your password must contain at least one digit");
	                continue;
				}
                //end of check for digit
				//check for lower case letter
				if(!checkForLowerCase(pass)) {
					System.out.println("Your password must contain at least one lower case letter.");
					continue;
				}
				//end check for lower case letter
				//check for upper case letter
				if(!checkForUpperCase(pass)) {
					System.out.println("Your password must contain at least one upper case letter.");
					continue;
				}
				//end check for upper case letter
				//check if it contains spaces
				if(pass.contains(" ")) {
					System.out.println("Your password can not contain spaces.");
					continue;
				}
				//end check for spaces
				
				if(validatePassword(pass)) {
					this.password=pass;
					return true;
				}
			}
			
		}while(!validatePassword(pass)); 
		sc.close();
		return false;
	}
	
	private boolean checkForUpperCase(String p) {
		boolean upperCase = !p.equals(p.toLowerCase());
		if(upperCase) {
			return true;
		}
		return false;
	}
	
	private boolean checkForLowerCase(String p) {
		boolean lowerCase = !p.equals(p.toUpperCase());
		if(lowerCase) {
			return true;
		}
		return false;
	}
	
	private boolean checkForDigit(String p) {
		boolean hasDigit=false;
		for (char c : p.toCharArray()) {
             hasDigit= Character.isDigit(c);
            if(hasDigit) {
            	break;
            }
        }
		return hasDigit;
	}
	
	private boolean enterEmailAddress() {
        Scanner sc=new Scanner(System.in);
        String mail=null;
        do {
	        System.out.println("Please, enter your email address: ");
	        mail=sc.nextLine();
	        if(validateEmailAddress(mail)) {
	        	if(this.shop.canRegister(mail)) {
	        		this.email=mail;
	        		this.shop.addEmailToSet(this.email);
		        	return true;
	        	}else {
	        		enterEmailAddress();
	        	}
	        }
	    }while(!validateEmailAddress(mail));
        sc.close(); 
        return false;
   }
	
	private boolean enterPhone() {
		Scanner sc=new Scanner(System.in);
		String phone=null;
		do {
			System.out.println("Please, enter your mobile phone: ");
			System.out.print("+359");
			phone=sc.nextLine();
			if(validatePhone(phone)) {
				this.phone=phone;
				return true;
			}
		}while(!validatePhone(phone));
		sc.close();
		return false;
	}
	
	private boolean enterName() {
        Scanner sc=new Scanner(System.in);
        String name=null;
        do {
        	if(methodInvokeCounter==1) {
			  System.out.println("Please, enter your first name: ");
        	}
        	if(methodInvokeCounter==2) {
        	  System.out.println("Please, enter your last name: ");
        	}
			name=sc.nextLine();
			if(validateName(name)) {
				if(methodInvokeCounter==1) {
					this.firstName=name;
					methodInvokeCounter=2;
					return true;
				}
				if(methodInvokeCounter==2) {
					this.lastName=name;
					methodInvokeCounter=1;
					return true;
				}
				
			}
        }while(!validateName(name));
        sc.close();
        return false;
	}
	
	private void enterAndValidateGender() {
		Scanner sc=new Scanner(System.in);
		String gender=null;
		while(true) {
			boolean valid=false;
			System.out.println("Please, enter your gender: ");
			gender=sc.nextLine().toLowerCase();
			switch (gender){
			case "female": {
				this.gender=Gender.FEMALE;
				valid=true;
				break;
			}
			case "f":{
				this.gender=Gender.FEMALE;
				valid=true;
				break;
			}
			case "male": {
				this.gender=Gender.MALE;
				valid=true;
				break;
			}
			case "m":{
				this.gender=Gender.MALE;
				valid=true;
				break;
			}
			
			}
			if(valid) {
				break;
			}
		}
		
	}
	
	public void register() {
		//enter and validate first and last names
		enterName();
		enterName();
		
		//enter and validate password
		enterPassword();
		
		//enter and validate email
		enterEmailAddress();
		
		//enter and validate phone
	    enterPhone();
		
		//enter and validate gender
		enterAndValidateGender();
	}
	
	public void changeName() {
		enterName();
	    if(enterName()) {
	    	System.out.println("Your name has been changed.");
	    }
	}
	
	public void changePassword() {
		Scanner sc=new Scanner(System.in);
		String pass=null;
		do {
			System.out.println("Old password: ");
			pass=sc.nextLine();
			if(pass.equals(this.password)) {
				System.out.println("Set new password");
				enterPassword();
				System.out.println("Your password has been changed.");
				break;
			}
		}while(!pass.equals(this.password));
	}
	
	//getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	//end of getters
	
	//setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//end of setters
}
	
