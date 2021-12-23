package client;

public enum Membership {
	
	PLATINUM ("Platinum"),
	GOLD ("Gold"),
	SILVER ("Silver"),
	NOT_A_MEMBER ("Not a member");
	
	private final String membership;
	
	Membership(String membership) {
		this.membership = membership;
	}
	
}
