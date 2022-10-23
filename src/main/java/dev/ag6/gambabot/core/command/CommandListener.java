package dev.ag6.gambabot.core.command;

import dev.ag6.gambabot.Configuration;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class CommandListener extends ListenerAdapter {
    public static final CommandListener INSTANCE = new CommandListener();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        CommandManager.INSTANCE.commands.get(event.getName()).handle(event);
    }

    //Bot owner commands are to be sent as messages and not as slash commands
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().getIdLong() == Configuration.INSTANCE.getBotOwnerIdLong()) {

        }
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        var updates = event.getGuild().updateCommands();

        CommandManager.INSTANCE.commands.forEach((name, command) -> {
            if(!command.isOwnerCommand()) {
                var commandData = Commands.slash(command.getName(), command.getDescription());

                if(!command.getOptionData().isEmpty())
                    commandData.addOptions(command.getOptionData());
                if(!command.getSubcommandData().isEmpty())
                    commandData.addSubcommands(command.getSubcommandData());

                updates.addCommands(commandData);
            }
        });
        updates.queue();
    }
}
