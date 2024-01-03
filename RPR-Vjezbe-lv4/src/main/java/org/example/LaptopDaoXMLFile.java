package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;
    LaptopDaoXMLFile(){
        file=new File("dat.xml");
        laptopi=new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
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
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        FileOutputStream os=new FileOutputStream(file);
        XmlMapper mapper=new XmlMapper();
        laptopi.add(laptop);
        String str=mapper.writeValueAsString(laptopi);
        os.write(str.getBytes());
        os.close();
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        XmlMapper mapper=new XmlMapper();
        return mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {
        });
    }
}
