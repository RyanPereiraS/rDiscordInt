package devumgamer.ddiscordint.discord.events;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import static devumgamer.ddiscordint.discord.DiscordInt.*;

public class ready extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        TextChannel textChannel = jda.getGuildById(GUILD).getTextChannelById(CHANNEL);
        if(textChannel == null){
            Bukkit.getConsoleSender().sendMessage("Nulo");
        } else {
            jda.getGuildById(GUILD).getTextChannelById(CHANNEL).sendMessage(":white_check_mark: Servidor Iniciando!").queue();
        }
    }
}
