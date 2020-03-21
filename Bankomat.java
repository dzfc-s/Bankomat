import java.io.IOException;
import java.util.Scanner;

public class Bankomat {

	Scanner input = new Scanner(System.in);
	
	public void stariFajlovi() throws Exception {
		try {
			System.out.println("Vec postojeci racuni: ");
			Fajlovi.Input();
		} catch (Exception e) {}
	}
	public void usluge() throws Exception {
		try {
			while(true) { 
				System.out.println("Izaberite opciju koju zelite: ");
				System.out.println("1.Kreirati racun;");
				System.out.println("2.Prebaciti novac s jednog racuna na drugi;");
				System.out.println("3.Ispisati detalje postojeceg racuna;");
					int odabir = input.nextInt();
				
				switch(odabir) {
					case(1):
						try {
							kreirajRacun();
						} catch (Exception e) {
							input.nextLine();
							System.out.println("Doslo je do greske, molimo Vas, unesite podatke ponovo..");
							System.out.println();
							kreirajRacun();
						}
						break;
					case(2):
						try {
							transferNovca();
						} catch (Exception e) {
							input.nextLine();
							System.out.println("Doslo je do greske, molimo Vas, unesite podatke ponovo..");
							System.out.println();
							transferNovca();
						}
						break;
					case(3):
						try {
							ispisDetaljaRacuna();
						} catch (Exception e) {
							input.nextLine();
							System.out.println("Doslo je do greske, molimo Vas, unesite podatke ponovo..");
							System.out.println();
							ispisDetaljaRacuna();
						}
						break;
				}
				if (odabir <= 0 || odabir > 3) 
					usluge();
			}
		} catch (Exception e) {
			input.nextLine();
			System.out.println("Doslo je do greske, molimo Vas, unesite podatke ponovo..");
			System.out.println();
			usluge();
		}
		
	}
	public void kreirajRacun() throws Exception {
		
		System.out.print("Unesite broj racuna: ");
		int unosBrojaRacuna = input.nextInt();
		
		System.out.print("Unesite ime vlasnika racuna: ");
		String unosImenaVlasnika = input.next();
		
		System.out.print("Unesite iznos na racunu: ");
		double unosIznosa = input.nextDouble();
		
		if(Provjera.provjeraBrojaRacunaPriKreiranju(unosBrojaRacuna) && Provjera.provjeraIznosaRacunaPriKreiranju(unosIznosa)) {
			Main.racuni.add(new Racun(unosBrojaRacuna, unosImenaVlasnika, unosIznosa));
			Fajlovi.Output();
			
			System.out.println("Vas racun je kreiran!");
		} else {
			System.out.println("Unesite podatke ponovo..");
			System.out.println();
			kreirajRacun();
		}
		System.out.println();
	}
	
	public static void uzimanjeNovcaSaRacuna(int sourceAccount, double unosIznosa) throws IOException {
		try {
		Racun trenutniRacun = null;

		for (Racun r : Main.racuni) 
			if(sourceAccount == r.getBrojRacuna())
				trenutniRacun = r;
	
		if(trenutniRacun != null) {
		trenutniRacun.setIznosNaRacunu(trenutniRacun.getIznosNaRacunu()-unosIznosa);
		Fajlovi.Output();
		}
		} catch (Exception e) {}
		
	}
	
	public static void dodavanjeNovcaNaRacun(int targetAccount, double unosIznosa) throws IOException {
		
		try {
		Racun trenutniRacun = null;
		
		for (Racun r : Main.racuni) 
			if(targetAccount == r.getBrojRacuna())
				trenutniRacun = r;
		
		if(trenutniRacun != null) {
		trenutniRacun.setIznosNaRacunu(trenutniRacun.getIznosNaRacunu()+unosIznosa);
		Fajlovi.Output();
		}
		} catch (Exception e) {}
	}
	public void transferNovca() throws Exception {
		System.out.print("Unesite broj racuna sa kojeg zelite prenijeti novac: ");
		int sourceAccount = input.nextInt();
		
		System.out.print("Unesite broj racuna na koji zelite prenijeti novac: ");
		int targetAccount = input.nextInt();
	
		System.out.print("Unesite iznos koji zelite prebaciti: ");
		double unosIznosa = input.nextDouble();
			
		if(Provjera.provjeraTargetRacuna(targetAccount) && Provjera.provjeraSourceRacuna(sourceAccount) && Provjera.provjeraIznosaNaSourceRacunu(sourceAccount, unosIznosa)) {
			uzimanjeNovcaSaRacuna(sourceAccount, unosIznosa);
			dodavanjeNovcaNaRacun(targetAccount, unosIznosa);
			System.out.println("Novac je uspjesno prebacen!");
		} else {
			System.out.println("Unesite podatke ponovo..");
			System.out.println();
			transferNovca();
		}
		System.out.println();
	}
	
	public void ispisDetaljaRacuna() throws Exception {
		
		System.out.print("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		for (Racun r : Main.racuni) {
			if (brojRacuna == r.getBrojRacuna()) {
				r.informacije();
				System.out.println();
				return;
			}
		}
				System.out.println("Broj racuna nije pronadjen, molimo Vas, unesite podatke ponovo..");
				System.out.println();
				ispisDetaljaRacuna();
			
			System.out.println();
	}
	
}
