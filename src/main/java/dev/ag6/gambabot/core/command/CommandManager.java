package dev.ag6.gambabot.core.command;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public static final CommandManager INSTANCE = new CommandManager();

    public final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        final Reflections REFLECTIONS = new Reflections("dev.ag6.gambabot");
        REFLECTIONS.getTypesAnnotatedWith(AutoRegisterCommand.class).forEach(clazz -> {
            if (Command.class.isAssignableFrom(clazz)) {
                try {
                    var command = (Command) clazz.getDeclaredConstructor().newInstance();
                    commands.put(command.getName(), command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addCommand(Command... command) {
        for (Command c : command) {
            commands.put(c.getName(), c);
        }
    }
}
