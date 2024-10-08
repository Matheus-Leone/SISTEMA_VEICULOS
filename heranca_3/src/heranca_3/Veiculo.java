package heranca_3;

// SuperClasse que irá passar seus Atributos para outras classes
//Abstract é utilizado para outras Classes Herdarem dessa classe, pois ela não se "faz sozinha"
public abstract class Veiculo {
    private String modelo;
    private int anoFabricacao;

    public Veiculo(String modelo, int anoFabricacao) {
        setModelo(modelo);
        setAnoFabricacao(anoFabricacao);
    }
    
//Get e Set para puxar informações quando necessário
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio.");
        }
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        if (anoFabricacao <= 0) {
            throw new IllegalArgumentException("Ano de fabricação inválido.");
        }
        this.anoFabricacao = anoFabricacao;
    }

    public abstract void exibirDetalhes();
}



