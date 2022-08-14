import java.net.*;
import java.util.*;

public class ClienteUDP {

    public static void main(String args[]) throws Exception {
		
		DatagramSocket tomada = new DatagramSocket();
        
		/////////Entrada de dados do cliente
        System.out.print("Digite uma mensagem:");
        Scanner teclado = new Scanner(System.in);
        String mensagem = teclado.nextLine();
        
		/////////Código PARA ENVIAR UMA MENSAGEM PARA O SERVIDOR
        String mensagString = "Testando..."; //enviar a mensagem
        byte[] cartaAEnviar = new byte[100]; //Carta
        cartaAEnviar = mensagem.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1"); //endereço de ip
        DatagramPacket envelopeAEnviar
                = new DatagramPacket(cartaAEnviar,
                        cartaAEnviar.length,
                        ip,
                        10008); //carta, tamanho da mensagem na carta, o ip e a porta
        tomada.send(envelopeAEnviar); //Enviar carta

        ////////Código PARA RECEBER UMA MENSAGEM DE RESPOSTA DO SERVIDOR
        byte[] cartaAReceber = new byte[100];
        DatagramPacket envelopeAReceber
                = new DatagramPacket(cartaAReceber,
                        cartaAReceber.length);
        tomada.receive(envelopeAReceber); //Carta recebida, tamanho da mensagem na carta e receber a conexão
        
        String mensagemRecebida = new String(envelopeAReceber.getData());
        System.out.println("CHEGOU DO SERVIDOR:" + mensagemRecebida);

        //SE Não TIVER MAIS NADA PARA FAZER
        //finaliza a conexÃ£o
        tomada.close();
    }
}

