package servicii;

public class Camera implements Servicii {
	public String nrCamera;
	public TipCamera tipCam;
	boolean vederePano;
	int nrUnitati; // = nrNoptiCazare
	double costUnitate; // =costPeNoapteCazare
	
	public Camera(String nrCamera, TipCamera tipCam, int nrUnitati, int costUnitate, boolean vederePano) {
		super();
		this.nrCamera = nrCamera;
		this.tipCam = tipCam;
		this.nrUnitati = nrUnitati;
		this.costUnitate = costUnitate;
		this.vederePano = vederePano;
	}

	public String getNrCamera() {
		return nrCamera;
	}

	public void setNrCamera(String nrCamera) {
		this.nrCamera = nrCamera;
	}

	public TipCamera getTipCam() {
		return tipCam;
	}

	public void setTipCam(TipCamera tipCam) {
		this.tipCam = tipCam;
	}

	public boolean isVederePano() {
		return vederePano;
	}

	public void setVederePano(boolean vederePano) {
		this.vederePano = vederePano;
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
	
	public String toString() {
		return "Camera nr: " + nrCamera + ", tip: " + tipCam + ", nr. nopti: " + nrUnitati +
				", pret/noapte: " + costUnitate + " RON" + ", vedere panoramica: " + vederePano;
				
		}
	
	public double getCost() {
		double cost;
		if(vederePano == true) {
			cost = nrUnitati * costUnitate + 200;
			return cost;
		} else { cost = nrUnitati * costUnitate;
		return cost;
		}
	}

	
}
