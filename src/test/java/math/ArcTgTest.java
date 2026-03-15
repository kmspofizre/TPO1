package math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArcTgTest {

    @ParameterizedTest
    @DisplayName("Проверка точности аппроксимации arctg(x) через ряд Тейлора")
    @CsvFileSource(resources = "/arctg_data.csv", numLinesToSkip = 1)
    void testArctgSeries(double input, double expected) {
        assertEquals(expected, ArcTg.calculate(input), 0.0001);
    }
}