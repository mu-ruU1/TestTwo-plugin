package com.yuu.testtwo;

import com.yuu.testtwo.command.Fly;
import com.yuu.testtwo.command.NickName;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestTwo extends JavaPlugin {

    private static TestTwo plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getCommand("fly").setExecutor(new Fly());
        getCommand("nickname").setExecutor(new NickName());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
