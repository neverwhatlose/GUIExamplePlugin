package ru.nwtls;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.nwtls.gui.GUIListener;
import ru.nwtls.gui.GUIManager;

public class GUIExampleMain extends JavaPlugin {
    private final @NotNull GUIManager guiManager = new GUIManager();
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public static @NotNull GUIExampleMain getInstance() {
        return GUIExampleMain.getPlugin(GUIExampleMain.class);
    }

    public @NotNull GUIManager getGUIManager() {
        return this.guiManager;
    }
}
