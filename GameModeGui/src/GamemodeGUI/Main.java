/*
 * 
 * Sorry for my Spegetti code.....
 * 
 * 
 * 2023
 * 
 * 
 */

package GamemodeGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override // override logger.... idk why plugins have that.
    public void onEnable() {
        getLogger().info("[GamemodeGUI] Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[GamemodeGUI] Plugin has been disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("gmgui")) {
            player.openInventory(myInventory);
           
            
        }
        return true;
    }

    public static Inventory myInventory = Bukkit.createInventory(null, 9, "GamemodeGUI");

static {
       myInventory.setItem(0, new ItemStack(Material.IRON_BLOCK, 1));
       myInventory.setItem(1, new ItemStack(Material.DIAMOND_BLOCK, 1));
       myInventory.setItem(2, new ItemStack(Material.GOLD_BLOCK, 1)); 
       myInventory.setItem(3, new ItemStack(Material.LAPIS_BLOCK, 1)); 
       myInventory.setItem(8, new ItemStack(Material.STAINED_GLASS, 1)); 
       myInventory.equals(GameMode.CREATIVE); 
       /*
        * idk, game mode is just enabled i geuss....
        */
    		
       } 
     
      @EventHandler
      public void onInventoryClick(InventoryClickEvent event) {
      Player player = (Player) event.getWhoClicked();
      ItemStack clicked = event.getCurrentItem();
      Inventory inventory = event.getInventory();
      if (inventory.getName().equals(myInventory.getName())) {
      if (clicked.getType() == Material.IRON_BLOCK) {
      event.setCancelled(false);
      player.closeInventory();
      if (player.hasPermission("gamemodegui.survival")) {
      player.setGameMode(GameMode.SURVIVAL);
      player.sendMessage(ChatColor.RED + "Gamemode set to survival");
      } else {
      player.sendMessage(ChatColor.RED + "Error: You do not have the permission to use that command ");
      event.setCancelled(true);
      }
  }
  else if(clicked.getType() == Material.GOLD_BLOCK) {
	  event.setCancelled(false);
      
           }

            else if (clicked.getType() == Material.DIAMOND_BLOCK) {
                event.setCancelled(false);
                player.closeInventory();

                if (player.hasPermission("gamemodegui.creative")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.RED + "Gamemode set to creative");
                } else {
                    player.sendMessage(ChatColor.RED + "Error: You do not have the permission to use that command ");
                    }

            }

            if (clicked.getType() == Material.LAPIS_BLOCK) {
            event.setCancelled(false);
            player.closeInventory();

                if (player.hasPermission("gamemodegui.adventure")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.RED + "Gamemode set to adventure");
                } else {
                player.sendMessage(ChatColor.RED + "Error: You do not have the permission to use that command ");
                }

            }

            if (clicked.getType() == Material.IRON_BLOCK) {
                event.setCancelled(false);
                player.closeInventory();

                if (player.hasPermission("gamemodegui.spectator")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.RED + "Gamemode set to spectator");
                } else {
                    player.sendMessage(ChatColor.RED + "Error: You do not have the permission to use that command ");
                }
            } else {
                event.setCancelled(false);
                player.closeInventory();
            }
        }
    }
}