package com.prismamp.consultas.api.model.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UltimosPagosPorUsuarioDTO extends BaseObject
{
	@XmlElement
	private String tipoConsulta = " ";
	@XmlElement
    private int secuencia;
	@XmlElement
    private String timeIn = " ";
	@XmlElement
    private List<UltimoPagoInfoDTO> pagos;
	@XmlElement
    private String idOperacion = "";
	
	public UltimosPagosPorUsuarioDTO()
	{
		this.pagos = new ArrayList<UltimoPagoInfoDTO>();
	}
    
    public void addPagos(Collection value, String tipoEmpresa)
    {
        if ((tipoEmpresa != null) && tipoEmpresa.equals("R"))
        {
            for (Iterator i = value.iterator(); i.hasNext();)
            {
                UltimoPagoInfoDTO pago = (UltimoPagoInfoDTO)i.next();
                String descripcion = pago.getDescripcion();

                try
                {
                    pago.setDescripcion(descripcion.substring(0, 32).trim());
                }
                catch (Exception e)
                {
                    pago.setDescripcion(descripcion);
                }

                try
                {
                	GregorianCalendar cal = new GregorianCalendar();
                	cal.set((100 + Integer.parseInt(descripcion.substring(32, 34))),
                			Integer.parseInt(descripcion.substring(34, 36)) - 1,
                			Integer.parseInt(descripcion.substring(36, 38)));
                    pago.setVencimiento(cal.getTime());
                }
                catch (Exception e)
                {
                    pago.setVencimiento(null);
                }

                pago.setPrePago(true);
                this.pagos.add(pago);
            }
        }
        else
        {
            this.pagos.addAll(value);
        }
    }

    public void addPagos(Collection value)
    {
        this.pagos.addAll(value);
    }

    public void add(UltimoPagoInfoDTO pago)
    {
        this.pagos.add(pago);
    }
	
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public int getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}

	public List<UltimoPagoInfoDTO> getPagos() {
		return pagos;
	}

	public void setPagos(List<UltimoPagoInfoDTO> pagos) {
		this.pagos = pagos;
	}
	
	
	
}
