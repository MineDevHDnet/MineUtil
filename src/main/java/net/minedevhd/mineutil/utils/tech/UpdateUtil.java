package net.minedevhd.mineutil.utils.tech;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UpdateUtil {

	public static final void downloadFile(String fromUrl, String localFileName) throws IOException {
	    final File localFile = new File(localFileName);
	    if(localFile.exists()) localFile.delete();
	    localFile.createNewFile();
	    
	    final URL url = new URL(fromUrl);
	    final OutputStream out = new BufferedOutputStream(new FileOutputStream(localFileName));
	    final URLConnection conn = url.openConnection();
	    final String encoded = Base64.getEncoder().encodeToString(("username"+":"+"password").getBytes(StandardCharsets.UTF_8));
	    
	    conn.setRequestProperty("Authorization", "Basic "+ encoded);
	    
	    final InputStream in = conn.getInputStream();
	    byte[] buffer = new byte[1024];

	    int numRead;
	    
	    while((numRead = in.read(buffer)) != -1) {
	        out.write(buffer, 0, numRead);
	    }
	    if(in != null) in.close();
	    if(out != null)	out.close();
	}

}
