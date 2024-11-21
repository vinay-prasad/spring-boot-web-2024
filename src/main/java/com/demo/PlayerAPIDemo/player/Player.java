package com.demo.PlayerAPIDemo.player;

public record Player(
        String name,
        Float height,
        Float weight,
        Integer debut,
        Location location) {
}
