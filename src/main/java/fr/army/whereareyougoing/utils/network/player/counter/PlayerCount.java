package fr.army.whereareyougoing.utils.network.player.counter;

import org.jetbrains.annotations.NotNull;

public record PlayerCount(@NotNull String serverName, int playerCount) {
}
