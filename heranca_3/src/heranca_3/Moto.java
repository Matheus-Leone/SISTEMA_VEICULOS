package heranca_3;

//Classe Moto, derivada de Veículo também possui seus próprios atributos, utilizando o this, se escolhe o que mais será usado
public class Moto extends Veiculo {
 private int cilindradas;
 private int torque;

 public Moto(String modelo, int anoFabricacao, int cilindradas, int torque) {
     super(modelo, anoFabricacao);
     this.cilindradas = cilindradas;
     this.torque = torque;
 }
 
//Override sobrescreve as informações já colocadas nos tópicos, ele "atualiza" a informação já posta por outra classe para a atual classe em "evidência"
 @Override
 public void exibirDetalhes() {
     System.out.println("Moto: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", Cilindradas: " + cilindradas + 
                        " cc, Torque: " + torque + " Nm");
 }
}
