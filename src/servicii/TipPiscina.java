package servicii;

public enum TipPiscina {
	INTRARE_PISCINA ("Intrare piscina"),
	INCHIRIERE_SEZLONG ("Inchiriere sezlong"),
	MASAJ ("Masaj"),
	SAUNA ("Sauna");
	
	private final String tipPiscina;

	TipPiscina (String tipPiscina) {
		this.tipPiscina = tipPiscina;
	}
	
}
