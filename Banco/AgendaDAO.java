package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import AgendaCRUD.Agenda;

public class AgendaDAO {
    private Connection con;
    
    public AgendaDAO(){
        this.con = ConexaoDB.conectar();
    }
    
    public List<Agenda> consultarContatos(){
        
        String sql = "SELECT * FROM contatos";
        ResultSet rs = null;
        List<Agenda> contatos = new ArrayList();
            
        try{
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Agenda agenda = new Agenda();

                agenda.setId(rs.getInt("id"));
                agenda.setNome(rs.getString("nome"));
                agenda.setSobrenome(rs.getString("sobrenome"));
                agenda.setNascimento(rs.getString("nascimento"));
                agenda.setEmail(rs.getString("email"));
                agenda.setRotuloEmail(rs.getString("rotuloemail"));
                agenda.setTelefone(rs.getString("telefone"));
                agenda.setRotuloTelefone(rs.getString("rotulotelefone"));
                
                contatos.add(agenda);
            }
            
        }catch(SQLException ex){
            System.out.println("Deu ruim");
            ex.printStackTrace();
        }
        
        return contatos;
    }
    
    public List<Agenda> consultarContatoId(String id){
        String sql = "SELECT * FROM contatos where id = '"+id+"';";
        
        List<Agenda> contatos = new ArrayList();
        try{
        
            Statement stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                
                Agenda agenda = new Agenda();
                
                agenda.setId(rs.getInt("id"));
                agenda.setNome(rs.getString("nome"));
                agenda.setSobrenome(rs.getString("sobrenome"));
                agenda.setNascimento(rs.getString("nascimento"));
                agenda.setEmail(rs.getString("email"));
                agenda.setRotuloEmail(rs.getString("rotuloemail"));
                agenda.setTelefone(rs.getString("telefone"));
                agenda.setRotuloTelefone(rs.getString("rotulotelefone"));
                
                contatos.add(agenda);
            }
        }catch(SQLException ex){
            System.out.println("Deu ruim");
            ex.printStackTrace();
        }
        
        return contatos;
    }
    
    public List<Agenda> consultarContatosPorNome(String nome){        
        String sql = "select * from contatos where nome like '%" + nome + "%';";
        
        List<Agenda> contatos = new ArrayList();
        try{
            Statement stm = con.createStatement();            
            
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()){
                 
                Agenda agenda = new Agenda();
                
                agenda.setId(rs.getInt("id"));
                agenda.setNome(rs.getString("nome"));
                agenda.setSobrenome(rs.getString("sobrenome"));
                agenda.setNascimento(rs.getString("nascimento"));
                agenda.setEmail(rs.getString("email"));
                agenda.setRotuloEmail(rs.getString("rotuloemail"));
                agenda.setTelefone(rs.getString("telefone"));
                agenda.setRotuloTelefone(rs.getString("rotulotelefone"));
                
                contatos.add(agenda);
            }
            
        }catch(SQLException ex){
            System.out.println("Erro na consulta dos contatos.");
            ex.printStackTrace();
        }
        
        return contatos;
    }
    
    public void atualizar(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET nome=?, sobrenome = ?, nascimento = ?, email = ?, rotuloemail = ?, telefone = ?, rotulotelefone = ? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getNome());
            pstmt.setString(2, agenda.getSobrenome());
            pstmt.setString(3, agenda.getNascimento());
            pstmt.setString(4, agenda.getEmail());
            pstmt.setString(5, agenda.getRotuloEmail());
            pstmt.setString(6, agenda.getTelefone());
            pstmt.setString(7, agenda.getRotuloTelefone());       
            pstmt.setInt(8, agenda.getId());
                            
            pstmt.execute();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }   
    
    public void inserir(Agenda agenda){
        try{
            String sql = "INSERT INTO contatos(nome,sobrenome,nascimento,email,rotuloemail,telefone,rotulotelefone) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getNome());
            pstmt.setString(2, agenda.getSobrenome());
            pstmt.setString(3, agenda.getNascimento());
            pstmt.setString(4, agenda.getEmail());
            pstmt.setString(5, agenda.getRotuloEmail());
            pstmt.setString(6, agenda.getTelefone());
            pstmt.setString(7, agenda.getRotuloTelefone());  
            
            pstmt.execute();
            
            
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
            ex.printStackTrace();
        }
    }
    
    public void remover(int id){
        try{
            String sql = "delete from contatos where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);                     
            pstmt.setInt(1,id);            
            pstmt.execute();
        } catch (SQLException ex) {
            System.out.println("Deu ruim em remover os dados");
        }
    }
    
    public void atualizarNome(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET nome=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getNome());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }  
    
    public void atualizarSobrenome(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET sobrenome=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getSobrenome());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }  
    
     public void atualizarEmail(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET email=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getEmail());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }
     
    public void atualizarRotEmail(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET rotuloemail=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getRotuloEmail());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }
    
    public void atualizarTelefone(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET telefone=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getTelefone());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }
    
    public void atualizarRotTelefone(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET rotulotelefone=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getRotuloTelefone());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }
    
    public void atualizarNascimento(Agenda agenda){
        try{
            String sql = "UPDATE contatos SET nascimento=? where id = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, agenda.getNascimento());
            pstmt.setInt(2, agenda.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Deu ruim nos dados");
        }
    }
}
