package dev.ag6.gambabot.core.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.util.List;

public interface Command {
    void handle(SlashCommandInteractionEvent event);

    String getName();

    String getDescription();

    default boolean isOwnerCommand() {
        return false;
    }

    default List<OptionData> getOptionData() {
        return List.of();
    }

    default List<SubcommandData> getSubcommandData() {
        return List.of();
    }
}
