package algo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {

    @Test
    @DisplayName("Тестирование MergeSort")
    void testMergeSortTrace() {
        MergeSort sorter = new MergeSort();
        int[] array = {3, 1, 2};

        sorter.sort(array, 0, array.length - 1);

        // Эталонная последовательность точек входа для массива из 3 элементов:
        // 1. Сплит всего массива [0-2]
        // 2. Сплит левой части [0-1]
        // 3. Мерж левой части [0-1] (когда 3 и 1 сравнялись)
        // 4. Мерж всего массива [0-2]
        List<String> expectedTrace = List.of(
                "split:0-2",
                "split:0-1",
                "merge:0-1",
                "merge:0-2"
        );

        assertEquals(expectedTrace, sorter.getTrace(), "Последовательность шагов не совпадает с эталонной");
        assertArrayEquals(new int[]{1, 2, 3}, array, "Массив должен быть отсортирован");
    }
}