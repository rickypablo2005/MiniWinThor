public class Produto {

    private int codigo;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
    private  String status;

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }

    public void setPrecoDeCompra(double precoDeCompra){
        this.precoDeCompra = precoDeCompra;
    }

    public double getPrecoDeCompra(){
        return precoDeCompra;
    }

    public void setPrecoDeVenda(double precoDeVenda){
        this.precoDeVenda = precoDeVenda;
    }

    public double getPrecoDeVenda(){
        return precoDeVenda;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}