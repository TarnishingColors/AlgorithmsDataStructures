package Sortings;

import java.util.ArrayList;

import static Sortings.funcs.*;

public class Quick {
    public static void sort(ArrayList<Integer> a){
        sort(a, 0, a.size() - 1);
    }

    private static void sort(ArrayList<Integer> a, int lo, int hi){
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j);
        sort(a, j+1, hi);
    }

    private static int partition(ArrayList<Integer> a, int lo, int hi){
        int i = lo, j = hi+1;
        int v = a.get(lo);
        while (true){
            while (less(a.get(++i), v)) if (i == hi) break;
            while (less(v, a.get(--j))) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
}
