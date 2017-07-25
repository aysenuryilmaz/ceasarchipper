package tr.org.linux.kamp.garbage;

import javax.crypto.spec.GCMParameterSpec;

public class Garbage {
	public static void main(String[] args) throws Throwable {
		Runtime rt = Runtime.getRuntime();//projenin akışını gösteren obje
		System.out.println("Toplam bellek: "+ rt.totalMemory());//toplak bellek miktarını öğrenmek
		
		String str= new String("Linux yaz kampı");
		String str1= new String("Linux yaz kampı");
		System.out.println(str);
		str=str1;
		str=null;
		
		GarbageTest garbageTest=new GarbageTest();
		garbageTest.value=1;
		garbageTest=null;
		
		System.out.println("Boş Bellek: "+ rt.freeMemory());
		//memoryi temizledi bize fazladan alan açtı
		System.gc();
		
		System.out.println("Boş Bellek Garbage collector çalıştıktan sonra: "+ rt.freeMemory());
		//system.gc'yi çalıştırdıktan sonra eğer garbagetest.value değerini bastırmak istersem çalışmıyor çünkü o nesneyi silmiş oluyoruz
		
	}
	
}
