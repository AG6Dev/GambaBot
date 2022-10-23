package dev.ag6.gambabot.commands.botowner;

import dev.ag6.gambabot.GambaBot;
import dev.ag6.gambabot.core.command.RegularCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class RestartCommand implements RegularCommand {
    @Override
    public void handle(MessageReceivedEvent event) {
        event.getMessage().reply("Restarting...").mentionRepliedUser(false).queue();

        event.getJDA().shutdown();
        try {
            final String javaLoc = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            final File currentJar = new File(GambaBot.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            if (!currentJar.getName().endsWith(".jar"))
                return;

            final ArrayList<String> command = new ArrayList<>();
            command.add(javaLoc);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch(URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "restart";
    }

    @Override
    public String getDescription() {
        return "Restarts the bot";
    }

    @Override
    public boolean isOwnerCommand() {
        return true;
    }
}
