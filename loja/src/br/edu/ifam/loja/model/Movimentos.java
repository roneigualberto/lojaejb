package br.edu.ifam.loja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="movimentos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movimentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="movimento")
	private List<Movimento> movimentos=new ArrayList<Movimento>();
	
	public Movimentos() {
	}

	public Movimentos(List<Movimento> movimentos) {
		super();
		this.movimentos = movimentos;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	
	
}
