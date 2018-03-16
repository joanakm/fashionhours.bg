package fashionHours;

import java.io.IOException;

import fashionHours.shop.Shop;


public class Demo {

	public static void main(String[] args) {
		Shop s=new Shop();
		User u = new User(s);
		u.register();
		//System.out.println(u.getPassword());
		User u2=new User(s);
		u2.register();
	}
	
}
