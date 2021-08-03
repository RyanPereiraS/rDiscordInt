package devumgamer.ddiscordint.events;

import br.com.devpaulo.legendchat.api.Legendchat;
import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import br.com.devpaulo.legendchat.channels.types.Channel;
import devumgamer.ddiscordint.discord.DiscordInt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static devumgamer.ddiscordint.discord.DiscordInt.jda;

public class Message implements Listener {
    @EventHandler
    public void onGlobalMessageEvent(ChatMessageEvent event) {
        Channel chat = event.getChannel();
        Channel chatGlobal = Legendchat.getChannelManager().getChannelByName("global");

        if(chat == chatGlobal){
            jda.getGuildById(DiscordInt.GUILD).getTextChannelById(DiscordInt.CHANNEL).sendMessage(event.getSender().getDisplayName() + " >> " + event.getMessage()).queue();
        }
    }
}
