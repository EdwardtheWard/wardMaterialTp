//events - snow
package com.edwardtheward.wardmaterialtp.Events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.edwardtheward.wardmaterialtp.Main;

public class Snow implements Listener
{
	private Main plugin;

	public Snow(Main plugin)
	{
		this.plugin = plugin;
	}

    @EventHandler
    public void onTP(ProjectileHitEvent e) 
    {
        Projectile proj = e.getEntity();
        boolean enabled = plugin.getConfig().getBoolean("snowball-enabled");
        if(enabled)
        {
        	if (proj instanceof Snowball) 
        	{
        		Snowball s = (Snowball)proj;
        		Player p = (Player)s.getShooter();
        		p.teleport((Entity)s);
        	}
        } else
        {
        	return;
        }
    }
}
