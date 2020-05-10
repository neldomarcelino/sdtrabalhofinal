import javax.sound.sampled.Port;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Descoberta {

    private final Map<String, String> urlMap;
    private final int PORT = 8080;

    public Descoberta(){
        urlMap = new HashMap<>();
    }

    //Procura um grupo e junta-se ao grupo.
    public String pesquisar(String nomeServidor, int timeout) {

        StringBuilder msg = new StringBuilder();
        DatagramSocket socket = null;
        DataInputStream in = null;

        try
        {
            socket = new DatagramSocket();

            // Send the request read from the keyboard
            byte[] requestString = nomeServidor.getBytes();
            InetAddress address = InetAddress.getByName("230.0.0.0");
            DatagramPacket request = new DatagramPacket(requestString, requestString.length, address, PORT);
            socket.send(request);


        }
        catch (IOException e) {
            System.out.println("Error while trying to use the socket!");
            e.printStackTrace();
            System.exit(0);
        }
        return msg.toString();
    }


    public void publicar(String nomeServidor, String URL){
        urlMap.put(nomeServidor, URL);

        DatagramSocket serverSocket;
        try {
            serverSocket = new DatagramSocket();

            System.out.println("Servidor REST aguarda pedidos");

                byte[] buffer = new byte[256];

                System.out.println("SSSSSSSSSSSSSSSSSSSSSSSAAAAAAAAAAAAAAAAAAACCCCCCCCCC");
                InetAddress group = InetAddress.getByName("230.0.0.0");
                DatagramPacket packetRecv = new DatagramPacket(buffer, buffer.length, group, PORT);

                serverSocket.receive(packetRecv);
                System.out.println("SSSSSSSSSSSSSSSDDSAAA: "+ packetRecv.getData().toString());

                String data = new String(packetRecv.getData()).trim();

                if (!urlMap.get(data).isEmpty()) {
                    buffer = urlMap.get(data).getBytes();
                } else {
                    buffer = "".getBytes();
                }

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
                serverSocket.send(packet);
                Thread.sleep(1000);

            // Handle exception
        } catch (IOException ex) {
            // Handle exception
            System.out.println("Error: " + ex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
