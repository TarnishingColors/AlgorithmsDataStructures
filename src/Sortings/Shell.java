package Sortings;

import java.util.ArrayList;
import java.util.Scanner;

import static Sortings.funcs.*;

public class Shell {
    public static void sort(ArrayList<Integer> a){
        int n = a.size();
        int h = 1;
        while (n / 3 > h) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a.get(j), a.get(j - h)); j-=h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
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
