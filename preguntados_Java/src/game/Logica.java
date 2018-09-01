/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.LinkedList;

/**
 *
 * @author juangabriel
 */
public class Logica {

    private boolean x;
    private LinkedList<Player> jugadores;
    private LinkedList<preguntas>LIsta_preguntas;
    private ManejadorArchivos data;
    private final String direccion="preguntas.txt";
    public Logica() {   
        x = false;
        data=new ManejadorArchivos();
    }

    /* this method  is the principal for to star de game 
     and receives the objet player for parameter
     */
    public void stargame(Player player1, Player player2) {
        jugadores = new LinkedList<>();
        jugadores.add(player1);
        jugadores.add(player2);
       LIsta_preguntas= new LinkedList<>();

    }

    public boolean who_starts() {
        int radon = (int) (Math.random() * 5 + 1);
        if (radon < 3) {
            x = true;
        }
        if (radon >= 3) {
            x = false;
        }
        return x;

    }

    /**
     * @param state
     * @param name
     */
    public void turn(boolean state, String name) {
        if (state != false) {
//            for (int i = 0; i < jugadores.size(); i++) {
//                if (jugadores.get(i).getName().equals(name)) {
//                   
//                }
//            }
            System.out.println(state);
            System.out.print(name);
        } else {
            System.out.println(state);
            System.out.print(name);
        }
    }

   
   public  void  upload_questions(){
      
        String dato = data.leerTextoArchivo(direccion);
        String [] all_data=dato.split("\n");
       if (!dato.isEmpty()) {
            for (String all_data1 : all_data) {
                  String[] datos =all_data1.split(",");
                  preguntas p= new preguntas();
                  p.setRespuesta(datos[0]);
                  p.setPregunta(datos[1]);
                  p.setPuntaje(Integer.parseInt(datos[2]));
                  LIsta_preguntas.add(p);
            }
       }
     
   }

    public boolean isX() {
        return x;
    }

    public void setX(boolean x) {
        this.x = x;
    }
    public LinkedList<preguntas> getLIsta_preguntas() {
        return LIsta_preguntas;
    }

   public void guardar_preguntas(preguntas p) {
         String  buffer=data.leerTextoArchivo(direccion);
          System.out.println(p);
         data.escribirTextoArchivo(direccion, buffer+p);
    }
   
}
