package devumgamer.ddiscordint.discord.events;


import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import static devumgamer.ddiscordint.discord.DiscordInt.*;

public class message extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;

        TextChannel DiscordChannel = event.getChannel();
        TextChannel Channel = jda.getGuildById(GUILD).getTextChannelById(CHANNEL);
        if (DiscordChannel == Channel) {
            Bukkit.broadcastMessage("§7[§bD§7] §b" + event.getAuthor().getName() + " >> " + event.getMessage().getContentDisplay());
        }
    }
}
