package fashionHours.shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Shop {

	private Set<String> emails=new HashSet<>();
	private Set<String> cities=new TreeSet<String>();
	
	public Shop(){
		addCities();
	}
	
	public Set<String> getCities(){
		return this.cities;
	}
	
	private void addCities() {
		cities.add("BLAGOEVGRAD");
		cities.add("BURGAS");
		cities.add("VARNA");
		cities.add("VELIKO TURNOVO");
		cities.add("VIDIN");
		cities.add("VRACA");
		cities.add("GABROVO");
		cities.add("DOBRICH");
		cities.add("KARDJALI");
		cities.add("KUSTENDIL");
		cities.add("LOVECH");
		cities.add("MONTANA");
		cities.add("PAZARDJIK");
		cities.add("PERNIK");
		cities.add("PLEVEN");
		cities.add("PLOVDIV");
		cities.add("RAZGRAD");
		cities.add("RUSE");
		cities.add("SILISTRA");
		cities.add("SLIVEN");
		cities.add("SMOLYAN");
		cities.add("SOFIA");
		cities.add("STARA ZAGORA");
		cities.add("TURGOVISTE");
		cities.add("HASKOVO");
		cities.add("SHUMEN");
		cities.add("YAMBOL");
		cities.add("BANSKO");
		cities.add("BELICA");
		cities.add("GOCE DELCHEV");
		cities.add("RAZLOG");
		cities.add("SANDANSKI");
		cities.add("PETRICH");
		cities.add("SIMITLI");
		cities.add("YAKORUDA");
		cities.add("AITOS");
		cities.add("KAMENO");
		cities.add("KARNOBAT");
		cities.add("MALKO TURNOVO");
		cities.add("NESEBUR");
		cities.add("POMORIE");
		cities.add("PRIMORSKO");
		cities.add("SREDEC");
		cities.add("CAREVO");
		cities.add("AHTOPOL");
		cities.add("PROVADIYA");
		cities.add("GORNA ORYAHOVICA");
		cities.add("ELENA");
		cities.add("SVISHTOV");
		cities.add("SUHINDOL");
		cities.add("BELOGRADCHIK");
		cities.add("BREGOVO");
		cities.add("DIMOVO");
		cities.add("CHUPRENE");
		cities.add("BOROVAN");
		cities.add("KOZLODUYI");
		cities.add("KRIVODOL");
		cities.add("MEZDRA");
		cities.add("MIZIYA");
		cities.add("ORYAHOVO");
		cities.add("GABROVO");
		cities.add("SEVLIEVO");
		cities.add("TRYAVNA");
		cities.add("BALCHIK");
		cities.add("KAVARNA");
		cities.add("TERVEL");
		cities.add("SHABLA");
		cities.add("ARDINO");
		cities.add("KIRKOVO");
		cities.add("BOBOV DOL");
		cities.add("RILA");
		cities.add("LUKOVIT");
		cities.add("YABLANICA");
		cities.add("TROYAN");
		cities.add("LOM");
		cities.add("CHIPROVCI");
		cities.add("VELINGRAD");
		cities.add("PANAGIYRISHTE");
		cities.add("RADOMIR");
		cities.add("TRUN");
		cities.add("LEVSKI");
		cities.add("KNEJA");
		cities.add("MARICA");
		cities.add("RAKOVSKI");
		cities.add("KUBRAT");
		cities.add("BYALA");
		cities.add("RUSE");
		cities.add("SILISTRA");
		cities.add("TUTRAKAN");
		cities.add("SLIVEN");
		cities.add("KOTEL");
		cities.add("RUDOZEM");
		cities.add("SMOLYAN");
		cities.add("CHEPELARE");
		cities.add("RADNEVO");
		cities.add("CHIRPAN");
		cities.add("HARMANLI");
		cities.add("HASKOVO");
		cities.add("KASPICHAN");
		cities.add("HITRINO");
		cities.add("ELHOVO");
	}	
	
	
	public void printCities() {
		for(String s: cities) {
			System.out.println(s);
		}
	}
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
