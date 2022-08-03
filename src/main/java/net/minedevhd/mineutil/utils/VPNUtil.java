package net.minedevhd.mineutil.utils;

import java.util.Random;

public class VPNUtil {
	
	private final String[] addresses = new String[] { "51.195.41.202", "45.135.202.132", "173.236.67.11" };

	public final String getIpAdress() {
		if(this.addresses != null) {
			int rnd = new Random().nextInt(addresses.length);
			return addresses[rnd];
		}
		return "Unkown";
	}
}
