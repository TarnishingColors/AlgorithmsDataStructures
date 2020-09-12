package Sortings;

import java.util.ArrayList;

public class funcs {
    public static boolean less(int x, int y){
        return x < y;
    }

    public static void exchange(ArrayList<Integer> a, int i, int j){
        int t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    public static void show(ArrayList<Integer> a){
        for (int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(ArrayList<Integer> a){
        for (int i = 1; i < a.size(); i++){
            if (less(a.get(i), a.get(i - 1))) return false;
        }
        return true;
    }
}
