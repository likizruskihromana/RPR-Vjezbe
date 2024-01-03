package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;
    LaptopDaoJSONFile(){
        file=new File("dat.json");
        laptopi=new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        JsonMapper mapper=new JsonMapper();
        laptopi.add(laptop);
        String str=mapper.writeValueAsString(laptopi);
        FileOutputStream fo=new FileOutputStream(file);
        fo.write(str.getBytes());
        fo.close();
    }

    @Override
    public void napuniListu(ArrayList<Laptop> lapt) {
        laptopi.addAll(lapt);
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop l: laptopi){
            if(l.getProcesor().equals(procesor))
              return l;
        }
        throw new NeodgovarajuciProcesorException("Neodg procesor");
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
       JsonMapper mapper=new JsonMapper();
       return mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {
       });
    }
}
