package dev.ag6.gambabot.commands;

import dev.ag6.gambabot.core.command.AutoRegisterCommand;
import dev.ag6.gambabot.core.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

@AutoRegisterCommand
public class PingCommand implements Command {
    @Override
    public void handle(SlashCommandInteractionEvent event) {
        event.deferReply(true).setContent("Pong! %sms".formatted(event.getJDA().getGatewayPing())).queue();
    }

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Gets the ping of the bot";
    }
}
