package me.facto.basalplugin.redis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

public class WhitelistRemoveListener {

    private JedisCluster jedisCluster;

    public WhitelistRemoveListener(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
        this.listen();
    }

    private void listen() {
        this.jedisCluster.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                if (channel.equals("whitelistRemove")) {
                    // once again, let's assume the redis publisher included the uuid for the account for bukkit
                    Player player = Bukkit.getPlayer(message);
                    if (player != null && player.isWhitelisted()) {
                        player.setWhitelisted(false);
                    }
                }
            }
        });
    }

}
