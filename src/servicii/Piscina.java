package servicii;

public class Piscina implements Servicii {
	public TipPiscina serviciu; //tipPiscina = tipul de serviciu consumat: intrare piscina/inchiriere sezlong/masaj/sauna
	boolean isMorningWeekday;
	int nrUnitati; 
	double costUnitate;
	
	public Piscina(TipPiscina serviciu, int nrUnitati, double costUnitate, boolean isMorningWeekday) {
		super();
		this.serviciu=serviciu;
		this.nrUnitati = nrUnitati;
		this.costUnitate = costUnitate;
		this.isMorningWeekday = isMorningWeekday;
	}

	
	public TipPiscina getServiciu() {
		return serviciu;
	}



	public void setServiciu(TipPiscina serviciu) {
		this.serviciu = serviciu;
	}


	public boolean isMorningWeekday() {
		return isMorningWeekday;
	}

	public void setMorningWeekday(boolean isMorningWeekday) {
		this.isMorningWeekday = isMorningWeekday;
	}

	public int getNrUnitati() {
		return nrUnitati;
	}

	public void setNrUnitati(int nrUnitati) {
		this.nrUnitati = nrUnitati;
	}

	public double getCostUnitate() {
		return costUnitate;
	}

	public void setCostUnitate(double costUnitate) {
		this.costUnitate = costUnitate;
	}
	
	public double getCost() {
		double cost;
		if((isMorningWeekday == true) && (serviciu.equals(TipPiscina.INTRARE_PISCINA))) {
			cost = (costUnitate * nrUnitati) - (30*(costUnitate * nrUnitati))/100;
			return cost;
		} else {
			cost = costUnitate * nrUnitati;
			return cost;
		}
	}
	

	@Override
	public String toString() {
		return serviciu + ", pret/buc: " + costUnitate + ", buc: " +  nrUnitati + ", discount Weekday Morning (-30%): " + isMorningWeekday;
				
	} 
	
	
	
	

}
