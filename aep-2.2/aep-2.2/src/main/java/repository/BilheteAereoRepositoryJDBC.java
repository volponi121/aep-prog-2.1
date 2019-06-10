package repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectjdbc.Connect;
import model.BilheteAereo;

public class BilheteAereoRepositoryJDBC implements BilheteAereoRepository {
	// @Autowired
	// private BilheteAereoRepositoryMemoria repoMemoria;

	@Override
	public void inserir(BilheteAereo b) throws Exception {
		String sql = "insert into pessoa (id, nome, nascimento) values (?,?,?)";

		PreparedStatement statement = Connect.criarConexao().prepareStatement(sql);
		statement.setInt(1, b.getId());
		statement.setInt(2, b.getVoo());
		statement.setString(3, b.getOrigem());
		;
		statement.setString(4, b.getDestino());
		;
		statement.setDate(3, new java.sql.Date(b.getData().getDate()));

		statement.execute();
		statement.close();
	}

	@Override
	public List<BilheteAereo> obterTodos() throws Exception {
		List<BilheteAereo> retorno = new ArrayList<>();

		String sql = "select * from pessoa";
		Statement statement = Connect.criarConexao().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			Integer voo = resultSet.getInt("voo");
			String origem = resultSet.getString("origem");
			String destino = resultSet.getString("destino");
			Date nascimento = (Date) new java.util.Date(resultSet.getDate("data").getTime());

			BilheteAereo recuperado = new BilheteAereo(id, voo, origem, destino, nascimento);
			retorno.add(recuperado);
		}
		resultSet.close();
		statement.close();

		return retorno;
	}

	@Override
	public void alterar(BilheteAereo b) throws Exception {
		String sql = "update BilheteAereo set voo = ?,  origem = ?, destino = ? where id = ?";

		PreparedStatement statement = Connect.criarConexao().prepareStatement(sql);
		statement.setInt(1, b.getVoo());
		statement.setString(2, b.getOrigem());
		statement.setString(3, b.getDestino());
		statement.setInt(4, b.getId());

		statement.execute();
		statement.close();

	}

	@Override
	public void excluir(BilheteAereo bilhete) throws Exception {
		String sql = "delete from pessoa where id = ?";
		PreparedStatement statement = Connect.criarConexao().prepareStatement(sql);
		statement.setInt(1, bilhete.getId());
		
		statement.execute(sql);
		statement.close();

	}

}
