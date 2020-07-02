package me.facto.basalplugin;

import me.facto.basalplugin.redis.WhitelistAddListener;
import me.facto.basalplugin.redis.WhitelistRemoveListener;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class BasalSMP extends JavaPlugin {

    public static BasalSMP instance;

    public JedisCluster jedisCluster;

    @Override
    public void onEnable() {
        BasalSMP.instance = this;

        this.jedisCluster = new JedisCluster(new HostAndPort(getConfig().getString("redis.host"), getConfig().getInt("redis.port")));

        new WhitelistAddListener(this.jedisCluster);
        new WhitelistRemoveListener(this.jedisCluster);

        getLogger().info("Plugin has been loaded!");

        this.saveDefaultConfig();
    }

}
