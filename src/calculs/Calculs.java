package calculs;

import static calculs.Dividir.divisio;
import static calculs.Modul.modul;
import static calculs.Multiplicacio.multiplicacio;
import static calculs.Resta.resta;
import static calculs.Sumar.suma;
import java.util.Scanner;
/**
 *
 * @author I.Ch.
 * @version 50
 */

public class Calculs {
    boolean  error=false;
    static final int MAX = 2147483647;
    static final int MIN = -2147483648;
    
    public static void main(String[] args) {
        Calculs calc = new Calculs("Versió 1.7.Ivan");
    }
    
    public Calculs(String x){
        System.out.println(x);
        Scanner sc = new Scanner(System.in);
        String cadena = "0";
        int part1;
        int part2;
        int resultat = 0;
        String[] parts = null;
        
        
        while(!cadena.equals("6661")){ ///qualsevol condicio de sortida finalment es pot posar EOF
            cadena = sc.nextLine();
            control(cadena);
            
            if(!error){
                try{
                    if (cadena.contains("-")) {
                       parts = cadena.split("-");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=resta(part1,part2);
                    }
                    if (cadena.contains("+")) {
                       parts = cadena.split("\\+");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=suma(part1,part2);
                    }
                    if (cadena.contains("/")) {
                       parts = cadena.split("/");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=divisio(part1,part2);
                    }
                    if (cadena.contains("*")) {
                       parts = cadena.split("\\*");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=multiplicacio(part1,part2);
                    }
                    if (cadena.contains("%")) {
                       parts = cadena.split("%");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       resultat=modul(part1,part2);
                    }

                    System.out.println(resultat);
                }catch(NumberFormatException e){
                    System.out.println("Error");
                }
            }
            error = false;
        }
    }
    
    public void control(String x){
        if(x.startsWith("/") ||x.startsWith("+")||x.startsWith("*")||x.startsWith("%")||x.startsWith("-")){
            error=true;
            System.out.println("Error");
        }
        else if (!(x.contains("-"))&&!(x.contains("/"))&&!(x.contains("+"))&&!(x.contains("*"))&&!(x.contains("%"))){
            error=true;
            System.out.println("Error syntax");
        }
    }
    
    
    
}

 