package Sortings;

import java.util.ArrayList;
import java.util.Scanner;

import static Sortings.funcs.*;

public class Heap {
    private static void swim(ArrayList<Integer> a, int k){
        while(k > 1 && less(a.get(k / 2), a.get(k))){
            exchange(a, k, k / 2);
            k = k / 2;
        }
    }

    private static void sink(ArrayList<Integer> a, int k){
        show(a);
        int n = a.size();
        while(2 * k <= n){
            int j = 2 * k;
            if (j < n && less(a.get(j), a.get(j + 1))) j++;
            if (!less(a.get(k), a.get(j))) break;
            exchange(a, k, j);
            k = j;
        }
    }

    public static void sort(ArrayList<Integer> a){
        int n = a.size();
        for (int k = n / 2; k >= 1; k--){
            sink(a, k);
        }
        while (n > 1){
            exchange(a, 1, n--);
            sink(a, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        while (sc.hasNextInt()){
            a.add(sc.nextInt());
        }
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
