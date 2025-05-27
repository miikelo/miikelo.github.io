package pl.mkl.algorytmy;

import java.util.Arrays;

public class SetSimple {

    private final boolean[] set;

    public SetSimple(boolean[] set) {
        this.set = Arrays.copyOf(set, set.length);
    }

    public SetSimple(SetSimple b) {
        this.set = Arrays.copyOf(b.set, b.set.length);
    }

    SetSimple put(int i) {
        if (i >= 0 && i < set.length) set[i] = true;
        return this;
    }

    SetSimple delete(int i) {
        if (i >= 0 && i < set.length) set[i] = false;
        return this;
    }

    boolean belongs(int i) {
        if (i >= 0 && i < set.length)
            return set[i];
        else
            return false;
    }

    SetSimple sum(SetSimple b) {
        SetSimple newset = new SetSimple(b);
        for (int i = 0; i < b.set.length; i++) {
            newset.set[i] = this.set[i] || b.set[i];
        }
        return newset;
    }

    SetSimple product(SetSimple b) {
        SetSimple newset = new SetSimple(b);
        for (int i = 0; i < b.set.length; i++) {
            newset.set[i] = this.set[i] && b.set[i];
        }
        return newset;
    }

    SetSimple diff(SetSimple b) {
        SetSimple newset = new SetSimple(b);
        for (int i = 0; i < b.set.length; i++) {
            newset.set[i] = this.set[i] && !b.set[i];
        }
        return newset;
    }

    boolean equals(SetSimple b) {
        for (int i = 0; i < this.set.length; i++) {
            if (this.set[i] != b.set[i]) {
                return false;
            }
            ;
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(set);
    }

    public static void main(String[] args) {
        SetSimple a = new SetSimple(new boolean[]{true, false, true, false, true});
        SetSimple b = new SetSimple(new boolean[]{true, true, false, false, false});

        //testy
        System.out.println("AeqA: " + a.equals(a));
        System.out.println("AeqB: " + a.equals(b));
        System.out.println("SUMA: " + a.sum(b));
        System.out.println("PROD: " + a.product(b));
        System.out.println("DIFF: " + a.diff(b));
        System.out.println("BELONGS a(3): " + a.belongs(3));
        System.out.println("PUT 3: " + a.put(3));
        System.out.println("BELONGS a(3): " + a.belongs(3));
        System.out.println("DEL 3: " + a.delete(3));
        System.out.println("BELONGS a(3): " + a.belongs(3));

    }
}
