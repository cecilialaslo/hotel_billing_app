package servicii;

public class Bar implements Servicii {
public String produs;
public double costUnitate;
public int nrUnitati;
public boolean isHappyHour;

public Bar(String produs, int nrUnitati, double costUnitate, boolean isHappyHour) {
	super();
	this.produs = produs;
	this.nrUnitati = nrUnitati;
	this.costUnitate = costUnitate;
	this.isHappyHour = isHappyHour;
}

public String getProdus() {
	return produs;
}

public void setProdus(String produs) {
	this.produs = produs;
}

public double getCostUnitate() {
	return costUnitate;
}

public void setCostUnitate(double costUnitate) {
	this.costUnitate = costUnitate;
}

public int getNrUnitati() {
	return nrUnitati;
}

public void setNrUnitati(int nrUnitati) {
	this.nrUnitati = nrUnitati;
}

public boolean isHappyHour() {
	return isHappyHour;
}

public void setHappyHour(boolean isHappyHour) {
	this.isHappyHour = isHappyHour;
}

public String toString() {
	return produs + ", buc: " + nrUnitati + ", pret: " + costUnitate + ", discount HappyHour (-20%): " + isHappyHour;
	
	}

//metoda getCost() calculeaza suma de plata pentru fiecare produs in parte (costUnitate * nr buc.) si aplica o reducere de HappyHour, daca este cazul.
public double getCost() {
	double cost;
	if(isHappyHour == true) {
		cost = (costUnitate * nrUnitati) - (20*(costUnitate * nrUnitati))/100;
		return cost;
	} else {
		cost = costUnitate * nrUnitati;
		return cost;
	}
}

}
