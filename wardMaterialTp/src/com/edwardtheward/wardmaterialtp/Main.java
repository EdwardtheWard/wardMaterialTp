//main
package com.edwardtheward.wardmaterialtp;

import java.util.logging.Logger;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.edwardtheward.wardmaterialtp.Events.*;
import com.edwardtheward.wardmaterialtp.Executors.Executor;

public class Main extends JavaPlugin implements Listener
{
	public final Logger logger = Logger.getLogger("wardBowTp");
	

    public void onDisable() 
    {
        this.getLogger().info("Disabled.");
    }

    public void onEnable() 
    {
        this.getLogger().info("Enabled.");
        PluginManager pm = getServer().getPluginManager();
        
		Executor exe = new Executor(this);
		this.getCommand("wmtp").setExecutor((CommandExecutor)exe);
		this.getCommand("wardmaterialtp").setExecutor((CommandExecutor)exe);
		
        pm.registerEvents((Listener)new Bow(this), (Plugin)this);
        pm.registerEvents((Listener)new Eggg(this), (Plugin)this);
        pm.registerEvents((Listener)new Snow(this), (Plugin)this);
        
        if(!this.getDataFolder().exists())
            this.saveDefaultConfig();
    }

}