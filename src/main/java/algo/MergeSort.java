package algo;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private final List<String> trace = new ArrayList<>();

    public List<String> getTrace() {
        return trace;
    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            trace.add("split:" + left + "-" + right);

            sort(array, left, mid);
            sort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        trace.add("merge:" + left + "-" + right);

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}