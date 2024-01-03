package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface LaptopDao {
     void dodajLaptopUListu(Laptop laptop);
     void dodajLaptopUFile(Laptop laptop) throws IOException;
     void napuniListu(ArrayList<Laptop> laptopi);
     Laptop getLaptop(String procesor);
     ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException;
}
