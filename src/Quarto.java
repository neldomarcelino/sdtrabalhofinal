import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quarto {
    private int nr_do_quarto;
    private boolean ocupado;
    String nome_do_hotel;

    public Quarto(String nome_do_hotel, int nr_do_quarto, boolean ocupado) {
        this.nr_do_quarto = nr_do_quarto;
        this.ocupado = ocupado;
        this.nome_do_hotel = nome_do_hotel;
        System.out.println("NELDO");
    }

    public int getNr_do_quarto() {
        return nr_do_quarto;
    }

    public void setNr_do_quarto(int nr_do_quarto) {
        this.nr_do_quarto = nr_do_quarto;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNome_do_hotel() {
        return nome_do_hotel;
    }

    public void setNome_do_hotel(String nome_do_hotel) {
        this.nome_do_hotel = nome_do_hotel;
    }
}
