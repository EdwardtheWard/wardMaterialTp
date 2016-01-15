package com.edwardtheward.wardmaterialtp.Executors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.edwardtheward.wardmaterialtp.Main;

public class Executor implements CommandExecutor
{
	private Main plugin;
	
	public Executor(Main plugin)
	{
		this.plugin = plugin;
	}
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
    	if(label.equalsIgnoreCase("wmtp") || label.equalsIgnoreCase("wardmaterialtp"))
    	{
    		String prefix = ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "wardMaterialTp" + ChatColor.GOLD + "] ";
    		if(args.length == 0)
    		{
    			sender.sendMessage(prefix + ChatColor.RED + "/wmtp <reload");
    			return true;
    		} else
    		if((args.length == 1) && args[0].equalsIgnoreCase("reload"))
    		{
    			plugin.reloadConfig();
    			sender.sendMessage(prefix + ChatColor.RED + "Configuration has been reloaded.");
    			return true;
    		} else
    		{
    			sender.sendMessage(prefix + ChatColor.RED + "/wmtp <reload");
    			return true;
    		}
    	}
		return false;
    }
}
