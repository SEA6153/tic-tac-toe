package tic.tac.toe;

import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	static String[] oyunTahtasi = { "1", "2", "3", "4", "5", "6", "7", "8", "9" }; // bütün metdoların kullandığı bir
																					// değişken varsa
																					/// class seviyesine yükseltip
																					// hepsinin erişmesini sağladık.
	static final String OYUNCU_KAZANAN_DIZISI = "XXX";
	static final String BILGISAYAR_KAZANAN_DIZISI = "OOO";

	public static void main(String[] args) {
		boolean kazananVar = false;
		while (true) {
			oyunTahtasiGoster();

			kazananVar = kazananKontroluYap(OYUNCU_KAZANAN_DIZISI);
			if (kazananVar == true) {
				System.out.println("Oyuncu Kazandı!");
				System.out.println("Oyun bitti");
				break;
			}

			oyuncuHamlesi();

			oyunTahtasiGoster();

			kazananVar = kazananKontroluYap(BILGISAYAR_KAZANAN_DIZISI);
			if (kazananVar == true) {
				System.out.println("Oyun bitti");
				break;
			}

			bilgisayarHamlesi();

		}

	}

	static void bilgisayarHamlesi() {
		
		 for (int i = 0; i < 9; i++) {
	            if (oyunTahtasi[i].equals(String.valueOf(i + 1))) { //valueOf string veri tipini int e çevirir.
	                oyunTahtasi[i] = "X";
	                if (kazananKontroluYap(OYUNCU_KAZANAN_DIZISI)) {
	                    oyunTahtasi[i] = "O"; // Engelleme hamlesini yap
	                    return;
	                } else {
	                    oyunTahtasi[i] = String.valueOf(i + 1); // Engelleyemezse geri al
	                }
	            }
	        }
		 
		Random rastgeleSayiUretici = new Random();
		
		while (true) {
			int bilgisayarSecilenIndex = rastgeleSayiUretici.nextInt(0, 9); // sıfır dahil, 9 hariç yani 8'e kadar
			// dahil.

			if (oyunTahtasi[bilgisayarSecilenIndex] != "X" && oyunTahtasi[bilgisayarSecilenIndex] != "O") {
				oyunTahtasi[bilgisayarSecilenIndex] = "O";
				break;
			}

		}

	}

	static void oyuncuHamlesi() {
		while (true) {
			System.out.println("Oyun tahtasından bir sayı seçiniz: ");
			Scanner input = new Scanner(System.in);
			byte secilenSayi = input.nextByte();

			byte secilenSayiIcinIndex = (byte) (secilenSayi - 1); // casting

			if (oyunTahtasi[secilenSayiIcinIndex] != "X" && oyunTahtasi[secilenSayiIcinIndex] != "O") {
				oyunTahtasi[secilenSayiIcinIndex] = "X";
				break;
			} else {
				System.out.println("Hatalı hamle. Daha önce aynı yere hamle yapılmış.");
			}

			oyunTahtasi[secilenSayiIcinIndex] = "X";

		}

	}

	static boolean kazananKontroluYap(String kontrolEdilecekHamle) {
		boolean kazananVar = false;
		 int[][] kazananSerileri = {
			        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Yatay çizgiler
			        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Dikey çizgiler
			        {0, 4, 8}, {2, 4, 6}             // Çapraz çizgiler
			    };

			    for (int[] dizi : kazananSerileri) {
			        String a = oyunTahtasi[dizi[0]];
			        String b = oyunTahtasi[dizi[1]];
			        String c = oyunTahtasi[dizi[2]];
			        if (kontrolEdilecekHamle.equals(a + b + c)) {
			        if (kontrolEdilecekHamle.equals(OYUNCU_KAZANAN_DIZISI)) {
					System.out.println("OYUNCU KAZANDI");
					return kazananVar = true;
				} else {
					System.out.println("BİLGİSİAYAR KAZANDI");
				}
				System.out.println("OYUNCU OYUNU KAZANDI!");
				return kazananVar = true;
			}
			    
		}
			    return kazananVar;
	}
		
	// code reuse : aynı kodları tekrar kulllanmak.
	static void oyunTahtasiGoster() {
		System.out.println("-------------");
		System.out.println("| " + oyunTahtasi[0] + " | " + oyunTahtasi[1] + " | " + oyunTahtasi[2] + " | ");
		System.out.println("-------------");
		System.out.println("| " + oyunTahtasi[3] + " | " + oyunTahtasi[4] + " | " + oyunTahtasi[5] + "|");
		System.out.println("-------------");
		System.out.println("| " + oyunTahtasi[6] + " | " + oyunTahtasi[7] + " | " + oyunTahtasi[8] + " | ");
		System.out.println("-------------");

		System.out.println();
		System.out.println("############");
	}

}

