package heranca_3;

//Classe Carro, derivada de Veículo também possui seus próprios atributos, utilizando o this, se escolhe o que será usado
public class Carro extends Veiculo {
 private String montadora;
 private String cor;
 private int kilometragem;
 private int maxPassageiros;
 private String tipoFreio;
 private boolean airbag;

 public Carro(String modelo, int anoFabricacao, String montadora, String cor, int kilometragem,
                  int maxPassageiros, String tipoFreio, boolean airbag) {
     super(modelo, anoFabricacao);
     this.montadora = montadora;
     this.cor = cor;
     this.kilometragem = kilometragem;
     this.maxPassageiros = maxPassageiros;
     this.tipoFreio = tipoFreio;
     this.airbag = airbag;
 }
//Override sobrescreve as informações já colocadas nos tópicos, ele "atualiza" a informação já posta por outra classe para a atual classe em "evidência"
 @Override
 public void exibirDetalhes() {
     System.out.println("Automóvel: " + getModelo() + ", Ano: " + getAnoFabricacao() + ", Montadora: " + montadora +
                        ", Cor: " + cor + ", Kilometragem: " + kilometragem + " km, Max Passageiros: " + maxPassageiros +
                        ", Tipo de Freio: " + tipoFreio + ", Airbag: " + (airbag ? "Sim" : "Não"));
 }
}
