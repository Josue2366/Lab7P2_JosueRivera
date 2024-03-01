/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_josuerivera;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josue
 */
public class Admin_Product {
   private ArrayList <Producto> lista = new ArrayList();
   private File Archivo = null;

    public Admin_Product(String x) {
        Archivo = new File (x);
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Producto> lista) {
        this.lista = lista;
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    @Override
    public String toString() {
        return "Admin_Product{" + "lista=" + lista + ", Archivo=" + Archivo + '}';
    }
   
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(Archivo, false);
            bw = new BufferedWriter(fw);
            for (Producto t : lista) {
                bw.write(t.getId() + ",");
                bw.write(t.getName() + ",");
                bw.write(t.getCategory()+ ",");
                bw.write(t.getPrice()+",");
                bw.write(t.getAisle()+",");
                bw.write(t.getBin()+",");
            }
            bw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        bw.close();
        fw.close();
    }
    public void cargarArchivo() {
        Scanner sc = null;
        lista = new ArrayList();
        if (Archivo.exists()) {
            try {
                sc = new Scanner(Archivo);
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    lista.add(new Producto(sc.nextInt(),sc.next(),sc.nextInt()
                            ,sc.nextDouble(),sc.nextInt(),sc.nextInt()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            sc.close();
        }
    }

}
