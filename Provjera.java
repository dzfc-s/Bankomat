
public class Provjera {

	public static boolean provjeraBrojaRacunaPriKreiranju(int unosBrojaRacuna) {

		for (Racun r : Main.racuni) {
			if(unosBrojaRacuna < 0 || unosBrojaRacuna == r.getBrojRacuna()) {
				System.out.println("Ne mozete unijeti negativan ili vec postojeci broj racuna..");
				 return false;
			}
		}
		return true;
	}
	
	public static boolean provjeraIznosaRacunaPriKreiranju(double unosIznosa) {
			
			if(unosIznosa < 0) {
				System.out.println("Iznos na racunu ne moze biti negativan..");
				return false;
			}
			return true;
	}
	
	public static boolean provjeraTargetRacuna(int targetAccount) {
		
		Racun trenutniRacun = null;
		
		for (Racun r : Main.racuni) 
			if(targetAccount == r.getBrojRacuna()) 
				trenutniRacun = r;
		
		if(trenutniRacun != null) {
			targetAccount = trenutniRacun.getBrojRacuna();
			return true;
		}
			System.out.println("Uneseni racun nije pronadjen..");
			return false;
	}
	
	public static boolean provjeraSourceRacuna(int sourceAccount) {

		Racun trenutniRacun = null;
		
		for (Racun r : Main.racuni) 
			if(sourceAccount == r.getBrojRacuna()) 
				trenutniRacun = r;
		
		if(trenutniRacun != null) {
			sourceAccount = trenutniRacun.getBrojRacuna();
			return true;
		}
			System.out.println("Uneseni racun nije pronadjen..");
			return false;
		
	}
	public static boolean provjeraIznosaNaSourceRacunu(int sourceAccount, double unosIznosa) {
		
		Racun trenutniRacun = null;
		
		for (Racun r : Main.racuni) 
			if(sourceAccount == r.getBrojRacuna())
				trenutniRacun = r;
		
		if (trenutniRacun != null) 
			sourceAccount = trenutniRacun.getBrojRacuna();
			if(unosIznosa > trenutniRacun.getIznosNaRacunu()) {
				System.out.println("Nemate dovoljno sredstava na racunu..");
				return false;
			}
			return true;
	}
	
}
