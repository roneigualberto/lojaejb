package br.edu.ifam.loja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.edu.ifam.loja.adapter.DateAdapter;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute(name="id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	@XmlAttribute(name="tipo")
	private TipoMovimento tipo;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	@XmlJavaTypeAdapter(value=DateAdapter.class)
	@XmlAttribute(name="dt_movimento")
	private Calendar dtMovimento = Calendar.getInstance();

	@OneToMany(mappedBy = "movimento",fetch=FetchType.EAGER)
	@XmlElementWrapper
	@XmlElement(name="item")
	private List<Item> itens = new ArrayList<Item>();

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public Calendar getDtMovimento() {
		return dtMovimento;
	}

	public void setDtMovimento(Calendar dtMovimento) {
		this.dtMovimento = dtMovimento;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void addItem(Item item) {

		this.itens.add(item);
	}

	public void removeItem(Item item) {

		this.itens.add(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	

}
