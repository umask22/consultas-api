package com.prismamp.consultas.api.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO extends BaseObject {
	@XmlElement
	private String number = "0";
    
	@XmlElement
	private String type = "0";
	
	@XmlElement
	private String currency = "0";
    
	@XmlElement
	private String cbu = "";
    
	@XmlElement
	private String estado = "0";
    
	@XmlElement
	private double amount = 0;
    
	@XmlElement
	private double limite = 0;
    
	@XmlElement
	private double intereses = 0;
	
	@XmlElement
	private boolean ctaEspecial = false;
	
	@XmlElement
	private String nombreTitular;

    public AccountDTO()
    {
    }
    
    

	public String getCbu()
	{
		return cbu;
	}

	public void setCbu(String cbu)
	{
		this.cbu = cbu;
	}
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getEstado()
    {
        return estado;
    }

       public void setLimite(double limite)
    {
        this.limite = limite;
    }

    public double getLimite()
    {
        return limite;
    }

    public void setIntereses(double intereses)
    {
        this.intereses = intereses;
    }

    public double getIntereses()
    {
        return intereses;
    }

	public boolean isCtaEspecial()
	{
		return ctaEspecial;
	}

	public void setCtaEspecial(boolean ctaEspecial)
	{
		this.ctaEspecial = ctaEspecial;
	}

	public String getNombreTitular()
	{
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular)
	{
		this.nombreTitular = nombreTitular;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
