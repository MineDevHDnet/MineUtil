package net.minedevhd.mineutil.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class TrustedUserHelper {

    private static final UUID AUTHOR_ID = UUID.fromString("d130d7e6-8324-4ea5-8789-dc7531c2a611");

    private static final Set<UUID> TRUSTED_UUIDS = Collections.unmodifiableSet(new HashSet<UUID>(Arrays.asList(
            AUTHOR_ID,
            UUID.fromString("4c9f7df5-2e05-4f0d-8ec0-d94a1c082297"),
            UUID.fromString("2300f88d-1ed7-4d34-a376-0edd2cb7a06a"),
            UUID.fromString("ed0e7bc9-2aed-49f5-a49c-94e32b9afeef")
    )));

    private TrustedUserHelper() {
    }

    /**
     * Kept for backwards compatibility. The trusted UUID set is initialized once
     * when this class is loaded and no longer grows on every invocation.
     */
    @Deprecated
    public static void loadUUIDConfigs() {
        // no-op
    }

    public static boolean contains(final UUID uuid) {
        return uuid != null && TRUSTED_UUIDS.contains(uuid);
    }

    public static UUID AuthorId() {
        return AUTHOR_ID;
    }
}
