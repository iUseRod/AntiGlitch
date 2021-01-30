package me.UseRod.AntiGlitch;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void EnderpearlGlitch(PlayerTeleportEvent e) {
		if(!e.getPlayer().hasPermission("AntiGlitch.PearlBypass")) {
			String Prefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[" + ChatColor.RESET + "" + ChatColor.RED + "AntiGlitch" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "]";
			if(new Location(e.getTo().getWorld(), 0, e.getTo().getY() + 1, 0).getBlock().getType() != Material.AIR) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(Prefix + ChatColor.RED + "Please Don't Try To Glitch Or Actions Will Be Taken!");
			}else {
				e.setCancelled(false);
				e.getPlayer().sendMessage(Prefix + ChatColor.DARK_GREEN + "Teleportaion Successfully Done!");
			}
		}else {
			String Prefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[" + ChatColor.RESET + "" + ChatColor.RED + "AntiGlitch" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "]";
			if(new Location(e.getTo().getWorld(), 0, e.getTo().getBlockY(), 0).getBlock().getType() != Material.AIR) {
				e.setCancelled(false);
				e.getPlayer().sendMessage(Prefix + ChatColor.DARK_GREEN + "Luckily You Are Permitted To Bypass The System!");
			}else {
				e.setCancelled(false);
				e.getPlayer().sendMessage(Prefix + ChatColor.DARK_GREEN + "Teleportaion Successfully Done!");
			}
		}
	}
	@EventHandler
	public void BlockPlace(BlockPlaceEvent e) {
		String Prefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[" + ChatColor.RESET + "" + ChatColor.RED + "AntiGlitch" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "]";
		if(!e.getPlayer().hasPermission("AntiGlitch.BlockPlace")) {
			e.setCancelled(true);
			if(!e.getPlayer().hasPermission("AntiGlitch.BlockPlaceBypass")) {
				e.getPlayer().teleport(e.getPlayer().getLocation());
			}else {
				e.setCancelled(false);
				e.getPlayer().sendMessage(Prefix + ChatColor.DARK_GREEN + "Luckily You Are Permitted To Bypass The System!");
			}
		}
	}
	@EventHandler
	public void BlockBreak(BlockBreakEvent e) {
		String Prefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[" + ChatColor.RESET + "" + ChatColor.RED + "AntiGlitch" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "]";
		if(!e.getPlayer().hasPermission("AntiGlitch.BlockBreak")) {
			e.setCancelled(true);
			if(!e.getPlayer().hasPermission("AntiGlitch.BlockBreakBypass")) {
				e.getPlayer().teleport(e.getPlayer().getLocation());
			}else {
				e.setCancelled(false);
				e.getPlayer().sendMessage(Prefix + ChatColor.DARK_GREEN + "Luckily You Are Permitted To Bypass The System!");
			}
		}
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(!e.getPlayer().hasPermission("AntiGlitch.InteractBypass")) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}

	}
}
