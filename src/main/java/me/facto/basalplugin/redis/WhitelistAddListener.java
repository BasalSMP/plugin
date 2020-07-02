package me.facto.basalplugin.redis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

public class WhitelistAddListener {

    private JedisCluster jedisCluster;

    public WhitelistAddListener(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
        this.listen();
    }

    private void listen() {
        this.jedisCluster.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                if (channel.equals("whitelistAddition")) {
                    // assume that the message is the player's uuid
                    Player player = Bukkit.getPlayer(message);
                    if (player != null && !player.isWhitelisted()) {
                        player.setWhitelisted(true);
                    }
                }
            }
        });
    }

}