package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import dev.jmoore.mandatum.utils.Logger;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MessageReceivedHandler extends Handler<GuildMessageReceivedEvent> {
    public MessageReceivedHandler(Bot bot) {
        super(bot);
    }

    @Override
    protected void onHandle(GuildMessageReceivedEvent event) {
        Logger.debug("Message received from [%s] in [%s]: %s%n", event.getAuthor().getName(), event.getGuild().getName(), event.getMessage());
        if (event.getMessage().getContentRaw().startsWith("%ping")) this.getBot().getCommandManager().getCommand("ping").execute(event.getMessage());
    }
}
