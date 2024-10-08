package heranca_3;

//Classe Main para testar as classes
public class aMain {
 public static void main(String[] args) {
     Carro automovel = new Carro("Civic", 2020, "Honda", "Prata", 25000, 5, "ABS", true);
     Moto motocicleta = new Moto("CBR", 2019, 650, 85);
     Caminhao caminhao = new Caminhao("FH", 2021, 6, 20000);
     Bicicleta bicicleta = new Bicicleta("Mountain", 2022, "Caloi", "Vermelha", "Alumínio", 18, true);
     Skate skate = new Skate("Pro Skate", 2021, "Santa Cruz", "Azul", "Poliuretano");

     automovel.exibirDetalhes();
     motocicleta.exibirDetalhes();
     caminhao.exibirDetalhes();
     bicicleta.exibirDetalhes();
     skate.exibirDetalhes();
 }
}
