package me.ewahv1.plugin.Commands;

import me.ewahv1.plugin.Commands.Storm.*;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler implements CommandExecutor {

    private final JavaPlugin plugin;
    private final StormListener stormListener;

    public CommandHandler(JavaPlugin plugin, StormListener stormListener) {
        this.plugin = plugin;
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Uso correcto: /storm <reset|toggle|status|reverse|set>");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "reset":
                return new ResetStormCommand(plugin, stormListener).onCommand(sender, command, label, args);
            case "toggle":
                return new ToggleStormCommand(plugin).onCommand(sender, command, label, args);
            case "status":
                return new StormStatusCommand(plugin).onCommand(sender, command, label, args);
            case "reverse":
                return new ReverseStormCommand(plugin, stormListener).onCommand(sender, command, label, args);
            case "set":
                if (args.length >= 3) {
                    if (args[1].equalsIgnoreCase("BaseTime")) {
                        return new SetBaseStormTimeCommand(plugin, stormListener).onCommand(sender, command, label,
                                args);
                    } else if (args[1].equalsIgnoreCase("CurrentTime")) {
                        return new SetStormTimeCommand(plugin, stormListener).onCommand(sender, command, label, args);
                    } else {
                        sender.sendMessage("Uso correcto: /storm set <BaseTime|CurrentTime> <tiempo>");
                        return false;
                    }
                } else {
                    sender.sendMessage("Uso correcto: /storm set <BaseTime|CurrentTime> <tiempo>");
                    return false;
                }
            default:
                sender.sendMessage("Comando no reconocido.");
                return false;
        }
    }
}
