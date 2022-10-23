package dev.ag6.gambabot;

import dev.ag6.gambabot.core.command.CommandListener;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GambaBot {
    public static final Logger LOGGER = LoggerFactory.getLogger("GambaBot");

    public static void main(String[] args) {
        final JDABuilder builder = createBuilder();
        builder.build();
    }

    public static JDABuilder createBuilder() {
        var builder = JDABuilder.createDefault(Configuration.INSTANCE.getToken());
        builder.addEventListeners(CommandListener.INSTANCE);
        return builder;
    }
}
