import java.io.IOException;

public class Racun {
	
	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double iznosNaRacunu;
	
	public Racun() {
		
	}

	public Racun (int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) throws IOException {
		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.iznosNaRacunu = iznosNaRacunu;
	}
	
	public void informacije() throws IOException {
		System.out.println("Broj racuna: " + brojRacuna);
		System.out.println("Ime vlasnika racuna: " + imeVlasnikaRacuna);
		System.out.println("Iznos na racunu: " + iznosNaRacunu);
	}
	
	@Override
	public String toString() {
		return brojRacuna + ", " + imeVlasnikaRacuna + ", " + iznosNaRacunu;
	}

	public int getBrojRacuna() {
		return brojRacuna;
		
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnikaRacuna() {
		return imeVlasnikaRacuna;
	}

	public void setImeVlasnikaRacuna(String imeVlasnikaRacuna) {
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
	}

	public double getIznosNaRacunu() {
		return iznosNaRacunu;
	}

	public void setIznosNaRacunu(double iznosNaRacunu) {
		this.iznosNaRacunu = iznosNaRacunu;
	}
	
}
