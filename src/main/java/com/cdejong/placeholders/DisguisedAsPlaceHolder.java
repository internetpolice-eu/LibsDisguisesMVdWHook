package com.cdejong.placeholders;

import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import com.cdejong.LibsDisguisesMVdWHook;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;

public class DisguisedAsPlaceHolder implements PlaceholderReplacer {

    private final LibsDisguisesMVdWHook plugin;

    public DisguisedAsPlaceHolder(LibsDisguisesMVdWHook plugin) {
        this.plugin = plugin;
    }

    @Override
    public String onPlaceholderReplace(PlaceholderReplaceEvent event) {

        Player player = event.getPlayer();

        if (!plugin.isLibsDisguisesEnabled() || !DisguiseAPI.isDisguised(player)) {
            return "";
        } else {
            return DisguiseAPI.getDisguise(player).getDisguiseName();
        }
    }
}
