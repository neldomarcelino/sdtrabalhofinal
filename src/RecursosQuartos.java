import java.util.*;
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
        List<Quarto> quartoList = new ArrayList<>();
        Map<String, List<Quarto>> stringListMap = new HashMap<>();

        hotesQuarto.sort(Comparator.comparing(Quarto::getNome_do_hotel));
        /*
        * Aeldo
        * Aeldo
        * Dario
        * Missa 1
        * Missa 0
        * Missa 1
        * Nulce
        * */

        String nome_hotel = "";
        for(Quarto quarto: hotesQuarto){
            String nomeAux = "";

            if(nome_hotel.equals("")){
                List<Quarto> quartoList1 = new ArrayList<>();
                if(!quarto.isOcupado()) {
                    quartoList1.add(quarto);
                    stringListMap.put(quarto.getNome_do_hotel(), quartoList1);
                    nomeAux = quarto.getNome_do_hotel();
                    nome_hotel = quarto.nome_do_hotel;
                }
            }else{
                if(!quarto.isOcupado()) {
                    stringListMap.get(nome_hotel).add(quarto);
                }
            }

            if(!nomeAux.equals(nome_hotel)){
                nome_hotel = "";
            }

        }

        return stringListMap;
    }
    //retorna os quartos de um determinado hotel
    @GET
    @Path("/quartoshotel/{nome_do_hotel}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> quartos_Do_Hotel( @PathParam("nome_do_hotel") String nome_do_hotel) {
        return hoteis.get(nome_do_hotel);
    }
    //retorna os quartos vazios de um determinado hotel
    @GET
    @Path("/quartosvazioshotel/{nome_do_hotel}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quarto> quartos_Vazios_Do_Hotel( @PathParam("nome_do_hotel") String nome_do_hotel) {
        List<Quarto> quartoList = new ArrayList<>();
        for(Quarto quarto: hoteis.get(nome_do_hotel)){
            if(!quarto.isOcupado()){
                quartoList.add(quarto);
            }
        }
        return quartoList;
    }

    //insere um novo quarto num determinado hotel
    @POST
    @Path("/novoquartohotel/{nome_do_hotel}/{nr_do_quarto}")
    public String novo_Quarto( @PathParam("nome_do_hotel") String nome_do_hotel, @PathParam("nr_do_quarto") String nr_do_quarto) {

        Quarto quarto1 = new Quarto();
        quarto1.setNome_do_hotel(nome_do_hotel);
        quarto1.setNr_do_quarto(Integer.parseInt(nr_do_quarto));

        if(hoteis.get(nome_do_hotel) != null){
            hoteis.get(nome_do_hotel).add(quarto1);

        }else{

            List<Quarto> quartoList = new ArrayList<>();

            quartoList.add(quarto1);

            hoteis.put(nome_do_hotel, quartoList);
        }
        hotesQuarto.add(quarto1);

        return "Adicionado Novo quarto no: " + nome_do_hotel;
    }
}