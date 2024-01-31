

public class Pedido {

    private int id;
    private String cliente;
    private String produto;
    private int valor;
    private boolean pago;
    private boolean separado;

    // Construtores, getters e setters

    public Pedido() {
    }

    public Pedido(int id, String cliente, String produto, int valor, boolean pago, boolean separado) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.valor = valor;
        this.pago = pago;
        this.separado = separado;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isSeparado() {
        return separado;
    }

    public void setSeparado(boolean separado) {
        this.separado = separado;
    }

    // toString() para exibição fácil dos pedidos
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", produto='" + produto + '\'' +
                ", valor=" + valor +
                ", pago=" + pago +
                ", separado=" + separado +
                '}';
    }
}
