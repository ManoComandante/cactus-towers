package com.github.manocomandante.torres;

import org.bukkit.plugin.java.*;

import com.github.manocomandante.torres.commands.*;
import com.github.manocomandante.torres.utils.*;

import java.util.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.command.*;

public class TorresPlugin extends JavaPlugin
{
    public static ArrayList<String> hide;
    public static TorresPlugin m;
    public static Economy economy;
    
    static {
        TorresPlugin.hide = new ArrayList<String>();
    }
    
    public void onEnable() {
        (TorresPlugin.m = this).saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents((Listener)new PlaceEvent(), (Plugin)this);
        this.getCommand("givetorre").setExecutor((CommandExecutor)new GiveTorre());
        }
    }

