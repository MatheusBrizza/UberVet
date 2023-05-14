package com.ubervet.backend.model;

import java.util.Comparator;

public class VeterinarioComparator implements Comparator<Veterinario> {

    @Override
    public int compare(Veterinario a, Veterinario b) {

        return Integer.parseInt(a.getId()) - Integer.parseInt(b.getId());
    }
}
