import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class carrinho {
    private ArrayList <cliente> listaDeClientes;
    private ArrayList <produtos> produtosAdicionadosCarrinho;
    private double total;

    public carrinho (){
        this.listaDeClientes = new ArrayList<cliente>();
        this.produtosAdicionadosCarrinho = new ArrayList<>();
    }


    public void addCliente (cliente cliente){
        listaDeClientes.add(cliente);
    }

    public boolean addProdutoAoCarrinho (cliente cliente, produtos produto){
        Random random = new Random();
        boolean verificaQtdProduto = false;
        produtosAdicionadosCarrinho.add(produto);
        produto.setEstoqueProduto(produto.getEstoqueProduto()-1);
        if (produto.getEstoqueProduto() == 0) {
            return verificaQtdProduto = false;
        }
        else{
            produto.setIdProduto(random.nextInt(100));
            System.out.println(produto.getIdProduto());
            return verificaQtdProduto = true;

        }
        
    
    }

    public double finalizarCompra (cliente cliente){
        

        if (produtosAdicionadosCarrinho == null) {
            return 0;
        }
        else{
            for (produtos p: produtosAdicionadosCarrinho){
                total += p.getprecoProduto()/2; 
                LocalDateTime  agora =  LocalDateTime.now(); 
                
                
                 OffsetDateTime tempo = OffsetDateTime.now(ZoneOffset.ofHours(2));
                 System.out.println(""+tempo);
            }
            
           
            return total;
            
            
        }
    }

    public int rastrearProduto(produtos i,int codProduto){
        if(i.getIdProduto() == codProduto){
            return 1;
        }
        else{
            return 0;
        }
    }
}
