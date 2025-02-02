package ru.nwtls;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.nwtls.gui.GuiListener;
import ru.nwtls.gui.GuiManager;
import ru.nwtls.listener.PlayerJoinListener;

public class GUIExampleMain extends JavaPlugin {
    private final @NotNull GuiManager guiManager = new GuiManager();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new GuiListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public static @NotNull GUIExampleMain getInstance() {
        return GUIExampleMain.getPlugin(GUIExampleMain.class);
    }

    public @NotNull GuiManager getGUIManager() {
        return this.guiManager;
    }
}
