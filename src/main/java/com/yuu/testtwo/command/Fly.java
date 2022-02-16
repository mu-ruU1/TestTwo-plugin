package com.yuu.testtwo.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "コマンドの実行権限がありません");
            return true;
        }

        final Player p = (Player) sender;

        if (p.getAllowFlight()) {
            p.setAllowFlight(false);
            sender.sendMessage(ChatColor.YELLOW + "コマンドを無効にしました");
            return true;
        }

        p.setAllowFlight(true);
        sender.sendMessage(ChatColor.GREEN + "コマンドを実行しました");


        return true;
    }
}
