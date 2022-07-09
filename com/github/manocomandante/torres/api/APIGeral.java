package com.github.manocomandante.torres.api;

import java.util.*;

import com.github.manocomandante.torres.*;

@SuppressWarnings("unused")
public class APIGeral
{
    public static String existTorre(final String name) {
        for (final String section : TorresPlugin.m.getConfig().getConfigurationSection("config").getKeys(false)) {
            if (TorresPlugin.m.getConfig().getString("config." + section + ".display-name").equalsIgnoreCase(name.replace("§", "&"))) {
                return section;
            }
        }
        return null;
    }
    
    public static boolean isValid(final String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isint(final String str) {
        return isValid(str) && (!str.equalsIgnoreCase("NaN") && !str.equalsIgnoreCase("NaN")) && Double.valueOf(str) >= 0.0;
    }
}
