package devumgamer.ddiscordint.discord.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;


    public class teste extends ListenerAdapter {
        public void onGuildMessageReceived(GuildMessageReceivedEvent event){
            if(event.getAuthor().isBot()) return;
            String[] args = event.getMessage().getContentRaw().split("\\s+");
            if(args[0].equalsIgnoreCase("/blowmymind")) {
                event.getChannel().sendMessage("Olá Mundo").queue();
                TextChannel textChannel = event.getMessage().getTextChannel();
                if(textChannel == null){
                    Bukkit.getConsoleSender().sendMessage("Nulo");
                    return;
                } else {
                    Bukkit.getConsoleSender().sendMessage("Não é Nulo!");
                    textChannel.sendMessage("TESTEEEE" + event.getMessage().getContentRaw()).queue();
                    return;
                }
            }

        }
    }

