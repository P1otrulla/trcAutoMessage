package net.osnixer.automessage.task;

import net.osnixer.automessage.data.Configuration;
import net.osnixer.automessage.object.OpenWebAutoMessage;
import net.osnixer.automessage.object.RunCommandAutoMessage;
import net.osnixer.automessage.object.interfaces.AutoMessage;
import net.osnixer.automessage.object.interfaces.Hoverable;
import net.osnixer.automessage.util.ChatUtil;
import org.bukkit.Bukkit;

public class AutoMessageTask implements Runnable {

    private final Configuration configuration;
    private int index;

    public AutoMessageTask(Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public void run() {
        if (this.configuration.autoMessages.size() <= this.index){
            this.index = 0;
        }
        final AutoMessage message = this.configuration.autoMessages.get(this.index);
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (!(message instanceof Hoverable)){
                ChatUtil.sendMessage(player, message.getMessage());
            }
            if (message instanceof RunCommandAutoMessage){
                ((RunCommandAutoMessage) message).send(player);
            }
            if (message instanceof OpenWebAutoMessage){
                ((OpenWebAutoMessage) message).send(player);
            }
        });
        this.index++;
    }
}
