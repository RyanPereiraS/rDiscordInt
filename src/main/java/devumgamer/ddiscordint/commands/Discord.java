package devumgamer.ddiscordint.commands;

import devumgamer.ddiscordint.rDiscordInt;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Discord implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("discord")) {
            sender.sendMessage(rDiscordInt.getDiscordInt().getConfig().getString("Message.Links.DiscordMessage"));
        }
        return false;
    }
}
