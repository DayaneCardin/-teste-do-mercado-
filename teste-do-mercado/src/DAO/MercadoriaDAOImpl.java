package DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import Entidades.Mercadoria;

public class MercadoriaDAOImpl implements MercadoriaDAO {
	@Override
	public void inserir(Mercadoria p) throws SQLException 
	{
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		
		em.close();
	}
	
	@Override
	public void remover(long id) throws SQLException {
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		Mercadoria prodAntigo = em.getReference(Mercadoria.class, id);
		em.getTransaction().begin();
			em.remove(prodAntigo);
		em.getTransaction().commit();
	
		em.close();
	}

	@Override
	public void atualizar(long id, Mercadoria p) throws SQLException {
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		Mercadoria prodAntigo = em.getReference(Mercadoria.class, id);
		em.getTransaction().begin();
	      prodAntigo.setCodigoMercadoria(p.getCodigoMercadoria());
		  prodAntigo.setNomeMercadoria( p.getNomeMercadoria() );
		  prodAntigo.setPrecoMercadoria(p.getPrecoMercadoria());
		  prodAntigo.setQtdMercadoria(p.getQtdMercadoria()) ;
		  prodAntigo.setTipoMercadoria(p.getTipoMercadoria());
		  prodAntigo.setTipoNegocioMercadoria(p.getTipoNegocioMercadoria());
		em.getTransaction().commit();
	
		em.close();
	}
	
	@Override
	public List<Mercadoria> pesquisar(String nome) throws SQLException {
		
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Mercadoria> qry = 
				em.createQuery("select p from Mercadoria p " +
						"where nomeMercadoria like :n", Mercadoria.class);
		qry.setParameter("n","%"+nome+"%");
		List<Mercadoria> Mercadorias = qry.getResultList();
		
		em.close();
		return Mercadorias;
	}
public List<Mercadoria> pesquisarPorTipo(String tipo) throws SQLException {
		
		EntityManagerFactory emf = JPAUtil.getEMF();
		EntityManager em = emf.createEntityManager();
		TypedQuery<Mercadoria> qry = 
				em.createQuery("select p from Mercadoria p " +
						"where tipoMercadoria like :n", Mercadoria.class);
		qry.setParameter("n","%"+tipo+"%");
		List<Mercadoria> Mercadorias = qry.getResultList();
		
		em.close();
		return Mercadorias;
	}

}
