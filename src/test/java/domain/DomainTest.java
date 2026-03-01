package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class DomainTest {
    private Train train;
    private ITMOStudent itmo;
    private MCStudent mcs;
    private YSDAStudent ysda;

    @BeforeEach
    void setUp() {
        train = new Train();
        itmo = new ITMOStudent();
        mcs = new MCStudent();
        ysda = new YSDAStudent();

        itmo.addToBackpack("худи итмо");
        mcs.addToBackpack("листок с кр по матану");

        train.addPassenger(itmo);
        train.addPassenger(mcs);
        train.addPassenger(ysda);
    }

    @Test
    @DisplayName("Проверка сценария: каждый студент выполняет действие")
    void testJokeStoryline() {
        itmo.doAction(train);
        assertTrue(itmo.backpack.isEmpty(), "итмошник должен выкинуть мерч");
        assertEquals(3, train.getPassengers().size(), "В поезде три человека");

        mcs.doAction(train);
        assertTrue(mcs.backpack.isEmpty(), "мкновец должен выкинуть листок");

        ysda.doAction(train);

        assertAll("Итоговое состояние после действий",
                () -> assertFalse(train.getPassengers().contains(mcs), "мкновец должен быть выброшен из поезда"),
                () -> assertTrue(train.getPassengers().contains(itmo), "итмошник должен остаться"),
                () -> assertTrue(train.getPassengers().contains(ysda), "шадовец должен остаться"),
                () -> assertEquals(2, train.getPassengers().size(), "В поезде два человека")
        );
    }

    @Test
    @DisplayName("Проверка, что шадовец не может выкинуть мкновца, если последнего нет")
    void testShadActionWithNoMSU() {
        train.removePassenger(mcs);
        int initialSize = train.getPassengers().size();

        ysda.doAction(train);

        assertEquals(initialSize, train.getPassengers().size(), "Количество пассажиров не должно измениться");
    }
}