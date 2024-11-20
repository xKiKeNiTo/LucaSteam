package datos;

import java.util.List;
import utilidades.lectorCSV;

public class test {
    // public boolean listarPorGenero(Enum genero){
    //     boolean existen = false;

        

    // }

    public static void main(String[] args) {
        lectorCSV lector = new lectorCSV();
        List<List<String>> juegos = lector.getJuegos();
        for (List<String> fila : juegos) {
            System.out.println(fila);
        }
    }
}
