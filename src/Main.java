import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class Main {
    public static void main(String[] args) {


        RestTemplate restTemplate = new RestTemplate();

        int contador = 0;

        // Gerar e enviar 100 eventos aleatórios
        for (int i = 0; i < 100; i++) {
            try {
                Pedido pedido = gerarPedidoAleatorio();
                String url = "http://localhost:8082/api/salva-pedido";

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<Pedido> requestEntity = new HttpEntity<>(pedido, headers);

                Gson gson = new Gson();
                String pedidoJson = gson.toJson(pedido);

                restTemplate.postForObject(url, requestEntity, String.class);
                System.out.println("Pedido enviado: " + pedido + "; Contador = "+contador);
                contador++;
            } catch (RestClientException e) {
                System.err.println("Erro ao enviar o pedido: " + e.getMessage());
            }
        }
        System.out.println("Quantidade = "+contador);


    }

    private static Pedido gerarPedidoAleatorio() {
        Pedido pedido = new Pedido();
        pedido.setId(gerarValorAleatorio());
        pedido.setCliente(gerarClienteAleatorio());
        pedido.setProduto(gerarProdutoAleatorio());
        pedido.setValor(gerarValorAleatorio());
        pedido.setPago(false);
        pedido.setSeparado(false);
        return pedido;
    }

    private static String gerarProdutoAleatorio() {
        String[] produtos = {"Corda", "Papel", "Caneta", "Livro", "Chaveiro", "Iphone", "PS5", "Xbox X", "Nintendo Switch"};
        return produtos[(int) (Math.random() * produtos.length)];
    }

    private static String gerarClienteAleatorio() {
        String[] produtos = {"1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999", "1010"};
        return produtos[(int) (Math.random() * produtos.length)];
    }

    private static int gerarValorAleatorio() {
        Random random = new Random();

        return random.nextInt(1000000) + 1;
    }

}