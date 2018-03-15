package fashionHours.shop;

import java.util.HashSet;
import java.util.Set;

public class Shop {

	Set<String> emails=new HashSet<>();
	
	public void addEmailToSet(String e) {
		this.emails.add(e);
	}
}
