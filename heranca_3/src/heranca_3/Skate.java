package heranca_3;

//Classe Skate, derivada de Veículo também possui seus próprios atributos, utilizando o this, se escolhe o que será usado
public class Skate extends Veiculo {
 private String marca;
 private String cor;
 private String tipoRoda;

 public Skate(String modelo, int anoFabricacao, String marca, String cor, String tipoRoda) {
     super(modelo, anoFabricacao);
     this.marca = marca;
     this.cor = cor;
     this.tipoRoda = tipoRoda;
 }
//Override sobrescreve as informações já colocadas nos tópicos, ele "atualiza" a informação já posta por outra classe para a atual classe em "evidência"
 @Override
 public void exibirDetalhes() {
     System.out.println("Skate: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", Marca: " + marca + 
                        ", Cor: " + cor + ", Tipo de Roda: " + tipoRoda);
 }
}
