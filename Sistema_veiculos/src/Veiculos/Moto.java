package Veiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Moto extends Veiculo {

    private int cilindradas ; 
    private int torque; 	
	
	//Construtor da Classe
    
    public Moto(String modelo, int ano, String marca, String cor, double Kilometragem) {
        super(modelo, ano, marca, cor, Kilometragem);
    }
    
    public Moto() {
    }
    
    public Moto(String modelo, int ano, String marca, String cor, double Kilometragem, int cilindradas , int torque) {
        super(modelo, ano, marca, cor, Kilometragem);
        this.cilindradas  = cilindradas ;
        this.torque = torque;
    }


    // Getters and Setters
    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }


public static void inserirMoto(Scanner scanner, Connection conexao) {

    Moto moto = new Moto();

    System.out.print("Qual é o modelo da moto? ");
    moto.setModelo(scanner.nextLine());

    System.out.print("Em que ano foi fabricada? ");
    moto.setAno(scanner.nextInt());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Qual é a marca? ");
    moto.setMarca(scanner.nextLine());

    System.out.print("Qual é a cor? ");
    moto.setCor(scanner.nextLine());

    System.out.print("Qual é a Kilometragem? ");
    moto.setKilometragem(scanner.nextDouble());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Quantas cilindradas? ");
    moto.setCilindradas(scanner.nextInt());

    System.out.print("Qual é o torque (Nm)? ");
    moto.setTorque(scanner.nextInt());
    scanner.nextLine(); // Limpar buffer
    
    
String sqlInserir = "INSERT INTO motocicleta (modelo, ano_fabricacao, cor, montadora, km_odometro, cilindrada, torque) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, moto.getModelo());
            stmt.setInt(2, moto.getAno());
            stmt.setString(3, moto.getCor());
            stmt.setString(4, moto.getMarca());
            stmt.setDouble(5, moto.getKilometragem());
            stmt.setInt(6, moto.getCilindradas());
            stmt.setInt(7, moto.getTorque());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Motocicleta inserida com sucesso. ID: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir motocicleta: " + e.getMessage());
        }
    }

}