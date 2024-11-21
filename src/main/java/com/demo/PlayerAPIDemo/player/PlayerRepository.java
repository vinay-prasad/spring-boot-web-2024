package com.demo.PlayerAPIDemo.player;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class PlayerRepository {

    private HashMap<String, Player> playerMap = new HashMap<>();

    Player getPlayerByName(String name) {
        return playerMap.getOrDefault(name, null);
    }

    List<Player> getPlayers() {
        return new ArrayList<>(playerMap.values());
    }

    @PostConstruct
    private void loadPlayers() {
        playerMap.put("Vinay", new Player("Vinay", 134.2f, 165.3f, 2011, new Location("Dhanbad", "Jharkhand")));
        playerMap.put("Shankar",new Player("Shankar", 144.2f, 145.3f, 2013, new Location("Delhi", "Delhi")));
    }

}

