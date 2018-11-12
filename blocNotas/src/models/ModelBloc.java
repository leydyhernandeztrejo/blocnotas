/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import views.ViewBloc;

/**
 *variables
 * @author morenita
 */
public class ModelBloc {
    ViewBloc viewbloc;
    private String path="C:\\archivos\\archivo.txt";//lee el archivo ubicado en C
    private String menssage = "";
    boolean condicion = false;
//se crean los metodos get y set
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getMensage() {
        return menssage;
    }

    public void setMensage(String mensage) {
        this.menssage = mensage;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }
    
    
    /**
     * lee el archivo segun la ruta
     */
    public void leer(){
        try{
            String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        menssage = menssage + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"File not found: " + ex.getMessage());
        }catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operation" + ex.getMessage());
        }
    }
    /**
     * escribe y guarda cambios
     */
    public void escribir(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter (file,condicion);
            try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                printWriter.print(menssage);
                printWriter.close();
            }
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(viewbloc,"File not found: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
}
