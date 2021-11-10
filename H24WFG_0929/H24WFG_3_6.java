package h24wfg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class H24WFG_3_6 implements Serializable {

	public static void main(String[] args) {

		hf4();
		try {
			visszaolvas();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static final long serialVersionUID = 1L;
	String rsz;
	String tipus;
	int ar;

	public H24WFG_3_6(String r, String t, int a) {
		this.rsz = r;
		this.tipus = t;
		this.ar = a;
	}

	public static void hf4() {
		H24WFG_3_6[] autoim = { new H24WFG_3_6("R11", "Opel", 333), new H24WFG_3_6("R12", "Fiat", 233),
				new H24WFG_3_6("R14", "Skoda", 364) };
		try {
			ObjectOutputStream kifile = new ObjectOutputStream(new FileOutputStream("Autok.dat"));
			for (H24WFG_3_6 auto : autoim) {
				kifile.writeObject(auto);
			}
			kifile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hiba a fájl megnyitása során!\n");
		}
		System.out.println("OK");
	}
	
	public static void visszaolvas() throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Melyik rekordot szeretné visszaolvasni? Eddig " + db + " rekord van.\n");
		boolean ok = true;
		int olvas = 0;
		do {
			try {
				ok = true;
				olvas = sc.nextInt();
				if (olvas <= 0 || olvas > 10) {
					System.out.println("Nem jó számot adott meg!\n");
					ok = false;
				}
			} catch (NumberFormatException e) {
				System.out.println(e);
				ok = false;
			}
		} while (!ok);
		
		sc.close();
		
		int sor =1;
		H24WFG_3_6 ma;
		try {
			File fn = new File("Autok.dat");
			if (fn.exists()) {
				ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
				try {
					while (true) {
						ma = (H24WFG_3_6) kifile.readObject();
						if (sor==olvas) {
							System.out.println("Rendszam:  " + ma.rsz);
							System.out.println("Tipus: " + ma.tipus);
							System.out.println("Ár: " + ma.ar);
						}
						sor++;
					}
				} catch (EOFException ee) {
					ma = null;
				}
				kifile.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hiba a fájl nyitása során!\n");
		}
		System.out.println("OK2");
		
		sc.close();

		
		
	}

}
