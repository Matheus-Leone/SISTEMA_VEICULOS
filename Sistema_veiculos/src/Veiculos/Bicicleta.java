package Veiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bicicleta extends Veiculo {

    private Long id; // A chave primária correta

    private String material;
    private int QtdMarcha;
    private String Amortecedor;

    // Construtor da Classe
    
    public Bicicleta(String modelo, int ano, String marca, String cor, double Kilometragem) {
        super(modelo, ano, marca, cor, Kilometragem);
        
    }
    
    public Bicicleta(){ 
    }
        
    public Bicicleta(String modelo, int ano, String marca, String cor, double Kilometragem, String material, int QtdMarcha, String Amortecedor) {
        super(modelo, ano, marca, cor, Kilometragem);
        
        this.material = material;
        this.QtdMarcha = QtdMarcha;
        this.Amortecedor = Amortecedor;
    }
    

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQtdMarcha() {
        return QtdMarcha;
    }

    public void setQtdMarcha(int QtdMarcha) {
        this.QtdMarcha = QtdMarcha;
    }

    public String getAmortecedor() {
        return Amortecedor;
    }

    public void setAmortecedor(String amortecedor) {
        Amortecedor = amortecedor;
    }

public static void inserirBicicleta(Scanner scanner, Connection conexao) {
	
    Bicicleta bicicleta = new Bicicleta();

    System.out.print("Qual é o modelo da bicicleta? ");
    bicicleta.setModelo(scanner.nextLine());

    System.out.print("Em que ano foi fabricada? ");
    bicicleta.setAno(scanner.nextInt());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Qual é a marca? ");
    bicicleta.setMarca(scanner.nextLine());

    System.out.print("Qual é a cor? ");
    bicicleta.setCor(scanner.nextLine());

    System.out.print("Qual é a Kilometragem? ");
    bicicleta.setKilometragem(scanner.nextDouble());
    scanner.nextLine(); // Limpar buffer

    System.out.print("Qual é o material da bicicleta (ex: alumínio, carbono)? ");
    bicicleta.setMaterial(scanner.nextLine());

    System.out.print("Quantas marchas a bicicleta possui? ");
    bicicleta.setQtdMarcha(scanner.nextInt());
    scanner.nextLine(); // Limpar buffer

    System.out.print("A bicicleta possui amortecedor?: ");
    bicicleta.setAmortecedor(scanner.nextLine());
    scanner.nextLine(); // Limpar buffer

String sqlInserir = "INSERT INTO bicicleta (modelo, ano_fabricacao, cor, marca, material, marchas, amortecedor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, bicicleta.getModelo());
            stmt.setInt(2, bicicleta.getAno());
            stmt.setString(3, bicicleta.getCor());
            stmt.setString(4, bicicleta.getMarca());
            stmt.setString(5, bicicleta.getMaterial());
            stmt.setInt(6, bicicleta.getQtdMarcha());
            stmt.setString(7, bicicleta.getAmortecedor());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Bicicleta inserida com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir bicicleta: " + e.getMessage());
        }
    }

}
