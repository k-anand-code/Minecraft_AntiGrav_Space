import org.bukkit.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NoiseSpace extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        
        Bukkit.getPluginManager().registerEvents(this, this);
        System.out.println("Space Mod Loaded");

        count = 0;

        new BukkitRunnable() {
            @Override 
            public void run(){
                count++;
                for (Player p : Bukkit.getOnlinePlayers()){

                    if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getType() == Material.IRON_HELMET) {
                    }
                    else {
                       p.damage(1);
                        if (count % 10 == 0);{
                        p.sendMessage(ChatColor.RED + "CAN'T BREATHE! PUT ON HELMET! SEND FOR HELP!!");
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0L, 20L);

    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 2));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
        
        
        p.getWorld().spawnParticle(Particle.WHITE_ASH, p.getLocation(), 10);
        
        
    }
}
