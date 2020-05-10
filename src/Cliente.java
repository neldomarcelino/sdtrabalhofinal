import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class Cliente {
    public Cliente() {

    }

    // este método insere um novo quarto
    public void inserirQuarto(String hotel, Quarto quarto, String nomeServidor) {
        String urlservidor = pesquisarServidor(nomeServidor);
        if (urlservidor != null) {

            Response response = this.alvo(urlservidor).path(hotel).path(quarto.getNumero_do_Quarto()+"").request()
                    .post(Entity.entity(quarto, MediaType.APPLICATION_JSON));
            System.out.println("Resposta do servidor: " + response.getStatus());
        } else {
            System.out.print("O Servidor não existe\n");
        }
    }

    // este método cria um cliente REST
    private Client cliente() {
        ClientConfig config = new ClientConfig();
        return ClientBuilder.newClient(config);
    }

    // este método busca o sevidor alvo
    private WebTarget alvo(String urlservidor) {
        return cliente().target(urlservidor);
    }

    // este método pesquisa servidor
    private String pesquisarServidor(String nomeServidor) {
        return new Descoberta().pesquisar(nomeServidor, 4000);
    }
    // The actual server
    private void run() {
        DatagramSocket socket = null;
        DataInputStream in = null;

        try {
            socket = new DatagramSocket();

            System.out.println("Enter data to send to server. Write sair to Quit.");
            in = new DataInputStream(System.in);

            String line ="";
            while (!line.equals("sair")) {
                line = in.readLine();
                // Send the request read from the keyboard
                byte[] requestString = line.getBytes();
                DatagramPacket request = new DatagramPacket(requestString, requestString.length);
                socket.send(request);

                /*
                 * AQUI!!!! Colocar o codigo para receber a resposta e imprimir!
                */
            }
        }
        catch (IOException e) {
            System.out.println("Error while trying to use the socket!");
            e.printStackTrace();
            System.exit(0);
        }
    }

}