package integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellness.retreat.scheduler.controllers.GuestController;
import com.wellness.retreat.scheduler.models.dtos.GuestDTO;
import com.wellness.retreat.scheduler.services.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class GuestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GuestService guestService;

    @InjectMocks
    private GuestController guestController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
    }


    @Test
    void testCreateGuest() throws Exception {
        GuestDTO guestDTO = new GuestDTO(/* initialize with test data */);
        when(guestService.saveGuest(any(GuestDTO.class))).thenReturn(guestDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        String guestJson = objectMapper.writeValueAsString(guestDTO);

        mockMvc.perform(post("/guests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(guestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(guestDTO.getLastName()));
    }
}