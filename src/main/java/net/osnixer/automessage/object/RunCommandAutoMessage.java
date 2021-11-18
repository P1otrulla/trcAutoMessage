package net.osnixer.automessage.object;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.osnixer.automessage.object.interfaces.AutoMessage;
import net.osnixer.automessage.object.interfaces.Hoverable;
import net.osnixer.automessage.util.ChatUtil;
import org.bukkit.entity.Player;

public class RunCommandAutoMessage implements AutoMessage, Hoverable {

    private final String message;
    private final String hover;
    private final String command;

    public RunCommandAutoMessage(String message, String hover, String command) {
        this.message = message;
        this.hover = hover;
        this.command = command;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getHover() {
        return this.hover;
    }

    public void send(final Player player){
        final TextComponent message = new TextComponent(ChatUtil.colour(this.message));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, this.command));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatUtil.colour(this.hover))));

        player.spigot().sendMessage(message);
    }
}
