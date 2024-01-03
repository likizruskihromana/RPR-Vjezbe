package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AppTest
{
    @Test
    void Test1() throws IOException, ClassNotFoundException {
        LaptopDaoSerializableFile ldao = new LaptopDaoSerializableFile();

        ArrayList<Laptop> laptops1 = new ArrayList<>();
        laptops1.add((new Laptop("HP", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        laptops1.add((new Laptop("Dell", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        laptops1.add((new Laptop("ThinkPad", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        ldao.napuniListu(laptops1);

        Assertions.assertThrows(NeodgovarajuciProcesorException.class, () -> {
            Laptop l = ldao.getLaptop("Intel");
        });

        ldao.dodajLaptopUFile(new Laptop("Lenovo", "Intel", 0, 0, 0, 0, "...", "...", 0));
        ldao.dodajLaptopUFile(new Laptop("ASUS", "Intel", 0, 0, 0, 0, "...", "...", 0));
        ldao.dodajLaptopUFile(new Laptop("Acer", "Intel", 0, 0, 0, 0, "...", "...", 0));

        ArrayList<Laptop> laptops2 = ldao.vratiPodatkeIzDatoteke();
        String testString = "LAPTOP {brand = 'Lenovo', model = 'Intel', price = 0.0, RAM = 0, HDD = 0, SSD = 0, CPU = '...', GPU = '...', screen_size = 0.0}";
        Assertions.assertEquals(testString, laptops2.get(3).toString());
    }

    @Test
    void Test2() throws IOException {
        LaptopDaoJSONFile ldao = new LaptopDaoJSONFile();

        ArrayList<Laptop> laptops1 = new ArrayList<>();
        laptops1.add((new Laptop("HP", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        laptops1.add((new Laptop("Dell", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        laptops1.add((new Laptop("ThinkPad", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        ldao.napuniListu(laptops1);

        Assertions.assertThrows(NeodgovarajuciProcesorException.class, () -> {
            Laptop l = ldao.getLaptop("Intel");
        });

        ldao.dodajLaptopUFile(new Laptop("Lenovo", "Intel", 0, 0, 0, 0, "...", "...", 0));
        ldao.dodajLaptopUFile(new Laptop("ASUS", "Intel", 0, 0, 0, 0, "...", "...", 0));
        ldao.dodajLaptopUFile(new Laptop("Acer", "Intel", 0, 0, 0, 0, "...", "...", 0));

        ArrayList<Laptop> laptops2 = ldao.vratiPodatkeIzDatoteke();
        String testString = "LAPTOP {brand = 'Lenovo', model = 'Intel', price = 0.0, RAM = 0, HDD = 0, SSD = 0, CPU = '...', GPU = '...', screen_size = 0.0}";
        Assertions.assertEquals(testString, laptops2.get(3).toString());
    }

    @Test
    void Test3() throws IOException {
        LaptopDaoXMLFile ldao = new LaptopDaoXMLFile();

        ArrayList<Laptop> laptops1 = new ArrayList<>();
        laptops1.add((new Laptop("HP", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        laptops1.add((new Laptop("Dell", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        laptops1.add((new Laptop("ThinkPad", "AMD", 0, 0, 0, 0, "...", "...", 0)));
        ldao.napuniListu(laptops1);

        Assertions.assertThrows(NeodgovarajuciProcesorException.class, () -> {
            Laptop l = ldao.getLaptop("Intel");
        });

        ldao.dodajLaptopUFile(new Laptop("Lenovo", "Intel", 0, 0, 0, 0, "...", "...", 0));
        ldao.dodajLaptopUFile(new Laptop("ASUS", "Intel", 0, 0, 0, 0, "...", "...", 0));
        ldao.dodajLaptopUFile(new Laptop("Acer", "Intel", 0, 0, 0, 0, "...", "...", 0));

        ArrayList<Laptop> laptops2 = ldao.vratiPodatkeIzDatoteke();
        String testString = "LAPTOP {brand = 'Lenovo', model = 'Intel', price = 0.0, RAM = 0, HDD = 0, SSD = 0, CPU = '...', GPU = '...', screen_size = 0.0}";
        Assertions.assertEquals(testString, laptops2.get(3).toString());

    }
}