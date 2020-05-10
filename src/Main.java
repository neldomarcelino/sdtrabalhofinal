import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        Quarto quarto = new Quarto();
        quarto.setOcupado(true);
        quarto.setNr_do_quarto(8);
        quarto.setNome_do_hotel("neldo");


        System.out.print("Enter server name: ");
        try {
            DataInputStream in = new DataInputStream(System.in);
            String servidor = in.readLine();
            cliente.inserirQuarto("neldo", quarto, servidor);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
//5 2 + 8 3 - ∗ 4 /