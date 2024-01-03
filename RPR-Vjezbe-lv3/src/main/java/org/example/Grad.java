package org.example;

public enum Grad {
    TRAVNIK("030"),
    ZENICA("032"),
    SARAJEVO("033"),
  ;

    private String pozivniBroj;

    Grad(String pozivniBroj){
        this.pozivniBroj = pozivniBroj;
    }
    public static Grad izPozivnog(String pozivni){
        for(Grad g: Grad.values()){
            if (g.getPozivniBroj().equals(pozivni)){
                return g;
            }
        }
        return null;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }
}
