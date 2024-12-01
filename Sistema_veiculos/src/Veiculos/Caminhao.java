package Veiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Caminhao extends Veiculo {

    private int QtdEixo;
    private double pesoBruto;

    // Construtor da Classe
    
    public Caminhao(String modelo, int ano, String marca, String cor, double Kilometragem) {
        super(modelo, ano, marca, cor, Kilometragem);
    }
    
    public Caminhao() {
        	
    }
    
    
    public Caminhao(String modelo, int ano, String marca, String cor, double Kilometragem, int QtdEixo, double pesoBruto) {
        super(modelo, ano, marca, cor, Kilometragem);
        this.QtdEixo = QtdEixo;
        this.pesoBruto = pesoBruto;
    }

    // Getters e Setters

    public int getQtdEixo() {
        return QtdEixo;
    }

    public void setQtdEixo(int QtdEixo) {
        this.QtdEixo = QtdEixo;
    }

    public double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

public static void inserirCaminhao (Scanner scanner, Connection conexao) {
	
	  Caminhao caminhao = new Caminhao();

      System.out.print("Qual é o modelo do caminhão? ");
      caminhao.setModelo(scanner.nextLine());

      System.out.print("Em que ano foi fabricado? ");
      caminhao.setAno(scanner.nextInt());
      scanner.nextLine(); // Limpar buffer

      System.out.print("Qual é a marca? ");
      caminhao.setMarca(scanner.nextLine());

      System.out.print("Qual é a cor? ");
      caminhao.setCor(scanner.nextLine());

      System.out.print("Qual é a Kilometragem? ");
      caminhao.setKilometragem(scanner.nextDouble());
      scanner.nextLine(); // Limpar buffer

      System.out.print("Quantos eixos o caminhão possui? ");
      caminhao.setQtdEixo(scanner.nextInt());
      scanner.nextLine(); // Limpar buffer

      System.out.print("Qual é o peso bruto do caminhão (em toneladas)? ");
      caminhao.setPesoBruto(scanner.nextDouble());
      scanner.nextLine(); // Limpar buffer

	
String sqlInserir = "INSERT INTO caminhao (modelo, ano_fabricacao, cor, montadora, km_odometro, eixos, peso_bruto) VALUES (?, ?, ?, ?, ?, ?, ?)";
try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
    stmt.setString(1, caminhao.getModelo());
    stmt.setInt(2, caminhao.getAno());
    stmt.setString(3, caminhao.getCor());
    stmt.setString(4, caminhao.getMarca());
    stmt.setDouble(5, caminhao.getKilometragem());
    stmt.setInt(6, caminhao.getQtdEixo());
    stmt.setDouble(7, caminhao.getPesoBruto());
    stmt.executeUpdate();

    try (ResultSet rs = stmt.getGeneratedKeys()) {
        if (rs.next()) {
            int idGerado = rs.getInt(1); // O primeiro campo é o id gerado
            System.out.println("Caminhão inserido com sucesso! ID gerado: " + idGerado);
        }
    }
} catch (SQLException e) {
    System.out.println("Erro ao inserir caminhão: " + e.getMessage());
    
}}


}






