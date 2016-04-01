package Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mercadoria {

	 private long codigoMercadoria;
	 private String tipoMercadoria;
	 private String nomeMercadoria;
	 private int qtdMercadoria;
	 private double precoMercadoria;
	 private String tipoNegocioMercadoria;
	 
	 @Id
	 @GeneratedValue
	public long getCodigoMercadoria() {
		return codigoMercadoria;
	}
	public void setCodigoMercadoria(long codigoMercadoria) {
		this.codigoMercadoria = codigoMercadoria;
	}
	@Column	
	public String getTipoMercadoria() {
		return tipoMercadoria;
	}
	public void setTipoMercadoria(String tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}
	@Column	
	public String getNomeMercadoria() {
		return nomeMercadoria;
	}
	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}
	@Column	
	public int getQtdMercadoria() {
		return qtdMercadoria;
	}
	public void setQtdMercadoria(int qtdMercadoria) {
		this.qtdMercadoria = qtdMercadoria;
	}
	@Column	
	public double getPrecoMercadoria() {
		return precoMercadoria;
	}
	public void setPrecoMercadoria(double precoMercadoria) {
		this.precoMercadoria = precoMercadoria;
	}
	@Column	
	public String getTipoNegocioMercadoria() {
		return tipoNegocioMercadoria;
	}
	public void setTipoNegocioMercadoria(String tipoNegocioMercadoria) {
		this.tipoNegocioMercadoria = tipoNegocioMercadoria;
	}
	 
	 
	 
}
