import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

 public class Fajlovi {
	 
	public static File file = new File("bankomat.txt");
	
	public static void Output() throws IOException {
		 try {
		    file.delete();
			file.createNewFile();
			FileWriter fileOutput = new FileWriter(file, true);
			PrintWriter output = new PrintWriter(fileOutput);
			for (Racun r : Main.racuni) {
				output.println(r.toString());
			}
			output.close();
			fileOutput.close();
		} catch (IOException e) {
			file.createNewFile();
		}  
	}
	
	public static void Input() throws Exception {
		 try {
			 FileReader fileInput = new FileReader(file);
			 BufferedReader input = new BufferedReader(fileInput);
			 String niz[] = new String[2];
			 String linijeFajla;
			 try {
			
			 while((linijeFajla = input.readLine()) != null) {
				 niz = linijeFajla.split(", ");
				 int brojRacuna = Integer.parseInt(niz[0]);
				 String imeVlasnikaRacuna = niz[1];
				 double iznosNaRacunu = Double.parseDouble(niz[2]);
				 if (!Main.racuni.contains(new Racun(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu)))
				 Main.racuni.add(new Racun(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu));
				 System.out.println(linijeFajla);
			 }
			 } catch (Exception e) {
				 
			 }
			 System.out.println();
			 
			 input.close();
			 fileInput.close();
		 } catch (IOException e) {}
 	 }
	

}