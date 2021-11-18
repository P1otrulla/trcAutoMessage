package net.osnixer.automessage.data;

import com.google.common.collect.Lists;
import net.osnixer.automessage.AutoMessagePlugin;
import net.osnixer.automessage.object.NormalAutoMessage;
import net.osnixer.automessage.object.OpenWebAutoMessage;
import net.osnixer.automessage.object.RunCommandAutoMessage;
import net.osnixer.automessage.object.interfaces.AutoMessage;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Configuration {

    public List<AutoMessage> autoMessages;
    public int interval;

    public Configuration(final AutoMessagePlugin plugin){
        plugin.saveDefaultConfig();

        final FileConfiguration fc = plugin.getConfig();

        this.autoMessages = Lists.newArrayList();
        this.interval = fc.getInt("interval");

        for (String key : fc.getConfigurationSection("messages").getKeys(false)){
            final String message = fc.getString("messages."+key+".message");

            if (fc.getString("messages."+key+".type") == null){
                this.autoMessages.add(new NormalAutoMessage(message));
            }else {
                final String type = fc.getString("messages."+key+".type");
                final String hover = fc.getString("messages."+key+".hover");
                final String action = fc.getString("messages."+key+".action");

                if (type.equalsIgnoreCase("RunCommand")){
                    this.autoMessages.add(new RunCommandAutoMessage(message, hover, action));
                }else if (type.equalsIgnoreCase("OpenWeb")){
                    this.autoMessages.add(new OpenWebAutoMessage(message, hover, action));
                }else {
                    this.autoMessages.add(new NormalAutoMessage(message));
                }
            }
        }
    }
}
