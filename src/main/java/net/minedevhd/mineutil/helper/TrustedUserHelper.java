package net.minedevhd.mineutil.helper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TrustedUserHelper {
	
    private static final List<UUID> uuids = new ArrayList<UUID>();
    
	public static void loadUUIDConfigs() {
    	uuids.add(UUID.fromString("d130d7e6-8324-4ea5-8789-dc7531c2a611"));// MineDev_HD (migrated)
    	uuids.add(UUID.fromString("2300f88d-1ed7-4d34-a376-0edd2cb7a06a"));// TED_Knoppers87 (migrated)
    	uuids.add(UUID.fromString("ed0e7bc9-2aed-49f5-a49c-94e32b9afeef"));// Knoppers87 (migrated)
    	uuids.add(UUID.fromString("dcd8c83c-727e-443d-a99e-88cc1c48f89c"));// TEDCasino (migrated)
	}
	
	public static boolean contains(UUID uuid) {
		return uuids.contains(uuid);
	}
	
	public static final UUID AuthorId() {
		return UUID.fromString("d130d7e6-8324-4ea5-8789-dc7531c2a611");
	}
	
}
