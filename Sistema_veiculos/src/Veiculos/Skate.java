package Veiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Skate extends Veiculo {
    private String tipoRoda;  // Tipo de roda (por exemplo, PU, PVC, etc.)

    // Construtor da Classe
    public Skate(String modelo, int ano, String marca, String cor, double Kilometragem) {
        super(modelo, ano, marca, cor, Kilometragem);

    }
    public Skate() {
    }
    
    
    public Skate(String modelo, int ano, String marca, String cor, double Kilometragem, String tipoRoda) {
        super(modelo, ano, marca, cor, Kilometragem);
        this.tipoRoda = tipoRoda;
    }

    // Getters e Setters
    public String getTipoRoda() {
        return tipoRoda;
    }

    public void setTipoRoda(String tipoRoda) {
        this.tipoRoda = tipoRoda;
    }



public static void inserirSkate (Scanner scanner, Connection conexao) {

	  Skate skate = new Skate();

      System.out.print("Qual é o modelo do skate? ");
      skate.setModelo(scanner.nextLine());

      System.out.print("Em que ano foi fabricado? ");
      skate.setAno(scanner.nextInt());
      scanner.nextLine(); // Limpar buffer

      System.out.print("Qual é a marca? ");
      skate.setMarca(scanner.nextLine());

      System.out.print("Qual é a cor? ");
      skate.setCor(scanner.nextLine());

      System.out.print("Qual é a Kilometragem? ");
      skate.setKilometragem(scanner.nextDouble());
      scanner.nextLine(); // Limpar buffer

      System.out.print("Qual é o tipo de roda (ex: poliuretano, plástico)? ");
      skate.setTipoRoda(scanner.nextLine());


	
String sqlInserir = "INSERT INTO skate (modelo, ano_fabricacao, cor, marca, tipo_rodas) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, skate.getModelo());
            stmt.setInt(2, skate.getAno());
            stmt.setString(3, skate.getCor());
            stmt.setString(4, skate.getMarca());
            stmt.setString(5, skate.getTipoRoda());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1); // O primeiro campo é o id gerado
                    System.out.println("Skate inserido com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir skate: " + e.getMessage());
        }
    }}