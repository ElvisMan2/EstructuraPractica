import javax.swing.JOptionPane;

public class UsoLista {
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        int opcion = 0, el;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        """
                                1. Agregar un elemento al inicio de la lista
                                2. Agregar un elemento al final de la lista
                                3. Insertar un elemento en una posición específica
                                4. Mostrar datos de la lista
                                5. Eliminar el primer elemento de la lista
                                6. Eliminar el último elemento de la lista
                                7. Eliminar un elemento en específico
                                8. Verificar si la lista está vacía
                                9. Verificar si la lista contiene un elemento
                                10. Obtener el tamaño de la lista
                                11. Obtener el índice de un elemento
                                12. Obtener el primer elemento
                                13. Obtener el último elemento
                                14. Obtener elemento en una posición
                                15. Eliminar todos los elementos iguales a un valor
                                16. Salir""","Menú de Opciones", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento",
                                    "Agregando al inicio de la lista", JOptionPane.INFORMATION_MESSAGE));
                            lista1.addFirst(el);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de agregar al inicio
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 2 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento",
                                    "Agregando al final de la lista", JOptionPane.INFORMATION_MESSAGE));
                            lista1.addLast(el);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de agregar al final
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 3 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento",
                                    "Insertar en una posición específica", JOptionPane.INFORMATION_MESSAGE));
                            int posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa la posición donde deseas insertar el elemento", "Posición",
                                    JOptionPane.INFORMATION_MESSAGE));
                            lista1.insertAt(el, posicion);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de la inserción
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 4 -> JOptionPane.showMessageDialog(null, "Elementos de la lista:\n" + lista1,
                            "Mostrando la lista", JOptionPane.INFORMATION_MESSAGE);
                    case 5 -> {
                        if (!lista1.isEmpty()) {
                            lista1.removeFirst();
                            JOptionPane.showMessageDialog(null, "Se eliminó el primer elemento de la lista.",
                                    "Eliminando el primer elemento", JOptionPane.INFORMATION_MESSAGE);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de eliminar el primer elemento
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista está vacía.", "Lista Vacía",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 6 -> {
                        if (!lista1.isEmpty()) {
                            lista1.removeLast();
                            JOptionPane.showMessageDialog(null, "Se eliminó el último elemento de la lista.",
                                    "Eliminando el último elemento", JOptionPane.INFORMATION_MESSAGE);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de eliminar el último elemento
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista está vacía.", "Lista Vacía",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 7 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento a eliminar...",
                                    "Eliminando elemento en específico", JOptionPane.INFORMATION_MESSAGE));
                            lista1.removeAll(el);
                            JOptionPane.showMessageDialog(null, "Se eliminaron todos los elementos " + el + " de la lista.",
                                    "Eliminando elementos iguales", JOptionPane.INFORMATION_MESSAGE);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de eliminar elementos
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 8 -> {
                        if (lista1.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La lista está vacía.", "Lista Vacía",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista no está vacía.", "Lista no Vacía",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 9 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento a verificar...",
                                    "Verificando si la lista contiene el elemento", JOptionPane.INFORMATION_MESSAGE));
                            if (lista1.contains(el)) {
                                JOptionPane.showMessageDialog(null, "La lista contiene el elemento " + el,
                                        "Elemento Encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "La lista no contiene el elemento " + el,
                                        "Elemento no Encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 10 -> JOptionPane.showMessageDialog(null, "Tamaño de la lista: " + lista1.getSize(),
                            "Tamaño de la lista", JOptionPane.INFORMATION_MESSAGE);
                    case 11 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento a buscar...",
                                    "Obteniendo el índice de un elemento", JOptionPane.INFORMATION_MESSAGE));
                            int index = lista1.getIndexOf(el);
                            if (index != -1) {
                                JOptionPane.showMessageDialog(null, "El índice del elemento " + el + " es: " + index,
                                        "Índice encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El elemento " + el + " no está en la lista",
                                        "Elemento no Encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 12 -> {
                        if (!lista1.isEmpty()) {
                            int first = lista1.getFirst();
                            JOptionPane.showMessageDialog(null, "El primer elemento de la lista es: " + first,
                                    "Obteniendo el primer elemento", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista está vacía.", "Lista Vacía",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 13 -> {
                        if (!lista1.isEmpty()) {
                            int last = lista1.getLast();
                            JOptionPane.showMessageDialog(null, "El último elemento de la lista es: " + last,
                                    "Obteniendo el último elemento", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista está vacía.", "Lista Vacía",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 14 -> {
                        try {
                            int size = lista1.getSize();
                            if (size > 0) {
                                int posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingresa la posición del elemento a obtener", "Obteniendo elemento en posición",
                                        JOptionPane.INFORMATION_MESSAGE));
                                int elementAt = lista1.getAt(posicion);
                                JOptionPane.showMessageDialog(null, "El elemento en la posición " + posicion + " es: " + elementAt,
                                        "Elemento en Posición", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "La lista está vacía.", "Lista Vacía",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 15 -> {
                        try {
                            el = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento a eliminar...",
                                    "Eliminar todos los elementos iguales", JOptionPane.INFORMATION_MESSAGE));
                            lista1.removeAll(el);
                            JOptionPane.showMessageDialog(null, "Se eliminaron todos los elementos " + el + " de la lista.",
                                    "Eliminando elementos iguales", JOptionPane.INFORMATION_MESSAGE);
                            lista1.mostrarListaEnTiempoReal(); // Mostrar la lista después de eliminar elementos
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error: " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    case 16 -> JOptionPane.showMessageDialog(null, "Programa Finalizado");
                    default -> JOptionPane.showMessageDialog(null, "Opción incorrecta");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } while (opcion != 16);
    }
}
