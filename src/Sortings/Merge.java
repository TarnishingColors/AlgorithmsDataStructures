package Sortings;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.Scanner;

import static Sortings.funcs.*;

public class Merge {
    private static ArrayList<Integer> aux;

    private static void merge(ArrayList<Integer> a, int lo, int mid, int hi){
        int i = lo, j = mid+1;
        for (int k = i; k <= hi; k++){
            if (aux.size() <= k) aux.add(a.get(k));
            else aux.set(k, a.get(k));
        }
        show(aux);
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a.set(k, aux.get(j++));
            else if (j > hi) a.set(k, aux.get(i++));
            else if (less(aux.get(j), aux.get(i))) a.set(k, aux.get(j++));
            else a.set(k, aux.get(i++));
        }
    }

    public static void sort(ArrayList<Integer> a){
        aux = new ArrayList<Integer>();
        sort(a, 0, a.size() - 1);
    }

    private static void sort(ArrayList<Integer> a, int lo, int hi){
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, 0, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
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
