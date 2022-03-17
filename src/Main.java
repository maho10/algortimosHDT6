import Map.MapFactory;
import Map.MapController;

import java.util.*;
import java.io.File;
import java.util.Map;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Vista v = new Vista();        

        v.bienvenida();
        int map_type = v.solicitar_map_type();

        MapController<String, String> myMap = new MapController<String, String>(map_type);
        myMap.getCards("cards_desc.txt");

        int desicion_menu = 0;
        boolean continuar_menu_principal = true;

        while(continuar_menu_principal){
            desicion_menu = v.menu_principal();

            switch (desicion_menu) {

                //Agregar Carta a coleccion
                case 1:
                    String name = v.get_card_name();
                    int user = v.get_user_number();

                    boolean carta_agregada = myMap.userCards(name, user);

                    System.out.println();
                    if(carta_agregada){
                        System.out.println("Carta agregada exitosamente !");
                    }
                    else{
                        System.out.println("Carta no agregada.");
                    }
                    System.out.println("--------------------------------------------------------");

                    break;

                //Mostrar tipo de Carta especifica
                case 2:

                    String carta_especifica = v.get_specific_card();
                    String carta = myMap.showCardType(carta_especifica);
                    System.out.println("Tipo de carta: "+carta);
                    System.out.println("--------------------------------------------------------");

                    break;

                //Mostrar coleccion de usuario
                case 3:
                    int user1 = v.get_user_number();
                    System.out.println();    
                    System.out.println("Mostrando coleccion de usuario...");
                    System.out.println(myMap.showCollection(user1, false));
                    break;

                //Mostrar coleccion de usuario ordenada
                case 4:
                    int user2 = v.get_user_number();
                    System.out.println();    
                    System.out.println("Mostrando coleccion de usuario ordenadas...");
                    System.out.println(myMap.showCollection(user2, true));
                    break;

                //Mostrar todas las cartas existentes
                case 5:
                    System.out.println();
                    System.out.println("Mostrando cartas existentes...");
                    System.out.println(myMap.showAllCards(false));
                    v.separador();
                    break;

                //Mostrar todas las cartas existentes ordenadas
                case 6:
                    System.out.println();
                    System.out.println("Mostrando cartas existentes ordenadas...");
                    System.out.println(myMap.showAllCards(true));
                    v.separador();
                    break;
            
                //Finalizar batalla
                default:
                    v.despedida();
                    continuar_menu_principal = false;
                    break;
            }
        }

    }
}

class Vista{
    private Scanner scan = new Scanner(System.in);

    private int solicitar_int(String s, int inferior, int superior){
        int new_inferior = (inferior - 1);
        int new_superior = (superior + 1);
        int entero = 0;
        boolean continuar = true;
            while(continuar){
                try{
                System.out.print(s);
                this.scan = new Scanner(System.in);
                int numero = scan.nextInt();
                if((numero>new_inferior)&&(numero<new_superior)){
                    entero = numero;
                    System.out.println("--------------------------------------------------------");
                    continuar = false; 
                }
                else{
                    System.out.println("\t Error: debe de ingresar un entero de " + inferior + " a " + superior + ".");   
                    System.out.println();              
                }
                }
                catch(Exception e){
                    System.out.println("\t Error: debe de ingresar un entero de " + inferior + " a " + superior + ".");
                    System.out.println();
                }
            }
        
        return entero;
    }

    private String solicitar_string(String s){
        String txt = "";
        boolean continuar = true;
        try{
            System.out.println(s);
            while(continuar){
                this.scan = new Scanner(System.in);
                String texto = scan.nextLine();
                if(texto.equals("")){
                    System.out.println("\t Error: debe de ingresar un texto valido.");
                }
                else{
                    txt = texto;
                    System.out.println("--------------------------------------------------------");
                    continuar = false;                   
                }
            }
        }
        catch(Exception e){
            System.out.println("\t Error: debe de ingresar un texto valido.");
        }
        return txt;
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
        System.out.println("Seleccionar tipo de Map!");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
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
        System.out.println("BATALLLA FINALIZADA!!!!");
        System.out.println("Muchas gracias por utilizar nuestro programa!!!");
        System.out.println();
        System.out.println("Vuelve pronto!");
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public void separador(){
        System.out.println("--------------------------------------------------------");
    }

    public String get_card_name(){
        System.out.println();
        String s = "Ingrese el nombre de la carta deseada: ";
        String card_name = solicitar_string(s);
        return card_name;
    }

    public int get_user_number(){
        System.out.println();
        String s = "Ingrese el numero de usuario: ";
        int user_number = solicitar_int(s, 0, 1000);
        return user_number;
    }

    public String get_specific_card(){
        System.out.println();
        String s = "Ingrese el nombre de la carta especifica: ";
        String card_name = solicitar_string(s);
        return card_name;
    }


}