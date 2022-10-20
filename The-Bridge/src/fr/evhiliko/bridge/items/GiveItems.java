package fr.evhiliko.bridge.items;

import fr.evhiliko.bridge.Main;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class GiveItems {

    public GiveItems(Player player) {

        if (Main.getRedTeam().contains(player)) {

            ItemStack c = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta cM = (LeatherArmorMeta) c.getItemMeta();
            cM.setColor(Color.RED);
            cM.spigot().setUnbreakable(true);
            c.setItemMeta(cM);

            ItemStack l = new ItemStack(Material.LEATHER_LEGGINGS);
            l.setItemMeta(cM);

            ItemStack b = new ItemStack(Material.LEATHER_BOOTS);
            b.setItemMeta(cM);

            player.getInventory().setChestplate(c);
            player.getInventory().setLeggings(l);
            player.getInventory().setBoots(b);

            player.getInventory().setItem(0, new ItemStack(getItem("§e§lCouteau", Material.IRON_SWORD,1 , (byte) 0, null, 0)));
            player.getInventory().setItem(1, new ItemStack(getItem("§e§lArc", Material.BOW,1 , (byte) 0, Enchantment.DURABILITY, 10069)));
            player.getInventory().setItem(2, new ItemStack(getItem("§e§lPomme", Material.GOLDEN_APPLE,8 , (byte) 0, null, 0)));
            player.getInventory().setItem(3, new ItemStack(getItem("§c§lBlocks", Material.STAINED_CLAY,64 , DyeColor.RED.getDyeData(), null, 0)));
            player.getInventory().setItem(4, new ItemStack(getItem("§c§lBlocks", Material.STAINED_CLAY,64 , DyeColor.RED.getDyeData(), null, 0)));
            player.getInventory().setItem(8, new ItemStack(getItem("§e§lFlèche", Material.ARROW,1 , (byte) 0, null, 0)));

        } else if (Main.getBlueTeam().contains(player)) {

            ItemStack c = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta cM = (LeatherArmorMeta) c.getItemMeta();
            cM.setColor(Color.BLUE);
            cM.spigot().setUnbreakable(true);
            c.setItemMeta(cM);

            ItemStack l = new ItemStack(Material.LEATHER_LEGGINGS);
            l.setItemMeta(cM);

            ItemStack b = new ItemStack(Material.LEATHER_BOOTS);
            b.setItemMeta(cM);

            player.getInventory().setChestplate(c);
            player.getInventory().setLeggings(l);
            player.getInventory().setBoots(b);

            player.getInventory().setItem(0, new ItemStack(getItem("§e§lCouteau", Material.IRON_SWORD,1 , (byte) 0, null, 0)));
            player.getInventory().setItem(1, new ItemStack(getItem("§e§lArc", Material.BOW,1 , (byte) 0, Enchantment.DURABILITY, 10069)));
            player.getInventory().setItem(2, new ItemStack(getItem("§e§lPomme", Material.GOLDEN_APPLE,8 , (byte) 0, null, 0)));
            player.getInventory().setItem(3, new ItemStack(getItem("§2§lBlocks", Material.STAINED_CLAY,64 , DyeColor.BLUE.getDyeData(), null, 0)));
            player.getInventory().setItem(4, new ItemStack(getItem("§2§lBlocks", Material.STAINED_CLAY,64 , DyeColor.BLUE.getDyeData(), null, 0)));
            player.getInventory().setItem(8, new ItemStack(getItem("§e§lFlèche", Material.ARROW,1 , (byte) 0, null, 0)));

        }

    }

    private ItemStack getItem(String name, Material material, int amount, byte data, Enchantment enchant, int enchantLevel) {

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(name);
        if(enchant != null) meta.addEnchant(enchant, enchantLevel, true);
        itemStack.setItemMeta(meta);
        return itemStack;

    }

}
