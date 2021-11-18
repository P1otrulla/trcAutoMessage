package net.osnixer.automessage.object.interfaces;

import net.osnixer.automessage.object.NormalAutoMessage;
import net.osnixer.automessage.object.OpenWebAutoMessage;
import net.osnixer.automessage.object.RunCommandAutoMessage;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public interface AutoMessage {

    String getMessage();

    default AutoMessage build(@NotNull ConfigurationSection section){
        final String message = section.getString("message");
        if (!section.contains("type")){
            return new NormalAutoMessage(message);
        }
        final String hover = section.getString("hover");
        final String type = section.getString("type");
        if (type.equalsIgnoreCase("OpenWeb")){
            final String url = section.getString("web");
            return new OpenWebAutoMessage(message, hover, url);
        }
        else if (type.equalsIgnoreCase("RunCommand")){
            final String command = section.getString("command");
            return new RunCommandAutoMessage(message, hover, command);
        }
        return new NormalAutoMessage(message);
    }
}
