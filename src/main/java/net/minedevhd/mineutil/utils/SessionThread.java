package net.minedevhd.mineutil.utils;

import net.labymod.main.LabyMod;
import net.minecraft.client.*;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;

public class SessionThread {
	
	public final Session createSession(final String username, final String password) {
        final YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        final YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
        auth.setUsername(username);
        auth.setPassword(password);
        try {
            auth.logIn();
            return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException ex) {
            return null;
        }
    }
	
	public final boolean isLoggedIn() {
		return LabyMod.getInstance().isPremium();
	}
	
}
