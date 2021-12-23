package main;
import java.util.ArrayList;

import client.Client;
import client.Membership;
import servicii.Camera;
import servicii.TipCamera;
import servicii.TipPiscina;
import servicii.Piscina;
import servicii.Bar;


public class Main {
	public static void main (String[] args) {
		
		//Creez cate un ArrayList pentru fiecare tip de cheltuiala. 
		//Fiecare ArrayList va fi folosit pentru a printa un desfasurator de cheltuieli si pentru a calcula totalul.
		ArrayList<Camera> cheltuieliCamera = new ArrayList<Camera>();
		ArrayList<Bar> cheltuieliBar = new ArrayList<Bar>();
		ArrayList<Piscina> cheltuieliPiscina = new ArrayList<Piscina>();		
		
		//Creez un client
		Client cl1 = new Client("Marinescu", "Clara", "25689526692", Membership.PLATINUM, 1200);
		
		//Clientul a inchiriat doua camere.
		//Creez cheltuieli de tip Camera: nrCamera, tipCamera, nr nopti, pret/noapte, vederePano
		Camera cam1 = new Camera("102", TipCamera.SINGLE, 3, 500, true);
		Camera cam2= new Camera("109", TipCamera.DOUBLE, 3, 900, false);
		
		//Cheltuielile clientului de la bar.
		//Creez cheltuiala de tip Bar: produs, nr. unitati, cost unitate, isHappyHour
		Bar b1 = new Bar("Cuba Libre", 2, 18.00, false);
		Bar b2 = new Bar("cappucino", 4, 10.00, true);
		Bar b3= new Bar("apa plata", 3, 9.00, false);
		Bar b4 = new Bar("arahide", 3, 15.00, false);
						
		//Cheltuielile clientului de la piscina.
		//Creez cheltuiala de tip Piscina: serviciu, nr. unitati, cost unitate, isMorningWeekDay
		
		Piscina p1 = new Piscina(TipPiscina.INTRARE_PISCINA, 2, 50, true);
		Piscina p2 = new Piscina(TipPiscina.MASAJ, 1, 100, false);
		Piscina p3 = new Piscina(TipPiscina.INCHIRIERE_SEZLONG, 2, 30, false);
		
		//Introduc fiecare tip de cheltuiala in ArrayList-ul corespunzator
		cheltuieliCamera.add(cam1);
		cheltuieliCamera.add(cam2);
		
		cheltuieliBar.add(b1);
		cheltuieliBar.add(b2);
		cheltuieliBar.add(b3);
		cheltuieliBar.add(b4);
		
		cheltuieliPiscina.add(p1);
		cheltuieliPiscina.add(p2);
		cheltuieliPiscina.add(p3);
		
		displayBonCamera(cheltuieliCamera);
		System.out.println();
		displayBonBar(cheltuieliBar);
		System.out.println();
		displayBonPiscina(cheltuieliPiscina);
		
		System.out.println();
		
	//	System.out.println(totalSejur(cl1, cheltuieliCamera, cheltuieliBar, cheltuieliPiscina));
		
		factura(cl1, cheltuieliCamera, cheltuieliBar, cheltuieliPiscina);
	
			
	}

	public static void displayBonBar(ArrayList<Bar> cheltBar) {
		System.out.println("Nota de plata bar:");
		for (Bar b : cheltBar) {
			System.out.println(b + " \r"  + b.getCost() + " RON");

		}
		System.out.println("Total bar: " + totalBar(cheltBar) + " RON");
	}
	
	public static double totalBar(ArrayList<Bar> cheltBar) {
		double total = 0;
		for (Bar b : cheltBar) {
			total = total + b.getCost();
		} 
		
		return total;
		
	}
	
	public static void displayBonCamera(ArrayList<Camera> cheltCam) {
		System.out.println("Nota de plata cazare camere:");
		for (Camera c : cheltCam) {
			System.out.println(c + " \r" + c.getCost() + " RON");
		}
		System.out.println("Total cazare: " + totalCam(cheltCam) + " RON");
		System.out.println("\r(Nota: Pentru camerele cu vedere panoramica, se percepe o taxa suplimentara de +200 RON/noapte)");
	}
	
