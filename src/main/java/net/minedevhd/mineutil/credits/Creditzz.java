package net.minedevhd.mineutil.credits;

public class Creditzz {
	
	String name,
		   link,
		   method;
	
	public Creditzz() {}
	
	public Creditzz setNLM(final String name, final String link, final String method) {
		this.name = name;
		this.link = link;
		this.method = method;
		return this;
	}
	
	public Creditzz clearList() {
		this.name = "";
		this.link = "";
		this.method = "";
		return this;
	}
	
	public String drawString() {
		return "§fName§8: §f" + this.name + "§7, §fYT§8: §f" + this.link + "§7, §fMethod§8: §f" + this.method;
	}
	
}
