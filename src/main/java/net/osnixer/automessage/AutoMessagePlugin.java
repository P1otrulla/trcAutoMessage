package net.osnixer.automessage;

import net.osnixer.automessage.data.Configuration;
import net.osnixer.automessage.task.AutoMessageTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoMessagePlugin extends JavaPlugin {

    private Configuration configuration;

    @Override
    public void onEnable() {
        this.configuration = new Configuration(this);

        this.getServer().getScheduler().runTaskTimer(this, new AutoMessageTask(this.configuration), this.configuration.interval * 20L, this.configuration.interval * 20L);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
