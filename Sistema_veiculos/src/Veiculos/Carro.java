package Veiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Carro extends Veiculo {

    private int maxPassageiros;
    private String tipoFreio;
    private String temAirbag;

    // Construtor da Classe
    
    public Carro(String modelo, int ano, String marca, String cor, double Kilometragem) {
        super(modelo, ano, marca, cor, Kilometragem);

    }
    public Carro() {
    }
    
    
    public Carro(String modelo, int ano, String marca, String cor, double Kilometragem, int maxPassageiros, String tipoFreio, String temAirbag) {
        super(modelo, ano, marca, cor, Kilometragem);
        this.maxPassageiros = maxPassageiros;
        this.tipoFreio = tipoFreio;
        this.temAirbag = temAirbag;
    }

    // Getters e Setters

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    public String getTemAirbag() {
        return temAirbag;
    }

    public void setTemAirbag(String temAirbag) {
        this.temAirbag = temAirbag;
    }

public static void inserirCarro (Scanner scanner, Connection conexao) {

    Carro carro = new Carro();

    System.out.print("Qual é o modelo do carro? ");
    carro.setModelo(scanner.nextLine());

    System.out.print("Em que ano foi fabricado? ");
    carro.setAno(scanner.nextInt());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Qual é a marca? ");
    carro.setMarca(scanner.nextLine());

    System.out.print("Qual é a cor? ");
    carro.setCor(scanner.nextLine());

    System.out.print("Qual é a Kilometragem? ");
    carro.setKilometragem(scanner.nextDouble());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Qual é o número máximo de passageiros? ");
    carro.setMaxPassageiros(scanner.nextInt());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Qual é o tipo de freio do carro (ex: disco, tambor)? ");
    carro.setTipoFreio(scanner.nextLine());

    System.out.print("O carro possui airbag?: ");
    carro.setTemAirbag(scanner.nextLine());
    scanner.nextLine(); // Limpar buffer                  
    	
	
	
String sqlInserir = "INSERT INTO carro (modelo, ano_fabricacao, cor, montadora, km_odometro, max_passageiros, tipo_freio, airbag) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, carro.getModelo());
            stmt.setInt(2, carro.getAno());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getMarca());
            stmt.setDouble(5, carro.getKilometragem());
            stmt.setInt(6, carro.getMaxPassageiros());
            stmt.setString(7, carro.getTipoFreio());
            stmt.setString(8, carro.getTemAirbag());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1); // O primeiro campo é o id gerado
                    System.out.println("Carro inserido com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir carro: " + e.getMessage());
        }
    }}



