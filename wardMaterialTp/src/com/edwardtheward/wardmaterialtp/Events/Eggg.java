package com.edwardtheward.wardmaterialtp.Events;

import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.edwardtheward.wardmaterialtp.Main;

public class Eggg implements Listener
{
	private Main plugin;

	public Eggg(Main plugin)
	{
		this.plugin = plugin;
	}

    @EventHandler
    public void onTP(ProjectileHitEvent e) 
    {
        Projectile proj = e.getEntity();
        boolean enabled = plugin.getConfig().getBoolean("egg-enabled");
        if(enabled)
        {
        	if (proj instanceof Egg) 
        	{
        		Egg eggg = (Egg)proj;
        		Player p = (Player)eggg.getShooter();
        		p.teleport((Entity)eggg);
        	}
        } else
        {
        	return;
        }
    }
}
