package dev.ag6.gambabot.commands.botowner;

import dev.ag6.gambabot.core.command.RegularCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ShutdownCommand implements RegularCommand {
    @Override
    public void handle(MessageReceivedEvent event) {
        event.getMessage().reply("Shutting down...").mentionRepliedUser(false).queue();
        event.getJDA().shutdown();
    }

    @Override
    public String getName() {
        return "shutdown";
    }

    @Override
    public String getDescription() {
        return "Shutdowns the bot";
    }

    @Override
    public boolean isOwnerCommand() {
        return true;
    }
}
