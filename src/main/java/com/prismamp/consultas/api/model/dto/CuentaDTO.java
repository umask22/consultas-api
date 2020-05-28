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
public class CuentaDTO extends BaseObject {
	@XmlElement
	private String numero = "0";
    
	@XmlElement
	private String tipo = "0";
	
	@XmlElement
	private String moneda = "0";
    
	@XmlElement
	private String cbu = "";
    
	@XmlElement
	private String estado = "0";
    
	@XmlElement
	private double saldo = 0;
    
	@XmlElement
	private double limite = 0;
    
	@XmlElement
	private double intereses = 0;
	
	@XmlElement
	private boolean ctaEspecial = false;
	
	@XmlElement
	private String nombreTitular;

    public CuentaDTO()
    {
    }
    
    public void setNumero(String cuenta)
    {
        this.numero = cuenta;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getTipo()
    {
        return tipo;
    }
    
	public String getMoneda()
	{
		return moneda;
	}

	public void setMoneda(String moneda)
	{
		this.moneda = moneda;
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

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public double getSaldo()
    {
        return saldo;
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
}
