import java.util.ArrayList;

public class Main {

	public static ArrayList<Racun> racuni = new ArrayList<Racun>();
	
	public static void main(String[] args) throws Exception {
		
		Bankomat bankomat = new Bankomat();
		
		try {
			bankomat.stariFajlovi();
			bankomat.usluge();
		} catch (Exception e) {}	
		
	}	
}
