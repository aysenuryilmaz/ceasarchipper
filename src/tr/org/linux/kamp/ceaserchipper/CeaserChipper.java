package tr.org.linux.kamp.ceaserchipper;

import java.awt.AlphaComposite;
import java.util.Scanner;

public class CeaserChipper {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Bir anahtar değeri giriniz: ");
		int key = input.nextInt();

		input.nextLine();
		System.out.println("Şifrelenecek mesajı giriniz: ");
		String message = input.nextLine();// bütün satırı alıyor
		
		System.out.print("Şifreleme için 'E' çözümleme için 'D' ye basın: ");
		String password = input.next();

		if (password.equals("E")) {
			System.out.println(encyript(message, key));
		} 
		else if (password.equals("D")) {
			System.out.println(decrypt(message, key));
		} 
		else {
			System.out.println("Hatalı bir operasyon seçtiniz");
		}
	}

	public static String encyript(String enMessage, int key) {
		if (key < 0) {
			key = 26 - (-key % 26);
		}
		
		String result = "";
		for (int i = 0; i < enMessage.length(); i++) {
			char ch=enMessage.charAt(i);//bulunduğu indeks değerini aldık

			if(Character.isLetter(ch)) { //Harf mi diye baktık
				if(Character.isUpperCase(ch)) { //büyük harf ise
					result+=(char) ('A' + (ch + key - 'A') % 26);
				}
				else {//küçük harf ise
					result+=(char) ('a' + (ch + key - 'a') % 26);
				}
			}
			else {
				result=result+ch;
			}	
		}
		return result;
	}

	public static String decrypt(String deMessage, int key) {
		return encyript(deMessage, -key);
	}
}
