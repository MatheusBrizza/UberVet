package com.ubervet.backend.model;

import java.util.Comparator;

public class UsuarioComparator implements Comparator<Usuario> {

    @Override
    public int compare(Usuario a, Usuario b) {

        return Integer.parseInt(a.getId()) - Integer.parseInt(b.getId());
    }
}
