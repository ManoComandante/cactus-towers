package com.github.manocomandante.torres.commands;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

import com.github.manocomandante.torres.*;
import com.github.manocomandante.torres.api.*;

public class GiveTorre implements CommandExecutor, Listener
{
    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final CommandSender p = sender;
        if (!cmd.getName().equalsIgnoreCase("givetorre")) {
            return false;
        }
        if (args.length != 3) {
            p.sendMessage("§cUse: /givetorre (tipo) (player) (quantidade)");
            return true;
        }
        if (!p.hasPermission("torres.admin")) {
            p.sendMessage("§cVocê não tem permissão para fazer isso.");
            return true;
        }
        if (Bukkit.getPlayer(args[1]) == null) {
            p.sendMessage("");
            p.sendMessage("§c§lOPS!");
            p.sendMessage("§cPlayer inválido");
            p.sendMessage("");
            return true;
        }
        if (!APIGeral.isint(args[2])) {
            p.sendMessage("");
            p.sendMessage("§c§lOPS!");
            p.sendMessage("§cValor inválido");
            p.sendMessage("");
            return true;
        }
        if (!TorresPlugin.m.getConfig().getConfigurationSection("config").getKeys(false).contains(args[0])) {
            p.sendMessage("");
            p.sendMessage("§c§lOPS!");
            p.sendMessage("§cTipo inválido");
            p.sendMessage("");
            return true;
        }
        final Player target = Bukkit.getPlayer(args[1]);
        final int q = Integer.valueOf(args[2]);
        final int ItemId = TorresPlugin.m.getConfig().getInt("config." + args[0] + ".id");
        final int ItemData = TorresPlugin.m.getConfig().getInt("config." + args[0] + ".data");
        final String Skull = TorresPlugin.m.getConfig().getString("config." + args[0] + ".head-texture");
        final String Name = TorresPlugin.m.getConfig().getString("config." + args[0] + ".display-name").replace("&", "§");
        final List<String> listlore = (List<String>)TorresPlugin.m.getConfig().getStringList("config." + args[0] + ".lore");
        final List<String> lores = new ArrayList<String>();
        for (final String string : listlore) {
            lores.add(string.replace("&", "§"));
        }
        ItemStack item;
        if (ItemId == 144) {
            item = HeadsAPI.getSkull(Skull);
            item.setAmount(q);
        }
        else {
            item = new ItemStack(ItemId, q, (short)ItemData);
        }
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(Name);
        itemmeta.setLore((List)lores);
        item.setItemMeta(itemmeta);
        target.getInventory().addItem(new ItemStack[] { item });
        return true;
    }
}
