package Sortings;


import java.util.ArrayList;
import java.util.Scanner;

import static Sortings.funcs.*;

public class Insertion {
    public static void sort(ArrayList<Integer> a){
        int n = a.size();
        for (int i = 1; i < n; i++){
            for (int j = i-1; j >= 0; j--){
                if (less(a.get(j + 1), a.get(j))) exchange(a, j, j+1);
            }
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
