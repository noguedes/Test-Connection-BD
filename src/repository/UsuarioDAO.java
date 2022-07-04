package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;

	public UsuarioDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public void insert(Usuario usuario)throws SQLException{
		String sql = "insert into usuarios(id, nome, email, telefone, data) values (?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setLong(1, usuario.getId());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getEmail());
		stmt.setInt(4, usuario.getTelefone());
		stmt.setDate(5, usuario.getDate());
		
		stmt.execute();
		stmt.close();
	}
	
	public List<Usuario> select() throws SQLException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuarios";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet  rs = stmt.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("Id"));
			usuario.setNome(rs.getString("Nome"));
			usuario.setEmail(rs.getString("Email"));
			usuario.setTelefone(rs.getInt("Telefone"));
			usuario.setDate(rs.getDate("data"));
			
			usuarios.add(usuario);
		}
		
		rs.close();
		stmt.close();
		return usuarios;
	}
	
	public Usuario selectById(long id) throws SQLException{
		Usuario usuario = null;
		String sql = "select * from usuarios where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
		    usuario = new Usuario();
			usuario.setId(rs.getLong("Id"));
			usuario.setNome(rs.getString("Nome"));
			usuario.setEmail(rs.getString("Email"));
			usuario.setTelefone(rs.getInt("Telefone"));
			usuario.setDate(rs.getDate("data"));
		}
		rs.close();
		stmt.close();
		return usuario;
		
	}
	
	public void delete(long id) throws SQLException{
		String sql = "delete  from usuarios where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void update(Usuario usuario) throws SQLException{
		String sql = "update usuarios set nome=?, email=?, telefone=? where id=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setInt(3, usuario.getTelefone());
		stmt.setLong(4, usuario.getId());
		
		stmt.execute();
		stmt.close();
	}
	
	
	
	

}
