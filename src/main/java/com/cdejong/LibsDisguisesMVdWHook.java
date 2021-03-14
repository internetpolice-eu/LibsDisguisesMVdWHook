package com.cdejong;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import com.cdejong.placeholders.DisguisedAsPlaceHolder;
import com.cdejong.placeholders.IsDisguisedPlaceholder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LibsDisguisesMVdWHook extends JavaPlugin {

    private boolean enabledLibsDisguises = true;

    @Override
    public void onEnable() {
        if (!Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")) {
            getLogger().warning("MVdWPlaceholderAPI is not enabled, disabling this plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if (!Bukkit.getPluginManager().isPluginEnabled("LibsDisguises")) {
            getLogger().warning("LibsDisguises is not enabled, placeholders will be empty or false");
            this.enabledLibsDisguises = false;
        }

        PlaceholderAPI.registerPlaceholder(this, "libsdisguises_disguised_as", new DisguisedAsPlaceHolder(this));
        PlaceholderAPI.registerPlaceholder(this, "libsdisguises_is_disguised", new IsDisguisedPlaceholder(this));
    }

    public boolean isLibsDisguisesEnabled() {
        return enabledLibsDisguises;
    }
}
