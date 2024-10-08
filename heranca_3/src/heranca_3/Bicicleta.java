package heranca_3;

//Classe Bicicleta, derivada de Veículo também possui seus próprios atributos, utilizando o this, se escolhe o que mais será usado
public class Bicicleta extends Veiculo {
 private String marca;
 private String cor;
 private String material;
 private int marchas;
 private boolean amortecedor;

 public Bicicleta(String modelo, int anoFabricacao, String marca, String cor, String material, int marchas, boolean amortecedor) {
     super(modelo, anoFabricacao);
     this.marca = marca;
     this.cor = cor;
     this.material = material;
     this.marchas = marchas;
     this.amortecedor = amortecedor;
 }
//Override sobrescreve as informações já colocadas nos tópicos, ele "atualiza" a informação já posta por outra classe para a atual classe em "evidência"
 @Override
 public void exibirDetalhes() {
     System.out.println("Bicicleta: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", Marca: " + marca + 
                        ", Cor: " + cor + ", Material: " + material + ", Marchas: " + marchas + 
                        ", Amortecedor: " + (amortecedor ? "Sim" : "Não"));
 }
}