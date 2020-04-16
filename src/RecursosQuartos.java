import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;


@Path("/recursoquarto")
public class RecursosQuartos {

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
        return null;
    }
    //retorna todos os quartos vazios de todos os hoteis
    //descriminado por hotel
    @GET
    @Path("/quartosvazioshoteis")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<Quarto>> quartos_vazios() {
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
    @Path("/novoquartohotel/{nome_do_hotel}/{nr_do_quarto}")
    public void novo_Quarto( @PathParam("nome_do_hotel") String nome_do_hotel, @PathParam("nr_do_quarto") String nr_do_quarto) {
        Quarto novo_quarto = new Quarto(nome_do_hotel, Integer.parseInt(nr_do_quarto), false);

        List<Quarto> newRoom = new ArrayList<>();
        newRoom.add(novo_quarto);
        hoteis.put(nome_do_hotel,newRoom);
    }
}