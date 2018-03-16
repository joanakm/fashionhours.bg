package fashionHours.shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import fashionHours.product.Product;

public class Shop {

	//products with key-->id
	private HashMap<Integer, Product> productsInShop ;
	//Singleton
	private static Shop shop;
	
	private Shop() {
		System.out.println("======= FashionHours.bg created =======");
		this.productsInShop = new HashMap<>();
	}
		
	public static Shop createShop() {
		if(shop == null) {
			shop = new Shop();
			
		}
		return shop;
	}
	

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
	
	//====================================================
	public HashMap<Integer, Product> getProductsInShop() {
		return productsInShop;
	}
	
	public void addProduct(Product product, int quantity) {
		if(productsInShop.containsKey(product.getId())) {
			System.out.println("Sorry, this product is already in the shop.");
			return;
		}
		else {
			product.setQuantity(quantity);
			productsInShop.put(product.getId(), product);
		}
	}
	
	public void removeProduct(Product product, int quantity) {
		if(!(productsInShop.containsKey(product.getId()))) {
			System.out.println("Sorry, this product is not available in the shop and can not be removed.");
			return;
		}
		else {
			if(product.getQuantity() < quantity) {
				System.out.println("Sorry, the shop doesn't have "+quantity+" of this product.");
				return;
			}
			else {
				if(product.getQuantity() == quantity) {
					productsInShop.remove(product.getId());
				}
				else {
					productsInShop.get(product.getId()).setQuantity(product.getQuantity()-quantity);
				}
			}	
		}
	}
	
	public void sortbyLowestPrice() {
		TreeSet<Product> productsToSort = new TreeSet<>((Product o1, Product o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
		for(Product prod : productsInShop.values()) {
			productsToSort.add(prod);
		}	
		for(Product p : productsToSort) {
			System.out.println("Product id:"+ p.getId() + " with price: " + p.getPrice());
		}
	}

	public void sortbyHighestPrice() {
		TreeSet<Product> productsToSort = new TreeSet<>((Product o1, Product o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
		for(Product prod : productsInShop.values()) {
			productsToSort.add(prod);
		}	
		for(Product p : productsToSort) {
			System.out.println("Product id:"+ p.getId() + " with price: " + p.getPrice());
		}
	}
	
	
	@Override
	public String toString() {
		
		String s="";
		for(Product p : productsInShop.values()) {
			s += p.toString()+"\n";
		}
		return s;
		
	}
}
