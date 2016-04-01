package MBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entidades.Mercadoria;
import DAO.MercadoriaDAO;
import DAO.MercadoriaDAOImpl;

@ManagedBean
@SessionScoped

public class MercadoriaMB {
	private Mercadoria mercadoriaAtual;
	private MercadoriaDAO prodDAO;
	private List<Mercadoria> Mercadorias;

	public MercadoriaMB() {
		mercadoriaAtual = new Mercadoria();
		Mercadorias = new ArrayList<Mercadoria>();
		prodDAO = new MercadoriaDAOImpl();
	}

	public Mercadoria getmercadoriaAtual() {
		return mercadoriaAtual;
	}

	public void setmercadoriaAtual(Mercadoria mercadoriaAtual) {
		this.mercadoriaAtual = mercadoriaAtual;
	}

	public MercadoriaDAO getProdDAO() {
		return prodDAO;
	}

	public void setProdDAO(MercadoriaDAO prodDAO) {
		this.prodDAO = prodDAO;
	}

	public List<Mercadoria> getMercadorias() {
		return Mercadorias;
	}

	public void setMercadorias(List<Mercadoria> Mercadorias) {
		this.Mercadorias = Mercadorias;
	}

	public String inserir() {
		try {
			prodDAO.inserir(mercadoriaAtual);
			
			FacesContext.getCurrentInstance()
			.addMessage(null,new FacesMessage("Mercadoria cadastrado com sucesso") );	
			
			mercadoriaAtual =new Mercadoria();
					
			
		} catch (SQLException e) {
			FacesContext.getCurrentInstance()
			.addMessage(null,new FacesMessage("Mercadoria não foi cadastrado" +
					" \n consulte o administrador do sistema"));
			e.printStackTrace();
		}
		return "";
	}

	public String carregar(Mercadoria p) {
		mercadoriaAtual = p;
		return "";
	}

	public String limpar() {	
		mercadoriaAtual = new Mercadoria();
			mercadoriaAtual.setCodigoMercadoria(0);
			mercadoriaAtual.setNomeMercadoria("");
			mercadoriaAtual.setPrecoMercadoria(0);
			mercadoriaAtual.setQtdMercadoria(0);
			mercadoriaAtual.setTipoMercadoria("");
			mercadoriaAtual.setTipoNegocioMercadoria("");
		return "";
	}

	
	public String atualizar() 
	{
		try 
		{
			prodDAO.atualizar(mercadoriaAtual.getCodigoMercadoria(), mercadoriaAtual);
			FacesContext.getCurrentInstance()
			.addMessage(null,new FacesMessage("Mercadoria Atualizado com sucesso") );	
			mercadoriaAtual =new Mercadoria();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public String remover() 
	{
		try 
		 {
			prodDAO.remover(mercadoriaAtual.getCodigoMercadoria());
			
			FacesContext.getCurrentInstance()
			.addMessage(null,new FacesMessage("Mercadoria Removido com sucesso") );
			limpar();
		 }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "";
	}	
	public String pesquisar() {
		try {
			Mercadorias = prodDAO.pesquisar(mercadoriaAtual.getNomeMercadoria());
			if (Mercadorias.size() > 0) {
				mercadoriaAtual = Mercadorias.get(0);
			}	
		} catch (SQLException e) {
			 
			e.printStackTrace();	
		}
		return "";
	}
	
	public String pesquisarTodos() {
		try
		{
			Mercadorias = prodDAO.pesquisar("");
			
			FacesContext.getCurrentInstance()
			.addMessage(null,new FacesMessage("Foran encontrados :"+Mercadorias.size()) );
			 
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "";
	}
}
