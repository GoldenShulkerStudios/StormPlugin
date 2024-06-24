package me.ewahv1.plugin.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("reset");
            completions.add("toggle");
            completions.add("status");
            completions.add("set");
            completions.add("reverse"); // Agregar reverse
        } else if (args.length == 2 && args[0].equalsIgnoreCase("set")) {
            completions.add("BaseTime");
            completions.add("CurrentTime");
        }

        List<String> filteredCompletions = new ArrayList<>();
        String currentArg = args[args.length - 1].toLowerCase();
        for (String completion : completions) {
            if (completion.toLowerCase().startsWith(currentArg)) {
                filteredCompletions.add(completion);
            }
        }

        return filteredCompletions;
    }
}
