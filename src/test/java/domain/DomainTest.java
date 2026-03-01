package domain;

import domain.entities.*;
import domain.actions.*;
import domain.enums.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DomainTest {
    private Train train;
    private ITMOStudent itmo;
    private MCStudent msu;
    private YSDAStudent shad;

    @BeforeEach
    void setUp() {
        train = new Train();
        itmo = new ITMOStudent();
        msu = new MCStudent();
        shad = new YSDAStudent();

        itmo.addToBackpack(new Item("Худи", ItemType.ITMO_MERCH));
        msu.addToBackpack(new Item("Листок", ItemType.MATH_SHEET));

        train.addPassenger(itmo);
        train.addPassenger(msu);
        train.addPassenger(shad);
    }

    @Test
    @DisplayName("Анекдот")
    void testJokeStoryline() {
        // итмошник выкидывает мерч
        new ThrowItemAction(itmo, ItemType.ITMO_MERCH).execute();
        assertTrue(itmo.getBackpack().isEmpty());

        // мкновец выкидывает листок
        new ThrowItemAction(msu, ItemType.MATH_SHEET).execute();
        assertTrue(msu.getBackpack().isEmpty());

        // шадовец выкидывает мкновца
        new ThrowPersonAction(train).execute();

        assertAll("Итоговое состояние",
                () -> assertEquals(StudentStatus.EJECTED, msu.getStatus(), "мкновец должен иметь статус EJECTED"),
                () -> assertFalse(train.getPassengers().contains(msu), "мкновец должен исчезнуть из поезда"),
                () -> assertEquals(2, train.getPassengers().size(), "В поезде только итмошник и шадовец")
        );
    }
}