package heranca_3;

//Classe Caminhão, derivada de Veículo também possui seus próprios atributos, utilizando o this, se escolhe o que mais será  usado
public class Caminhao extends Veiculo {
 private int eixos;
 private int pesoBruto;

 public Caminhao(String modelo, int anoFabricacao, int eixos, int pesoBruto) {
     super(modelo, anoFabricacao);
     this.eixos = eixos;
     this.pesoBruto = pesoBruto;
 }
 
//Override sobrescreve as informações já colocadas nos tópicos, ele "atualiza" a informação já posta por outra classe para a atual classe em "evidência"
 @Override
 public void exibirDetalhes() {
     System.out.println("Caminhão: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", Eixos: " + eixos + 
                        ", Peso Bruto: " + pesoBruto + " kg");
 }
}

