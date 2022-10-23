package dev.ag6.gambabot.core.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface RegularCommand {
    default void handle(MessageReceivedEvent event) {

    }

    String getName();

    String getDescription();

    default boolean isOwnerCommand() {
        return false;
    }
}
