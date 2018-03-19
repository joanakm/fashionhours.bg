package fashionHours.product;

import java.util.HashMap;

import fashionHours.Address;
import fashionHours.User;
import fashionHours.shop.Cart;

public class Order {

	private Address address;
	private User user;
	private double price;
	private HashMap<Integer,Product> products;
	
	public Order(Address address, User user, double price, HashMap<Integer, Product> products) {
		super();
		this.address = address;
		this.user = user;
		this.price = price;
		this.products = products;
	}
	
	
	public User getUser() {
		return user;
	}
	
	public double getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "Order [address=" + address + ", user=" + user + ", price=" + price + ", products=" + products + "]";
	}
	
	
	
	
}
