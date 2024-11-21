package com.demo.PlayerAPIDemo.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;  // Automatically injected by Spring

    @BeforeEach
    void setUp() {
        // In a real Spring context, `@PostConstruct` will be triggered by Spring,
        // so we don't need to manually call loadPlayers() in this case.
        // If you're running integration tests, the players will be loaded by the time this method runs.
    }

    @Test
    void testGetPlayerByName_WhenPlayerExists() {
        // Test that a player can be found by their name
        Player player = playerRepository.getPlayerByName("Vinay");

        assertNotNull(player);
        assertEquals("Vinay", player.name());
        assertEquals(134.2f, player.height());
        assertEquals(165.3f, player.weight());
        assertEquals(2011, player.debut());
        assertEquals("Dhanbad", player.location().birthCity());
        assertEquals("Jharkhand", player.location().birthState());
    }


    @Test
    void testGetPlayerByName_WhenPlayerDoesNotExist() {
        // Test that a non-existent player returns null
        Player player = playerRepository.getPlayerByName("NonExistent");

        assertNull(player);
    }

    @Test
    void testGetPlayers() {
        // Test that getPlayers returns the correct list of players
        List<Player> players = playerRepository.getPlayers();

        assertNotNull(players);
        assertEquals(2, players.size());

        // Check individual players
        Player vinay = players.stream()
                .filter(p -> p.name().equals("Vinay"))
                .findFirst().orElse(null);
        Player shankar = players.stream()
                .filter(p -> p.name().equals("Shankar"))
                .findFirst().orElse(null);

        assertNotNull(vinay);
        assertNotNull(shankar);
    }

    @Test
    void testPlayerRepositoryInitialization() {
        // Verify the player repository initializes players correctly through @PostConstruct
        Player vinay = playerRepository.getPlayerByName("Vinay");
        assertNotNull(vinay);
        assertEquals("Vinay", vinay.name());

        Player shankar = playerRepository.getPlayerByName("Shankar");
        assertNotNull(shankar);
        assertEquals("Shankar", shankar.name());
    }
  
}