package fr.army.leap.listener.impl;

import fr.army.leap.LeapPlugin;
import fr.army.leap.utils.network.task.queue.PlayerSenderQueueManager;
import fr.army.leap.utils.network.task.sender.TaskSenderManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Map;

public class SenderQueueListener implements Listener {

    private final LeapPlugin plugin;

    public SenderQueueListener(LeapPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        final TaskSenderManager taskSenderManager = plugin.getTaskSenderManager();
        final Map<String, PlayerSenderQueueManager> playerSender = taskSenderManager.getPlayerSenderQueueManagerMap();

        playerSender.forEach((serverName, playerSenderQueueManager) -> {
            playerSenderQueueManager.removePlayer(event.getPlayer());
            playerSenderQueueManager.refreshPositionIndicator();
        });
    }
}
