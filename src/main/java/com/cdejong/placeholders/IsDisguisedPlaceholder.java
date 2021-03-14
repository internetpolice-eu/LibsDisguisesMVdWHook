package com.cdejong.placeholders;

import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import com.cdejong.LibsDisguisesMVdWHook;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;

public class IsDisguisedPlaceholder implements PlaceholderReplacer {

    private final LibsDisguisesMVdWHook plugin;

    public IsDisguisedPlaceholder(LibsDisguisesMVdWHook plugin) {
        this.plugin = plugin;
    }

    @Override
    public String onPlaceholderReplace(PlaceholderReplaceEvent event) {
        Player player = event.getPlayer();

        if (!plugin.isLibsDisguisesEnabled() || !DisguiseAPI.isDisguised(player)) {
            return "false";
        } else {
            return "true";
        }
    }
}
