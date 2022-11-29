package net.minedevhd.mineutil.utils.file_provider.impl;

import java.util.Map;

public interface FileProviderImpl {

    Map<String, byte[]> getData();

    boolean isAvailable();

}
