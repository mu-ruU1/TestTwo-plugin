package com.yuu.testtwo.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickName implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "ゲーム内から実行してください");
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + "引数が足りません");
            return true;
        }

        if (args[0].length() > 16) {
            sender.sendMessage(ChatColor.RED + "文字数が多すぎます");
            return true;
        }

        final String name = ChatColor.translateAlternateColorCodes('&', args[0]);
        final Player p = (Player) sender;

        // 引数が RESETならオリジナルの名前に変更
        final String originame = sender.getName();
        final String check = "RESET";

        if (name.equals(check)) {
            p.setDisplayName(originame);
            p.setPlayerListName(originame);
            sender.sendMessage(ChatColor.GREEN + "ニックネームをオリジナルに変更しました");
            return true;
        }

        p.setDisplayName(name);
        p.setPlayerListName(name);
        return true;
    }
}
