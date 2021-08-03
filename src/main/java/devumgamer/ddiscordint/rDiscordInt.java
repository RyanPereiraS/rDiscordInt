package devumgamer.ddiscordint;

import devumgamer.ddiscordint.commands.Discord;
import devumgamer.ddiscordint.discord.DiscordInt;
import devumgamer.ddiscordint.events.Message;
import devumgamer.ddiscordint.events.PlayerJoinQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import static devumgamer.ddiscordint.discord.DiscordInt.getJDA;
import static devumgamer.ddiscordint.discord.DiscordInt.jda;

public final class rDiscordInt extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        if(rDiscordInt.getDiscordInt().getConfig().getBoolean("Discord.Enable")){
            DiscordInt.DiscordIntLogin();
        }
        RegisterEvents();
        RegisterCommands();
        Bukkit.getConsoleSender().sendMessage("Plugin Inciado!");

    }

    @Override
    public void onDisable() {
        jda.getGuildById(DiscordInt.GUILD).getTextChannelById(DiscordInt.CHANNEL).sendMessage(":warning: Servidor desligando!").queue();
        jda.shutdown();
    }
    public void RegisterCommands(){
        Bukkit.getConsoleSender().sendMessage("Registrando Comandos!");
        getCommand("discord").setExecutor(new Discord());
        Bukkit.getConsoleSender().sendMessage("Comandos Registrados!");
    }
    public void RegisterEvents(){
        Bukkit.getConsoleSender().sendMessage("Registrando Eventos!");
        Bukkit.getPluginManager().registerEvents(new Message(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinQuitEvent(), this);
        Bukkit.getConsoleSender().sendMessage("Eventos Registrados!");
    }
    public static void DisablePlugin(){
        Bukkit.getPluginManager().disablePlugin(getDiscordInt());
    }
    public static @Nullable Plugin getDiscordInt() {
        return Bukkit.getServer().getPluginManager().getPlugin("rDiscordInt");
    }
}
