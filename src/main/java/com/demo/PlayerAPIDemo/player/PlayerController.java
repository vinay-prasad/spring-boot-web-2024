package com.demo.PlayerAPIDemo.player;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @GetMapping("")
    List<Player> getPlayers() {
        return playerRepository.getPlayers();
    }

    @GetMapping("/{name}")
    Player getPlayerByName(@PathVariable String name) {
        return playerRepository.getPlayerByName(name);
    }
}
