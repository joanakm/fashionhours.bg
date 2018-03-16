package fashionHours.shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Shop {

	Set<String> emails=new HashSet<>();
	
	private void writeEmailInFile(String email) {
		File users=new File("users.txt");
		try(FileWriter fw = new FileWriter("users.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			out.println(email);
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
	public void addEmailToSet(String e) {
		this.emails.add(e);
		writeEmailInFile(e);
	}
	
	public boolean canRegister(String email) {
		if(emails.contains(email)) {
			System.out.println("Sorry, there is already a user associated with this email address.");
			return false;
		}
		return true;
	}
}
