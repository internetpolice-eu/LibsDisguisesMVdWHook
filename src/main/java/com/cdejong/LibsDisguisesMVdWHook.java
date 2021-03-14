package com.cdejong;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import com.cdejong.config.Config;
import com.cdejong.config.YamlConfig;
import com.cdejong.placeholders.DisguisedAsPlaceholder;
import com.cdejong.placeholders.IsDisguisedPlaceholder;
import com.cdejong.placeholders.IsDisguisedRawPlaceholder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LibsDisguisesMVdWHook extends JavaPlugin {

    private boolean isLibsDisguisesEnabled = true;
    private Config config;

    @Override
    public void onEnable() {

        this.config = new YamlConfig(this);

        if (!Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")) {
            getLogger().warning("MVdWPlaceholderAPI is not enabled, disabling this plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if (!Bukkit.getPluginManager().isPluginEnabled("LibsDisguises")) {
            getLogger().warning("LibsDisguises is not enabled, placeholders will be empty or false");
            this.isLibsDisguisesEnabled = false;
        }

        PlaceholderAPI.registerPlaceholder(this, "libsdisguises_disguised_as", new DisguisedAsPlaceholder(this));
        PlaceholderAPI.registerPlaceholder(this, "libsdisguises_is_disguised", new IsDisguisedPlaceholder(this));
        PlaceholderAPI.registerPlaceholder(this, "libsdisguises_is_disguised_raw", new IsDisguisedRawPlaceholder(this));
    }

    public boolean isLibsDisguisesEnabled() {
        return isLibsDisguisesEnabled;
    }

    public Config getRunningConfig() {
        return config;
    }
}
