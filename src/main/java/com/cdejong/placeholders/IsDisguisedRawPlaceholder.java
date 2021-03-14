package com.cdejong.placeholders;

import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import com.cdejong.LibsDisguisesMVdWHook;
import com.cdejong.config.Config;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;

public class IsDisguisedRawPlaceholder implements PlaceholderReplacer {
    private final LibsDisguisesMVdWHook plugin;
    private Config config;

    public IsDisguisedRawPlaceholder(LibsDisguisesMVdWHook plugin) {
        this.plugin = plugin;
        this.config = plugin.getRunningConfig();
    }

    @Override
    public String onPlaceholderReplace(PlaceholderReplaceEvent event) {
        Player player = event.getPlayer();

        if (!plugin.isLibsDisguisesEnabled() || !DisguiseAPI.isDisguised(player)) {
            return config.getFalseAsText();
        } else {
            return config.getTrueAsText();
        }
    }
}
