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
        World world = Bukkit.getWorlds().get(0);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setTime(18000L);
        
        Bukkit.getPluginManager().registerEvents(this, this);


        new BukkitRunnable() {
            int count = 0;
            @Override 
            public void run(){
                count++;
                for (Player p : Bukkit.getOnlinePlayers()){

                    if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getType() == Material.IRON_HELMET) {
                    }
                    else {
                       p.damage(1);
                        if (count % 4 == 0){
                        p.sendMessage(ChatColor.RED + "CAN'T BREATHE! PUT ON HELMET! SEND FOR HELP!!");
                        }
                        p.getWorld().spawnParticle(Particle.WHITE_ASH, p.getLocation(), 10);
                    }
                }
            }
        }.runTaskTimer(this, 0L, 40L);

    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 2, false, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
        
        
    }
}
