import javax.swing.JOptionPane;

public class Lista {
    protected Nodo inicio, fin; // Punteros para saber dónde están el inicio y el fin

    public Lista() {
        inicio = null;
        fin = null;
    }

    // Método para mostrar los datos en tiempo real en la terminal
    public void mostrarListaEnTiempoReal() {
        Nodo recorrer = inicio;
        System.out.print("Lista: ");
        while (recorrer != null) {
            System.out.print("[" + recorrer.dato + "]-->");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null");
    }

    public void addFirst(int elemento) {
        // Agrega un elemento al inicio de la lista
        inicio = new Nodo(elemento, inicio);
        if (fin == null) {
            fin = inicio;
        }
    }

    public void addLast(int elemento) {
        // Agrega un elemento al final de la lista
        if (!isEmpty()) {
            fin.siguiente = new Nodo(elemento);
            fin = fin.siguiente;
        } else {
            inicio = fin = new Nodo(elemento);
        }
    }

    public void insertAt(int elemento, int posicion) {
        // Inserta un elemento en una posición específica
        if (posicion < 0) {
            System.out.println("La posición no puede ser negativa.");
            return;
        }

        if (posicion == 0) {
            addFirst(elemento);
        } else {
            Nodo nuevoNodo = new Nodo(elemento);
            Nodo temporal = inicio;
            int contador = 0;

            while (temporal != null && contador < posicion - 1) {
                temporal = temporal.siguiente;
                contador++;
            }

            if (temporal != null) {
                nuevoNodo.siguiente = temporal.siguiente;
                temporal.siguiente = nuevoNodo;
                if (nuevoNodo.siguiente == null) {
                    fin = nuevoNodo;
                }
            } else {
                System.out.println("La posición está más allá del final de la lista.");
            }
        }
    }

    public boolean isEmpty() {
        // Verifica si la lista está vacía
        return inicio == null;
    }

    public boolean contains(int elemento) {
        // Verifica si un elemento está en la lista
        return getIndexOf(elemento) != -1;
    }

    public int getSize() {
        // Obtiene el tamaño de la lista
        int size = 0;
        Nodo temporal = inicio;
        while (temporal != null) {
            size++;
            temporal = temporal.siguiente;
        }
        return size;
    }

    public int getIndexOf(int elemento) {
        // Obtiene el índice de un elemento en la lista
        int index = 0;
        Nodo temporal = inicio;
        while (temporal != null) {
            if (temporal.dato == elemento) {
                return index;
            }
            temporal = temporal.siguiente;
            index++;
        }
        return -1; // Elemento no encontrado
    }

    public int getFirst() {
        // Obtiene el primer elemento de la lista
        if (inicio != null) {
            return inicio.dato;
        }
        throw new IllegalStateException("La lista está vacía.");
    }

    public int getLast() {
        // Obtiene el último elemento de la lista
        if (fin != null) {
            return fin.dato;
        }
        throw new IllegalStateException("La lista está vacía.");
    }

    public int getAt(int posicion) {
        // Obtiene un elemento en una posición específica
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa.");
        }

        Nodo temporal = inicio;
        int contador = 0;

        while (temporal != null && contador < posicion) {
            temporal = temporal.siguiente;
            contador++;
        }

        if (temporal != null) {
            return temporal.dato;
        }

        throw new IndexOutOfBoundsException("La posición está más allá del final de la lista.");
    }

    public String toString() {
        // Convierte la lista a una cadena de texto
        StringBuilder sb = new StringBuilder();
        Nodo temporal = inicio;

        while (temporal != null) {
            sb.append("[").append(temporal.dato).append("]--->");
            temporal = temporal.siguiente;
        }

        sb.append("null");
        return sb.toString();
    }

    public void removeFirst() {
        // Elimina el primer elemento de la lista
        if (!isEmpty()) {
            inicio = inicio.siguiente;
        }
    }

    public void removeLast() {
        // Elimina el último elemento de la lista
        if (!isEmpty()) {
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                Nodo temporal = inicio;
                while (temporal.siguiente != fin) {
                    temporal = temporal.siguiente;
                }
                fin = temporal;
                fin.siguiente = null;
            }
        }
    }

    public void removeAll(int elemento) {
        // Elimina todos los elementos iguales a un valor dado
        while (contains(elemento)) {
            if (inicio.dato == elemento) {
                removeFirst();
            } else {
                Nodo anterior = inicio;
                Nodo temporal = inicio.siguiente;
                while (temporal != null && temporal.dato != elemento) {
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }
                if (temporal != null) {
                    anterior.siguiente = temporal.siguiente;
                    if (temporal == fin) {
                        fin = anterior;
                    }
                }
            }
        }
    }

    public void removeAt(int posicion) {
        // Elimina un elemento en una posición específica
        if (posicion < 0) {
            System.out.println("La posición no puede ser negativa.");
            return;
        }

        if (posicion == 0) {
            removeFirst();
        } else {
            Nodo temporal = inicio;
            int contador = 0;

            while (temporal != null && contador < posicion - 1) {
                temporal = temporal.siguiente;
                contador++;
            }

            if (temporal != null && temporal.siguiente != null) {
                temporal.siguiente = temporal.siguiente.siguiente;
                if (temporal.siguiente == null) {
                    fin = temporal;
                }
            } else {
                System.out.println("La posición está más allá del final de la lista.");
            }
        }
    }
}
