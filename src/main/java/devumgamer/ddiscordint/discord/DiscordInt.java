package devumgamer.ddiscordint.discord;

import devumgamer.ddiscordint.discord.commands.teste;
import devumgamer.ddiscordint.discord.events.message;
import devumgamer.ddiscordint.discord.events.ready;
import devumgamer.ddiscordint.rDiscordInt;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;

import javax.security.auth.login.LoginException;

public class DiscordInt {
    public static JDA jda;
    public static String CHANNEL = rDiscordInt.getDiscordInt().getConfig().getString("Discord.GLOBAL_CHANNELID");
    public static String GUILD  = rDiscordInt.getDiscordInt().getConfig().getString("Discord.GUILDID");
    public static void DiscordIntLogin(){
        try {
            jda = JDABuilder.createDefault(rDiscordInt.getDiscordInt().getConfig().getString("Discord.TOKEN"))
                    .addEventListeners(new ready())
                    .addEventListeners(new teste())
                    .addEventListeners(new message())
                    .setAutoReconnect(false)
                    .build();
            jda.getPresence().setActivity(Activity.streaming(rDiscordInt.getDiscordInt().getConfig().getString("Discord.GAME"), "https://www.twitch.tv/RyanPereiraS"));
        } catch (LoginException var2) {
            var2.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("§4A Conexão com a JDA falhou!");
        }

        Bukkit.getConsoleSender().sendMessage("$fJDA INICIADA");
    }

    public static JDA getJDA(){
        return jda;
    }
}
