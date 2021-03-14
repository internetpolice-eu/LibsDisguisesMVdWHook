package com.cdejong.config;

import com.cdejong.LibsDisguisesMVdWHook;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class YamlConfig implements Config {

    private LibsDisguisesMVdWHook plugin;
    private File file;
    private FileConfiguration fileConfiguration;

    public YamlConfig(LibsDisguisesMVdWHook plugin) {
        this.plugin = plugin;
        this.file = new File("config.yml");

        loadConfig();
    }

    @Override
    public String getTrueAsText() {
        return fileConfiguration.getString("true-as-text", "true");
    }

    @Override
    public String getFalseAsText() {
        return fileConfiguration.getString("false-as-text", "false");
    }

    @Override
    public String getNotDisguisedValue() {
        return fileConfiguration.getString("not-disguised-value", "");
    }

    @Override
    public void loadConfig() {
        if (!file.exists()) {
            plugin.saveResource("config.yml", false);
        }

        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }
}
