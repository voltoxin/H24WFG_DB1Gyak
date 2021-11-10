package h24wfg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class H24WFG_3_3 {

	public static void main(String[] args) {

		olvasas();
	}

	public static void olvasas() {
		String sor;
		String[] szavak;
		int sorid = 0;
		try {
			System.out.println("Az els� sz� a txt f�jl neve\n");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = null;
			System.out.println("�rj szavakat, a program az 'end' sz�ig olvas!\n");
			
			
			
			while (sorid >= 0) {
				sor = br.readLine();
				if (sorid == 0) {
					bw = new BufferedWriter(new FileWriter(sor));
				} else {
					bw.write(sor);
					bw.newLine();
					
					
					
				}
				sorid = sorid + 1;
				szavak = sor.split(" ");
				for (String sz : szavak) {
					if (sz.compareTo("end") == 0) {
						br.close();
						sorid = -1;
					}
				}
			}
			bw.close();
			System.out.println("Ok");
		} catch (Exception ee) {
			ee.printStackTrace();
		}
				
	}

}
