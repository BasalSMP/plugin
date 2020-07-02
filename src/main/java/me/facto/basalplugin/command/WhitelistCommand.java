package me.facto.basalplugin.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

@CommandAlias("whitelist|wl")
public class WhitelistCommand extends BaseCommand implements Listener {

    @Default
    public void onDefault(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Whitelist has been disabled for the moment in-game. It is curated with discord at the moment.");
    }

}
