import org.bukkit.*;
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
        // I HOPE THIS WORKS LOL
        Bukkit.getPluginManager().registerEvents(this, this);
        System.out.println("!!! SPACE MOD LOADED !!! LETS GOO");
        
        // This makes the oxygen work i think?
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    // Check if they have a glass block on their head
                    if (p.getInventory().getHelmet() != null) {
                        if (p.getInventory().getHelmet().getType() == Material.GLASS) {
                            // They are safe for now...
                        } else {
                            p.damage(2);
                            p.sendMessage(ChatColor.RED + "CANT BREATHE!!! GET A HELMET!!!");
                        }
                    } else {
                        // If helmet is null they die
                        p.damage(2);
                        p.sendMessage(ChatColor.RED + "CANT BREATHE!!! GET A HELMET!!!");
                    }
                }
            }
        }, 0L, 40L);
    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        
        // Make them floaty like a spaceman
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 2));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
        
        // Cool dust effects
        p.getWorld().spawnParticle(Particle.WHITE_ASH, p.getLocation(), 10);
        
        // Random message so they know the mod is working
        // p.sendMessage("You are moving in space!"); // TODO: delete this later its annoying
    }
}