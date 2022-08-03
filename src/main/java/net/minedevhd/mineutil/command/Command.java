package net.minedevhd.mineutil.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public abstract class Command implements UtilCore {
	
	private String name;
	private String displayName;
	private String description;
	private String syntax;
	private Category category;
	private List<String> aliases = new ArrayList<String>();
	
	public Command(String name, String displayName, String description, String syntax, Category category) {
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.syntax = syntax;
		this.category = category;
	}
	
	public abstract void onCommand(String[]  args, String command);
	
	public abstract void update();

	public abstract boolean isActivated();
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSyntax() {
		return this.syntax;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public List<String> getAliases() {
		return this.aliases;
	}

	public static final String transformMessage(final String module, final boolean value) {
		return mineUtil.getSettings().getPrefix() + "§7Module §e" + module + "§7 is now " + (value ? "§aactivated" : "§cdeactivated") + "§7.";
	}
	
	public static void initCmdBase() {
		CommandManager.setup();
		
		mineUtil.getApi().getEventManager().register((MessageSendEvent) new MessageSendEvent() {
			@Override
			public boolean onSend(String string) {
				String message = string;
				if(message.startsWith(CommandManager.getPrefix()) && !message.equals(CommandManager.getPrefix())) {
					message = message.substring(CommandManager.getPrefix().length());
					
					if(message.split(" ").length > 0) {
						final String commandName = message.split(" ")[0];
						
						for(Command c : CommandManager.getCommands()) {
							if(c.getAliases().contains(commandName) || c.getName().equalsIgnoreCase(commandName) || c.getSyntax().equalsIgnoreCase(commandName)) {
								if(mineUtil.getSettings().isModEnabled())
									c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
								else
									LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
											+ "§cIf the addon is deactivated, the commands are also deactivated!");
								return true;
							}
						}
					}
					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
							+ "§4Error! §cThe Command §8(§6" + string + "§8) §ccannot be found! §b(" + CommandManager.getPrefix() + "help)");
					return true;
				}
				return false;
			}
		});
	}

}
