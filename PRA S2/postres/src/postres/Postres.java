package postres;

import java.util.ArrayList;
import java.util.Scanner;

public class Postres {
   
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Postre> postre = new ArrayList<Postre>();
        
   while(true){
            System.out.println("Pasteleria LA FISI");
            System.out.println("1. Mostrar ingredientes de un postre");
            System.out.println("2. Ingresar nuevos ingredientes a un postre");
            System.out.println("3. Eliminar un ingrediente de algun postre");
            System.out.println("4. Dar de alta a un postre con sus ingredientes");
            System.out.println("5. Dar de baja a un postre con sus ingredientes");
            System.out.println("6. Salir del programa");
            System.out.println("Selecciona una opciòn");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option){
                case 1:
                    System.out.print("Ingrese el nombre del postre para ver los ingredientes: ");
                    String postreNameToViewIngredients = scanner.nextLine();
                    Postre postreToViewIngredients = findPostreByName(postre, postreNameToViewIngredients);
                    if (postreToViewIngredients != null) {
                     postreToViewIngredients.mostrarIngredientes();
                    } else {
                    System.out.println("El postre no existe.");
                }
                break;
                case 2:
                    System.out.print("Ingrese el nombre del postre: ");
                    String postreNameToAddIngredient = scanner.nextLine();
                    Postre postreToAddIngredient = findPostreByName(postre, postreNameToAddIngredient);
                    if (postreToAddIngredient != null) {
                        System.out.print("Ingrese el nuevo ingrediente: ");
                        String newIngrediente = scanner.nextLine();
                        postreToAddIngredient.agregarIngrediente(newIngrediente);
                        System.out.println("Ingrediente agregado correctamente.");
                    } else {
                        System.out.println("El postre no existe.");
                    }
                    break;    
                case 3:
                     System.out.print("Ingrese el nombre del postre: ");
                    String postreNameToRemoveIngredient = scanner.nextLine();
                    Postre postreToRemoveIngredient = findPostreByName(postre, postreNameToRemoveIngredient);
                    if (postreToRemoveIngredient != null) {
                        postreToRemoveIngredient.mostrarIngredientes();
                        System.out.print("Ingrese el número del ingrediente a eliminar: ");
                        int ingredientIndex = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea pendiente
                        if (ingredientIndex >= 1 && ingredientIndex <= postreToRemoveIngredient.getNumIngredientes()) {
                            postreToRemoveIngredient.eliminarIngrediente(ingredientIndex - 1);
                            System.out.println("Ingrediente eliminado correctamente.");
                        } else {
                            System.out.println("Número de ingrediente inválido.");
                        }
                    } else {
                        System.out.println("El postre no existe.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del nuevo postre: ");
                    String newPostreNameWithIngredients = scanner.nextLine();
                    Postre newPostreWithIngredients = new Postre(newPostreNameWithIngredients);
                    System.out.print("Ingrese la cantidad de ingredientes: ");
                    int numIngredients = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    for (int i = 0; i < numIngredients; i++) {
                        System.out.print("Ingrese el ingrediente " + (i + 1) + ": ");
                        String ingredient = scanner.nextLine();
                        newPostreWithIngredients.agregarIngrediente(ingredient);
                    }
                    postre.add(newPostreWithIngredients);
                    System.out.println("Postre agregado correctamente con sus ingredientes.");
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del postre a dar de baja: ");
                    String postreNameToRemove = scanner.nextLine();
                    Postre postreToRemove = findPostreByName(postre, postreNameToRemove);
                    if (postreToRemove != null) {
                        postre.remove(postreToRemove);
                        System.out.println("Postre dado de baja correctamente.");
                    } else {
                        System.out.println("El postre no existe.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
    
}
   }
       
      

private static void ordenarPostresAlfabeticamente(ArrayList<Postre> postres) {
        int n = postres.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (postres.get(j).getNombre().compareToIgnoreCase(postres.get(j + 1).getNombre()) > 0) {
                    Postre temp = postres.get(j);
                    postres.set(j, postres.get(j + 1));
                    postres.set(j + 1, temp);
                }
            }
        }
    }

    
private static Postre findPostreByName(ArrayList<Postre> postres, String name) {
        for (Postre postre : postres) {
            if (postre.getNombre().equalsIgnoreCase(name)) {
                return postre;
            }
        }
        return null;
    } 
    
}
 


class Postre{
    ArrayList<String> ingredientes = new ArrayList();
    String nombre;

    public Postre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void agregarIngrediente(String ingrediente){
        ingredientes.add(ingrediente);
    }
    
    public void eliminarIngrediente(int index){
        ingredientes.remove(index);
    }
    
    public void mostrarIngredientes(){
        System.out.println("Ingredientes de "+ nombre +":");
        for(int i=0; i<ingredientes.size();i++){
            System.out.println((i+1)+". "+ingredientes.get(i));
        }
    }
    
    public int getNumIngredientes() {
        return ingredientes.size();
    }
    
}


