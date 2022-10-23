package dev.ag6.gambabot.core.command;

import dev.ag6.gambabot.GambaBot;
import dev.ag6.gambabot.commands.botowner.RestartCommand;
import dev.ag6.gambabot.commands.botowner.ShutdownCommand;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public static final CommandManager INSTANCE = new CommandManager();

    public final Map<String, SlashCommand> slashCommands = new HashMap<>();
    public final Map<String, RegularCommand> regularCommands = new HashMap<>();

    public CommandManager() {
        final Reflections REFLECTIONS = new Reflections("dev.ag6.gambabot");
        REFLECTIONS.getTypesAnnotatedWith(AutoRegisterCommand.class).forEach(clazz -> {
            if (SlashCommand.class.isAssignableFrom(clazz)) {
                try {
                    var command = (SlashCommand) clazz.getDeclaredConstructor().newInstance();
                    slashCommands.put(command.getName(), command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        addRegularCommand(new RestartCommand(), new ShutdownCommand());

        GambaBot.LOGGER.info("Registered {} slash commands and {} regular commands", slashCommands.size(), regularCommands.size());
    }

    public void addRegularCommand(RegularCommand... command) {
        for (RegularCommand c : command) {
            regularCommands.put(c.getName(), c);
        }
    }
}
