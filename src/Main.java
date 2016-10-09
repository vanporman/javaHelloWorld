import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		System.out.println("Laevade Pommitamine");
		System.out.println("Mängu autor: Andreas");
		System.out.println("Aasta: 2016");
		
		int [][] lauaAlgseis = new int [9][9];
		int [][] lauaSeis = new int [9][9];
		
		// 0 - meri
		// 1 - laev
		// 2 - pihta saanud laev
		
		// for tsükkli näide
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				lauaAlgseis[i][j] = (int) (Math.random() * 1.2);
			}
		}
		
		//while tsükkli nüide
		//int count3 = 0;
		//while (count3 < 9){
			//System.out.println(Arrays.toString(laud[count3]));
			//count3++;
		//}
		
		prindiManguLaud(lauaAlgseis);		//Näitab korra lauda koos asetatud laevadega
		System.out.println();
		// Näita mängijale lauda
		prindiManguLaud(lauaSeis);
	
			// Uus Scanner objekt, hakkame seda kasutama kasutajalt sisendi saamiseks
			Scanner sc = new Scanner(System.in);
			
			// Mängi enda tsükkel. Töötab nii kaua kuni näeb break; käsku.
			while(true){
				System.out.println("Vali koht kuhu pommitada? x-y koordinadid");
				String userInput = sc.nextLine();			// Küsi sisendit kasutajalt
				String[] xy = userInput.split("-");			// Löö string kaheks
				int x = Integer.parseInt(xy[0]) - 1;		//Muuda string integeriks
				int y = Integer.parseInt(xy[1]) - 1;
				
				int tabamus = lauaAlgseis[y][x];			// Küsi x-y positsioonilt number
				if (tabamus == 1) {                   	// Tuleb välja, et nr 1 oli seal
					lauaAlgseis[y][x] = 2;            	// Salvesta tabamus lauale
					lauaSeis[y][x] = 2;               	// Ja et kasutaja ka näeks tabamust
					System.out.println("Pihtas!");    	// Et mängijaga näeks inimese keeles ka mis juhtus.
				} else if (tabamus == 0) {            	// Juhul kui oli hoopis 0 sellel positsioonil.
					lauaSeis[y][x] = 3;               	// 3 on mööda. Seda näitame kasutajale, taustlauale pole vaja märkida
					System.out.println("Mööda!");
				}
				else if (tabamus == 2){
					System.out.println("Siia sa juba lasid");
				}
				else {
					System.out.println("Error");
				}
				prindiManguLaud(lauaSeis);				//Igal käigul prindi laud välja
				
				boolean labi = kasMangOnLabi(lauaAlgseis); 	//Meetod, mis vaatab peale igat tsüklit laua üle ja konrollib, kas laevu on veel
				if (labi){									//Kui laevu ei ole...
					break;									//...siis lähev tsükkel katki...
				}
			}
			System.out.println("Mäng on läbi");				//...on mäng läbi!	
	}
	
	//private tähendab, et see meetod on kättesaadav ainult siit failist
	//static tähendab, et meetodi välja kutsumiseks ei pea eraldi objekti looma
	//boolean tähendab, et meetod peab tulemiks tagastama kas true või false
	//meetod võtab sisse maatriksi ja me nimetame selle maatriksi ümber "laudLopp" muutujaks
	private static boolean kasMangOnLabi(int[][] laudLopp){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (laudLopp[j][i] == 1){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void prindiManguLaud(int[][] manguLaud){
		for (int i = 0; i < 9; i++){
			System.out.println(Arrays.toString(manguLaud[i]));
		}
	}
}

