package devumgamer.ddiscordint.events;

import devumgamer.ddiscordint.discord.DiscordInt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static devumgamer.ddiscordint.discord.DiscordInt.jda;

public class PlayerJoinQuitEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        e.setJoinMessage("§6[+] §b"+ e.getPlayer().getName() + " §fEntrou no servidor!");
        jda.getGuildById(DiscordInt.GUILD).getTextChannelById(DiscordInt.CHANNEL).sendMessage(":heavy_plus_sign: "+e.getPlayer().getDisplayName()+" Entrou no servidor!").queue();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        e.setQuitMessage("§c[+] §b "+ e.getPlayer().getName() +" §fSaiu no servidor!");
        jda.getGuildById(DiscordInt.GUILD).getTextChannelById(DiscordInt.CHANNEL).sendMessage(":heavy_minus_sign: "+e.getPlayer().getDisplayName()+" Saiu no servidor!").queue();

    }
}
