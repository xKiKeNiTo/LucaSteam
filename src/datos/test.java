package datos;

import java.util.List;

import utilidades.LectorCSV;

public class test {
    // public boolean listarPorGenero(Enum genero){
    //     boolean existen = false;

        

    // }

    public static void main(String[] args) {
        LectorCSV lector = new LectorCSV();
        List<List<String>> juegos = lector.getJuegos();
        for (List<String> fila : juegos) {
            System.out.println(fila);
        }
    }
}
