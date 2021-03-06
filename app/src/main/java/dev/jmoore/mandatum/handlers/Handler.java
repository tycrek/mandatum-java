package dev.jmoore.mandatum.handlers;

import dev.jmoore.mandatum.Bot;
import net.dv8tion.jda.api.events.Event;

public abstract class Handler<T extends Event> {
    public static Handler<Event> DEFAULT = new DefaultHandler(null);
    private final Bot bot;

    public Handler(Bot bot) {
        this.bot = bot;
    }

    /**
     * Code within here will be processed when the Handler's {@link Event} is received
     *
     * @param event The {@link Event}
     */
    protected abstract void onHandle(T event);

    /**
     * Called by {@link dev.jmoore.mandatum.EventListener}
     *
     * @param event   The {@link Event}
     * @param <event> The {@link Event} class?
     */
    @SuppressWarnings("unchecked")
    public <event> void handle(event event) {
        this.onHandle((T) event);
    }

    protected Bot getBot() {
        return this.bot;
    }

    /**
     * Default used when there is no associated {@link Handler} for an {@link Event}
     */
    private static class DefaultHandler extends Handler<Event> {
        public DefaultHandler(Bot bot) {
            super(bot);
        }

        @Override
        protected void onHandle(Event event) {
        }
    }
}
