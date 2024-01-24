package unit_test;

import com.wellness.retreat.scheduler.models.dtos.GuestDTO;
import com.wellness.retreat.scheduler.models.entities.Guest;
import com.wellness.retreat.scheduler.repositories.GuestRepository;
import com.wellness.retreat.scheduler.services.GuestServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuestServiceTest {

    @Mock
    private GuestRepository guestRepository;

    @InjectMocks
    private GuestServiceImpl guestService;

    @Test
    void testSaveGuest() {
        GuestDTO guestDTO = new GuestDTO(/* parameters */);
        Guest guest = new Guest(/* parameters */);

        when(guestRepository.save(ArgumentMatchers.<Guest>any())).thenReturn(guest);

        GuestDTO savedGuest = guestService.saveGuest(guestDTO);

        assertNotNull(savedGuest);

    }
}