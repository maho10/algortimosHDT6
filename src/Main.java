import Map.HashMapController;
import Map.MapFactory;

import java.util.Scanner;
import java.util.Map;
import javax.security.auth.DestroyFailedException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Vista v = new Vista();
        MapFactory myMapFactory = new MapFactory();
        Map myMap;

        v.bienvenida();
        int map_type = v.solicitar_map_type();
        int desicion_menu = 0;

        myMap = myMapFactory.getMap(map_type);

        boolean continuar_menu_principal = true;

        while(continuar_menu_principal){
            desicion_menu = v.menu_principal();

            switch (desicion_menu) {

                //Agregar Carta a coleccion
                case 1:
                    
                    break;

                //Mostrar tipo de Carta especifica
                case 2:

                    break;

                //Mostrar coleccion de usuario
                case 3:
                    
                    break;

                //Mostrar coleccion de usuario ordenada
                case 4:

                    break;

                //Mostrar todas las cartas existentes
                case 5:
                    
                    break;

                //Mostrar todas las cartas existentes ordenadas
                case 6:

                    break;
            
                //Finalizar batalla
                default:
                    continuar_menu_principal = false;
                    v.despedida();
                    break;
            }
        }

    }
}

class Vista{
    private Scanner scan = new Scanner(System.in);

    private int solicitar_int(String s, int inferior, int superior){
        inferior -= 1;
        superior += 1;
        int entero = 0;
        boolean continuar = true;
            while(continuar){
                try{
                System.out.print(s);
                this.scan = new Scanner(System.in);
                int numero = scan.nextInt();
                if((numero>inferior)&&(numero<superior)){
                    entero = numero;
                    System.out.println("--------------------------------------------------------");
                    continuar = false; 
                }
                else{
                    System.out.println("\t Error: debe de ingresar un entero de 1 y 3.");   
                    System.out.println();              
                }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un entero de 1 y 3.");
                    System.out.println();
                }
            }
        
        return entero;
    }

    public void bienvenida(){
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println("- Bienvenido!!!");
        System.out.println("Preparate para el combate!");
        System.out.println("Podras realizar diferentes operaciones!");
        System.out.println("sigue las instrucciones para evitar errores....");
        System.out.println();
        System.out.println("Que empiece la batalla!!!");
        System.out.println("--------------------------------------------------------");
    }

    public int solicitar_map_type(){
        String s = "Ingrese el tipo de Map que desee utilizar: ";
        int map_type = solicitar_int(s, 1, 3); 
        System.out.print("Felicidades!!! ha decidido utilizar ");
        switch (map_type) {
            case 1:
                System.out.println("HashMap!");
                break;

            case 2:
                System.out.println("TreeMap!");
                break;
        
            default:
                System.out.println("LinkedHashMap!");
                break;
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Estamos listos para iniciar el campo de batalla!!!");
        System.out.println("Dirigiendonos al menu principal...");
        System.out.println("--------------------------------------------------------");
        return map_type;
    }

    public int menu_principal(){
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println("------------------- MENU PRINCIPAL ---------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Agregar Carta a coleccion.");
        System.out.println("2. Mostrar tipo de Carta especifica.");
        System.out.println("3. Mostrar coleccion de usuario.");
        System.out.println("4. Mostrar coleccion de usuario ordenada.");
        System.out.println("5. Mostrar todas las cartas existentes.");
        System.out.println("6. Mostrar todas las cartas existentes ordenadas.");
        System.out.println("7. Finalizar batalla.");
        System.out.println();
        String s = "Ingrese su desicion: ";
        int desision = solicitar_int(s, 1, 7);
        return desision;
    }


    public void despedida(){
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println("Muchas gracias por utilizar nuestro programa!!!");
        System.out.println();
        System.out.println("Vuelve pronto!");
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }



}
