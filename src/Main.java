import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Cliente cliente = new Cliente();

        Quarto quarto = new Quarto();
        quarto.setOcupado(true);
        quarto.setNr_do_quarto(8);
        quarto.setNome_do_hotel("neldo");


        cliente.inserirQuarto("neldo",quarto,"aissaussene");
        
    }

}
//5 2 + 8 3 - ∗ 4 /