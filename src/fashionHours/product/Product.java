package fashionHours.product;


import fashionHours.shop.Shop;

public abstract class Product{

	public enum ForGender{
		WOMAN,MAN
	}
	
	public enum TypeProduct{
		CLOTHES,SHOES,ACCSSESORIES
	}
	
	public enum KindClothes{
		BLOUSES,JEANS,JACKETS,TROUSERS,SKIRTS,SHIRTS,TSHIRTS,SWIMSUITS, HOODEDSWEATSHIRTS,DRESSES,BRASSIERES,SOCKS,COATS
	}
	
	public enum KindShoes{
		CLASSIC, BOOTS, SHOES, SANDALS, SPORT
	}
	
	public enum KindAccessories{
		JEWELRY, BELTS, WALLETS, KEYCHAINS, GLASSES, SUNGLASSES, WATCHES, SHAWLS, HATS, UMBRELLAS, BACKPACKS, BAGS
	}
	
	public enum Brand{
		NEXT,ESPRIT,ZEE,LANE,PEPE,JEANS,LONDON,PUMA,GUESS,DIESEL,DESIGUAL,CALVIN,KLEIN,
		COLLECTION,ASICS,CONVERSE,TED,BAKER,FOSSIL,DENIM,LIU,JO,NIKE,ADIDAS,ORIGINALS,LE,
		COQ,SPORTIF,LOVE,MOSCHINO
	}
	
	public enum SizeClothes{
		XS,S,M,L,XL
	}
	
	private static int count = 0;
	private Brand brand;
	private TypeProduct typeProduct;
	private String description;
	private int quantity;
	private int id=0;
	private double price;
	
	public Product(Brand brand, ForGender gender, TypeProduct product, String description, double price) {
	
		this.brand = brand;
		this.typeProduct = product;
		this.description = description;
		this.price = price;
		this.id = count++; 
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ID:"+id+", DESCRIPTION:"+description+", QUANTITY: "+quantity+", PRICE:"+price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void increaseQuantity() {
		this.setQuantity(this.getQuantity()+1);
	}
	
	public String getDescription() {
		return description;
	}
	
	
}
