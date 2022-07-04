package testes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Usuario;
import repository.UsuarioDAO;

public class TestCrud {

	public static void main(String[] args) throws SQLException {
		
		Calendar hoje = Calendar.getInstance();
		Date data = new Date(hoje.getTimeInMillis());
		
		Usuario Arthur = new Usuario();

		Arthur.setId(1);
		Arthur.setNome("Arthur");
		Arthur.setEmail("arthur@hotmail.com");
		Arthur.setTelefone(895974);
		Arthur.setDate(data);
		
		Usuario Julio = new Usuario();
		Julio.setId(2);
		Julio.setNome("Julio");
		Julio.setEmail("julio@hotmail.com");
		Julio.setTelefone(956374885);
		Julio.setDate(data);
		
		
		UsuarioDAO DAO = new UsuarioDAO();
		
		DAO.update(Julio);
		
		
		
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = DAO.select();
		
		for(Usuario nome: usuarios) {
			System.out.println("Nome: " + nome.getNome() );
		}
		
		
	}

}
