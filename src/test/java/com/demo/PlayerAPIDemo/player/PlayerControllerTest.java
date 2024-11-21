package com.demo.PlayerAPIDemo.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class) // This annotation is used to test only the controller
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc; // MockMvc is used to simulate HTTP requests

    @MockBean
    private PlayerRepository playerRepository; // Mock the repository


    @Test
    void testGetPlayerByName_WhenPlayerExists() throws Exception {
        // Given
        Player player = new Player("Vinay", 134.2f, 165.3f, 2011, new Location("Dhanbad", "Jharkhand"));
        when(playerRepository.getPlayerByName("Vinay")).thenReturn(player);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/players/Vinay"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Vinay"))
                .andExpect(jsonPath("$.location.birthCity").value("Dhanbad"));

        verify(playerRepository, times(1)).getPlayerByName("Vinay"); // Verify repository interaction
    }

}