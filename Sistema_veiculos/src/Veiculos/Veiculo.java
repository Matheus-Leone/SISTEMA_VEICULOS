package Veiculos;

// Classe Abstrata que irá transferir seus atributos para as outras classes
public abstract class Veiculo {

    protected String modelo;
    protected int ano;
    protected String marca;
    protected String cor;
    protected double Kilometragem;

    // Construtor da classe Abstrata
    public Veiculo() {
    }

    public Veiculo(String modelo, int ano, String marca, String cor, double Kilometragem) {
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.cor = cor;
        this.Kilometragem = Kilometragem;
    }

    // Getters e Setters

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getKilometragem() {
        return Kilometragem;
    }

    public void setKilometragem(double Kilometragem) {
        this.Kilometragem = Kilometragem;
    }

    
    
    
    
}






