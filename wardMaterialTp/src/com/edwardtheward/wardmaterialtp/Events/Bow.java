//events - Bow
package com.edwardtheward.wardmaterialtp.Events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.edwardtheward.wardmaterialtp.Main;

public class Bow implements Listener
{
	private Main plugin;

	public Bow(Main plugin)
	{
		this.plugin = plugin;
	}

    @EventHandler
    public void onTP(ProjectileHitEvent e) 
    {
        Projectile proj = e.getEntity();
        boolean enabled = plugin.getConfig().getBoolean("bow-enabled");
        if(enabled)
        {
        	if (proj instanceof Arrow) 
        	{
        		Arrow a = (Arrow)proj;
        		Player p = (Player)a.getShooter();
        		p.teleport((Entity)a);
        	}
        } else
        {
        	return;
        }
    }
}
