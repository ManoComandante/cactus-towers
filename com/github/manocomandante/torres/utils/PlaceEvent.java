package com.github.manocomandante.torres.utils;

import org.bukkit.event.player.*;

import com.github.manocomandante.torres.*;
import com.github.manocomandante.torres.api.*;
import com.intellectualcrafters.plot.object.*;
import com.intellectualcrafters.plot.object.Location;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;

public class PlaceEvent implements Listener
{
    @SuppressWarnings("deprecation")
	@EventHandler
    public static void BlockPlace(final PlayerInteractEvent bate) {
        final Player p = bate.getPlayer();
        if (bate.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName()) {
            final String name = p.getItemInHand().getItemMeta().getDisplayName();
            final String section = APIGeral.existTorre(name);
            if (section != null) {
                final Integer tamanho = TorresPlugin.m.getConfig().getInt("config." + section + ".andares") - 2;
                bate.setCancelled(true);
                final org.bukkit.Location bloco2 = bate.getClickedBlock().getLocation().add(0.0, 0.0, 0.0);
                final org.bukkit.Location bloco3 = bate.getClickedBlock().getLocation().add(0.0, 0.0, 0.0);
                final int x = bloco2.getBlockX();
                final int y = bloco2.getBlockY();
                final int z = bloco2.getBlockZ();
                final Location locp1 = new Location(p.getWorld().getName(), x - 1, y + 31, z - 1);
                final Location locp2 = new Location(p.getWorld().getName(), x + 1, y, z + 1);
                if (Plot.getPlot(locp1) == null || Plot.getPlot(locp2) == null) {
                    p.sendMessage("§c§lOPS! §cVocê deve colocar a torre em uma plot.");
                    return;
                }
                if (bloco2.add(-1.0, 4.0 * tamanho, -1.0).getBlock().getType() == Material.BEDROCK || bloco2.add(1.0, 0.0, 1.0).getBlock().getType() == Material.BEDROCK) {
                    p.sendMessage("§c§lOPS! §cVocê deve colocar a torre em uma plot.");
                    return;
                }
                if ((bloco2.add(-1.0, 4.0 * tamanho, -1.0).getBlock().getTypeId() == 44 && bloco2.add(-1.0, 4.0 * tamanho, -1.0).getBlock().getData() == 1) || (bloco2.add(1.0, 0.0, 1.0).getBlock().getTypeId() == 44 && bloco2.add(1.0, 0.0, 1.0).getBlock().getData() == 1)) {
                    p.sendMessage("§c§lOPS! §cVocê deve colocar a torre em uma plot.");
                    return;
                }
                if (bloco2.add(-1.0, 4.0 * tamanho, -1.0).getY() >= 256.0) {
                    p.sendMessage("§c§lOPS! §cVocê deve colocar a torre abaixo da camada 256.");
                    return;
                }
                final Plot plot = Plot.getPlot(locp1);
                final Plot plot2 = Plot.getPlot(locp1);
                if ((plot.isOwner(p.getUniqueId()) && plot2.isOwner(p.getUniqueId())) || (plot.isAdded(p.getUniqueId()) && plot2.isAdded(p.getUniqueId()))) {
                    p.playEffect(bloco3.add(0.4, 1.0, 0.4), Effect.HAPPY_VILLAGER, 100);
                    bloco3.add(0.0, 0.0, -1.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(0.0, 0.0, 2.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(-1.0, 0.0, -1.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(2.0, 0.0, 0.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(-1.0, 3.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(0.0, 1.0, -1.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(0.0, 0.0, 2.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(-1.0, 0.0, -1.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(0.0, 1.5, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(2.5, 0.0, 0.0).getBlock().setType(Material.CACTUS);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.SAND);
                    bloco3.add(0.0, -1.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(-1.0, 3.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                    bloco3.add(1.0, -3.0, 0.0);
                    for (int i = 0; i < tamanho; ++i) {
                        bloco3.add(-1.0, 3.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                        bloco3.add(1.0, 1.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                        bloco3.add(-2.0, -2.0, 0.0).getBlock().setType(Material.COBBLESTONE);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                        bloco3.add(1.0, -2.0, -1.0).getBlock().setType(Material.COBBLESTONE);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                        bloco3.add(0.0, -2.0, 2.0).getBlock().setType(Material.COBBLESTONE);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.SAND);
                        bloco3.add(0.0, 1.0, 0.0).getBlock().setType(Material.CACTUS);
                        bloco3.add(0.0, 1.0, -1.0).getBlock().setType(Material.COBBLESTONE);
                        bloco3.add(1.0, -3.0, 0.0);
                    }
                    final ItemStack hand2 = p.getInventory().getItemInHand();
                    hand2.setAmount(hand2.getAmount() - 1);
                    p.getInventory().setItemInHand(hand2);
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0f, 1.0f);
                    p.updateInventory();
                }
            }
        }
    }
    
    @EventHandler
    public void onCactus(final BlockGrowEvent e) {
        if (e.getNewState().getType() == Material.CACTUS) {
            final Block block1 = e.getNewState().getBlock().getLocation().add(1.0, 0.0, 0.0).getBlock();
            final Block block2 = e.getNewState().getBlock().getLocation().add(-1.0, 0.0, 0.0).getBlock();
            final Block block3 = e.getNewState().getBlock().getLocation().add(0.0, 0.0, 1.0).getBlock();
            final Block block4 = e.getNewState().getBlock().getLocation().add(0.0, 0.0, -1.0).getBlock();
            if ((block1 != null && block1.getType() != Material.AIR) || (block2 != null && block2.getType() != Material.AIR) || (block3 != null && block3.getType() != Material.AIR) || (block4 != null && block4.getType() != Material.AIR)) {
                e.setCancelled(true);
                e.getNewState().getBlock().getLocation().getWorld().dropItemNaturally(e.getNewState().getBlock().getLocation(), new ItemStack(Material.CACTUS));
            }
        }
    }
}