	public static double totalCam(ArrayList<Camera> cheltCam) {
		double total = 0;
		for (Camera c : cheltCam) {
			total = total + c.getCost();
		} 
		
		return total;
		
	}
	
	public static void displayBonPiscina(ArrayList<Piscina> cheltPiscina) {
		System.out.println("Nota de plata piscina:");
		for (Piscina p : cheltPiscina) {
			System.out.println(p + " \r "+ p.getCost() + " RON");
		}
		System.out.println("Total piscina: " + totalPiscina(cheltPiscina) + " RON");
	}
	
	public static double totalPiscina(ArrayList<Piscina> cheltPiscina) {
		double total = 0;
		for (Piscina p : cheltPiscina) {
			total = total + p.getCost();
		} 
		
		return total;
		
	}
	

	
	public static double totalSejur (Client c, ArrayList<Camera> cheltCam, ArrayList<Bar> cheltBar, ArrayList<Piscina> cheltPiscina) {
		double totalSejur = 0;
		double totalCam = totalCam(cheltCam);
		double totalBar = totalBar(cheltBar);
		double totalPiscina = totalPiscina(cheltPiscina);
		
		totalSejur = totalCam + totalBar + totalPiscina;
		
		Membership membership = c.getMembership();
//		System.out.println("FACTURA CLIENT" + "\r \r" + c + "\r");
//		System.out.println("Recapitulare plata:");
//		System.out.println("Total cazare: " + totalCam + " RON \r Total bar: " + totalBar + "RON \r Total piscina: " +
//								totalPiscina + " RON \r Total sejur: " + totalSejur);
		
		switch (membership) {
		case PLATINUM:
			totalSejur = totalSejur - (totalSejur * 15) / 100;
			return totalSejur;

		case GOLD:
			totalSejur = totalSejur - (totalSejur * 10) / 100;
			return totalSejur;

		case SILVER:
			totalSejur = totalSejur - (totalSejur * 5) / 100;
			return totalSejur;

		case NOT_A_MEMBER:
			return totalSejur;

		}

		return totalSejur;

		
	}
	
	public static void factura (Client c, ArrayList<Camera> cheltCam, ArrayList<Bar> cheltBar, ArrayList<Piscina> cheltPiscina) {
		double totalCam = totalCam(cheltCam);
		double totalBar = totalBar(cheltBar);
		double totalPiscina = totalPiscina(cheltPiscina);
		double totalPartial = totalCam + totalBar + totalPiscina;
		double totalFinal = totalSejur(c, cheltCam, cheltBar, cheltPiscina);
		double discount = 0;
		double avansAchitat = c.getAvansAchitat();
		double restPlata = totalFinal - avansAchitat;
		Membership membership = c.getMembership();
		System.out.println("FACTURA SEDERE HOTEL \r" );
		System.out.println(c + "\r");
		System.out.println("Recapitulare plata: ");
		System.out.println("Total plata cazare: " + totalCam + " RON");
		System.out.println("Total plata bar: " + totalBar + " RON");
		System.out.println("Total plata cazare: " + totalPiscina + " RON");
		System.out.println("Total partial (inainte de discount): " + totalPartial + " RON");
		
		switch (membership) {
		case PLATINUM:
			discount = (totalPartial*15)/100;
			System.out.println("Discount Platinum (15%): " + "-" +  discount + " RON");
			break;
		
		case GOLD:
			discount = (totalPartial*10)/100;
			System.out.println("Discount Gold (10%): "+ "-" +  discount + " RON");
			break;
			

		case SILVER:
			discount = (totalPartial*5)/100;
			System.out.println("Discount Silver (5%): " + "-" +  discount + " RON");
			break;
			

		case NOT_A_MEMBER:
			discount = 0;
			System.out.println("Clientul nu este membru al clubului, discount: 0 RON");
			break;
		}
		
		System.out.println("\nTotal final: " + totalFinal + " RON");
		
		System.out.println("Avans achitat: " + avansAchitat + " RON");
		
		System.out.println("\nRest de plata: " + restPlata + " RON");
			
		
	}
	
	
	
}
