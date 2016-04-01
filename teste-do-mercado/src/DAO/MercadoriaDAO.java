package DAO;

import java.sql.SQLException;
import java.util.List;
import Entidades.Mercadoria;

public interface MercadoriaDAO {
	public void inserir(Mercadoria p) throws SQLException;
	public void remover(long id) throws SQLException;
	public void atualizar(long id, Mercadoria p) throws SQLException;
	public List<Mercadoria> pesquisar(String nome) throws SQLException;
}
