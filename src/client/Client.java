package client;


public class Client {
	public String nume;
	public String prenume;
	public String CNP;
	public Membership membership;
	public double avansAchitat;
	
	public Client(String nume, String prenume, String cNP, Membership membership, double avansAchitat) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		CNP = cNP;
		this.membership = membership;
		this.avansAchitat = avansAchitat;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public double getAvansAchitat() {
		return avansAchitat;
	}

	public void setAvansAchitat(double avansAchitat) {
		this.avansAchitat = avansAchitat;
	}

	@Override
	public String toString() {
		return "Client: \r Nume:" + nume + ", Prenume:" + prenume + "\n CNP:" + CNP + " \n Membership club:" + membership
				+ "\n Avans Achitat:" + avansAchitat + " RON";
	}
	
	
	
	
}



//toString cu /n