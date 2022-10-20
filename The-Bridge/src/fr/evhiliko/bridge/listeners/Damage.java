package fr.evhiliko.bridge.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        Player player = (Player) event.getEntity();

        if (player.getLastDamageCause().getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {

            event.setCancelled(false);

        } else {

            event.setCancelled(true);

        }

        if (((player.getHealth() - player.getL)))

       /* if (((player.getHealth() - event.getFinalDamage()) <= 0) //Checks if the entity will die and if entity is player
                && player instanceof Player)
        {
            event.setCancelled(true);
            //Teleport, set health, whatever.
            new Respawn(player);

        }*/

    }

}
