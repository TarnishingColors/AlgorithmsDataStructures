package Sortings;

import java.util.ArrayList;
import java.util.Scanner;

import static Sortings.funcs.*;

public class Selection {
    public static void sort(ArrayList<Integer> a){
        int n = a.size();
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = i+1; j < n; j++){
                if (less(a.get(j), a.get(min))) min = j;
            }
            exchange(a, i, min);
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
