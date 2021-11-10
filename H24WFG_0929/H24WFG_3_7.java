package h24wfg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class H24WFG_3_7 implements Serializable {

	public static void main(String[] args) {

		hf4();
		hf5();
		
	}
	
	private static final long serialVersionUID = 1L;
	String rsz;
	String tipus;
	int ar;

	public H24WFG_3_7(String r, String t, int a) {
		this.rsz = r;
		this.tipus = t;
		this.ar = a;
	}

	public static void hf4() {
		H24WFG_3_7[] autoim = { new H24WFG_3_7("R11", "Opel", 333), new H24WFG_3_7("R12", "Fiat", 233),
				new H24WFG_3_7("R14", "Skoda", 364) };
		try {
			ObjectOutputStream kifile = new ObjectOutputStream(new FileOutputStream("Autok.dat"));
			for (H24WFG_3_7 auto : autoim) {
				kifile.writeObject(auto);
			}
			kifile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File nyitasi hiba");
		}
		System.out.println("OK");
	}

	public static void hf5() {
		H24WFG_3_7 ma;
		try {
			File fn = new File("Autok.dat");
			if (fn.exists()) {
				ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("Autok.dat"));
				try {
					while (true) {
						ma = (H24WFG_3_7) kifile.readObject();
						if (ma.ar > 300) {
							System.out.println("rendszam=" + ma.rsz);
						}
					}
				} catch (EOFException ee) {
					ma = null;
				}
				kifile.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File nyitasi hiba");
		}
		System.out.println("OK2");
	}

}
