import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/recursoquarto")
public class RecursosQuartos {

    List<Quarto> hotesQuarto = new ArrayList<>();

    //mapeia um hotel e seus respectivos quartos
    private final Map<String, List<Quarto>> hoteis;
    RecursosQuartos() {
        hoteis = new HashMap<>();
    }

    @GET
    public String get() {

        return "Recurso Quarto";
    }
    //retorna todos os quartos de todos hoteis

    @GET
    @Path("/todosquartohoteis")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> todos_Quartos() {
        return hotesQuarto;
    }
    //retorna todos os quartos vazios de todos os hoteis
    //descriminado por hotel
    @GET
    @Path("/quartosvazioshoteis")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<Quarto>> quartos_vazios() {

        Map<String, List<Quarto>> quartosVazios = new HashMap<>();

        for(Quarto quarto: hotesQuarto){
            List<Quarto> quartoList = hoteis.get(quarto);
        }
        return null;
    }
    //retorna os quartos de um determinado hotel
    @GET
    @Path("/quartoshotel/{nome_do_hotel}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> quartos_Do_Hotel( @PathParam("nome_do_hotel") String nome_do_hotel) {

        List<Quarto> quartoList = new ArrayList<>(hoteis.get(nome_do_hotel));
        return quartoList;
    }
    //retorna os quartos vazios de um determinado hotel
    @GET
    @Path("/quartosvazioshotel/{nome_do_hotel}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> quartos_Vazios_Do_Hotel( @PathParam("nome_do_hotel") String nome_do_hotel) {
        return null;
    }
    //insere um novo quarto num determinado hotel
    @POST
    @Consumes("text/plain")
    @Path("/novoquartohotel/{nome_do_hotel}/{nr_do_quarto}")///
    public void novo_Quarto( @PathParam("nome_do_hotel") String nome_do_hotel, @PathParam("nr_do_quarto") String nr_do_quarto) {
        System.exit(1);
        /*Quarto novo_quarto = new Quarto();


        novo_quarto.setNome_do_hotel(nome_do_hotel);
        novo_quarto.setNr_do_quarto(Integer.parseInt(nr_do_quarto));
        novo_quarto.setOcupado(false);
        hotesQuarto.add(novo_quarto);
        hoteis.put(nome_do_hotel,hotesQuarto);
        */
        Quarto quarto = new Quarto();
        quarto.setOcupado(true);
        quarto.setNr_do_quarto(3);
        quarto.setNome_do_hotel("Avenida");

        Quarto quarto1 = new Quarto();
        quarto1.setOcupado(false);
        quarto1.setNr_do_quarto(43);
        quarto1.setNome_do_hotel("Avenida");

        Quarto quarto2 = new Quarto();
        quarto2.setOcupado(true);
        quarto2.setNr_do_quarto(483);
        quarto2.setNome_do_hotel("Grande Plaza");

        hotesQuarto.add(quarto);
        hotesQuarto.add(quarto1);
        hoteis.put("Avenida", hotesQuarto);

    }
}