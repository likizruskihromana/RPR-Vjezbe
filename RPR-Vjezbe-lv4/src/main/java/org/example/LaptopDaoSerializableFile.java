package org.example;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;
    private DataInputStream ulaz;
    private DataOutputStream izlaz;
    LaptopDaoSerializableFile(){
        file=new File("dat.txt");
        laptopi=new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        laptopi.add(laptop);
        oos.writeObject(laptopi);
        oos.close();
        fos.close();
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
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        return (ArrayList<Laptop>)ois.readObject();
    }
}
