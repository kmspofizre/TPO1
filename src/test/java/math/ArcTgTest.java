package math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArcTgTest {

    @ParameterizedTest
    @DisplayName("Проверка точности аппроксимации arctg(x) через ряд Тейлора")
    @CsvSource({
            "0.0, 0.0",                 // arctg(0) = 0
            "0.267949, 0.261799",       // arctg(1/sqrt(12)) = pi/12
            "0.577350, 0.523598",       // arctg(1/sqrt(3)) = pi/6
            "1.0, 0.785398",            // arctg(1) = pi/4
            "-1.0, -0.785398",          // arctg(-1) = -pi/4
            "0.5, 0.463647",            // Табличное значение
            "-0.5, -0.463647"           // Табличное значение
    })
    void testArctgSeries(double input, double expected) {
        assertEquals(expected, ArcTg.calculate(input), 0.0001);
    }
}