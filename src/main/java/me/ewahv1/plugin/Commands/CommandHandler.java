package me.ewahv1.plugin.Commands;

import me.ewahv1.plugin.Commands.Storm.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private final ResetStormCommand resetStormCommand;
    private final SetStormTimeCommand setStormTimeCommand;
    private final ToggleStormCommand toggleStormCommand;
    private final StormStatusCommand stormStatusCommand;
    private final SetBaseStormTimeCommand setBaseStormTimeCommand;
    private final ReverseStormCommand reverseStormCommand; // Agregar ReverseStormCommand

    public CommandHandler(
            ResetStormCommand resetStormCommand,
            SetStormTimeCommand setStormTimeCommand,
            ToggleStormCommand toggleStormCommand,
            StormStatusCommand stormStatusCommand,
            SetBaseStormTimeCommand setBaseStormTimeCommand,
            ReverseStormCommand reverseStormCommand // Agregar ReverseStormCommand
    ) {
        this.resetStormCommand = resetStormCommand;
        this.setStormTimeCommand = setStormTimeCommand;
        this.toggleStormCommand = toggleStormCommand;
        this.stormStatusCommand = stormStatusCommand;
        this.setBaseStormTimeCommand = setBaseStormTimeCommand;
        this.reverseStormCommand = reverseStormCommand; // Agregar ReverseStormCommand
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Uso: /storm <comando>");
            return false;
        }
        String subCommand = args[0].toLowerCase();
        switch (subCommand) {
            case "reset":
                return resetStormCommand.onCommand(sender, command, label, args);
            case "set":
                if (args.length >= 2) {
                    String subSubCommand = args[1].toLowerCase();
                    if ("basetime".equalsIgnoreCase(subSubCommand)) {
                        return setBaseStormTimeCommand.onCommand(sender, command, label, args);
                    } else if ("currenttime".equalsIgnoreCase(subSubCommand)) {
                        return setStormTimeCommand.onCommand(sender, command, label, args);
                    } else {
                        sender.sendMessage("Uso: /storm set <basetime|currenttime>");
                        return false;
                    }
                } else {
                    sender.sendMessage("Uso: /storm set <basetime|currenttime>");
                    return false;
                }
            case "toggle":
                return toggleStormCommand.onCommand(sender, command, label, args);
            case "status":
                return stormStatusCommand.onCommand(sender, command, label, args);
            case "reverse": // Agregar el caso para reverse
                return reverseStormCommand.onCommand(sender, command, label, args);
            default:
                sender.sendMessage("Comando desconocido. Usa /storm <reset|set|toggle|status|reverse>");
                return false;
        }
    }
}
