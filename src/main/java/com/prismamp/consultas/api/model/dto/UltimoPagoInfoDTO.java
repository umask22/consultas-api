package com.prismamp.consultas.api.model.dto;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase contiene la informacion de un pago realizado
 *
 */
public class UltimoPagoInfoDTO implements java.io.Serializable, Comparable<UltimoPagoInfoDTO>
{
	private static final long serialVersionUID = -7939299906324835064L;

	/**
     * Identificacion de la empresa.
     */
    private String corpId;

    /**
     * Leyenda de pago
     */
    private String leyenda;

    /**
     * Fecha de pago.
     */
    private Date fechaPago;

    /**
     * Monto de pago.
     */
    private double importe;

    /**
     * Identificacion de la deuda
     */
    private String idCliente;

    /**
     * Cuenta de pago.
     */
    private AccountDTO cuenta;

    /**
     * Numero de Transaccion
     */
    private String nroTransac;

    /**
     * Numero de control
     */
    private String nroControl;

    /**
     * Moneda de pago
     */
    private int moneda;

    /**
     * Descripcion del recibo
     */
    private String descripcion;

    /**
     * Aplicacion Origen
     */
    private String canal;

    /**
     * Fiid del Banco
     */
    private String fiid;

    /**
     * Bandera que indica si fue realizada on-line.
     */
    private boolean hostOnLine;

    /**
     * Periodo de pago
     */
    private String periodo;

    /**
     * Identificacion del idelanto.
     */
    private String idAnticipo;

    /**
     * Fecha de vencimiento
     */
    private Date vencimiento;

    /**
     * Indica si es un prepago.
     */
    private boolean prePago;

    /**
     * Cuit del Empleador para pago de Domesticas
     * 
     */
    private String cuitEmpleador;
    
    private boolean anulado = false;
    
    /* Getters */
    public String getCorpId()
    {
        return corpId;
    }

    public String getLeyenda()
    {
        return leyenda;
    }

    public Date getFechaPago()
    {
        return fechaPago;
    }

    public double getImporte()
    {
        return importe;
    }

    public String getIdCliente()
    {
        return idCliente;
    }

    public AccountDTO getCuenta()
    {
        return cuenta;
    }

    public String getNroTransac()
    {
        return nroTransac;
    }

    public String getNroTransacTicket()
    {
        String aux = null;

        try
        {
            if (canal.equals("C"))
            {
                aux = nroTransac.substring(0, 4);
            }
            else
            {
                aux = nroTransac.substring(6, 10);
            }
        }
        catch (Exception e)
        {
            aux = "0000";
        }

        return aux;
    }

    public String getNroControl()
    {
        return nroControl;
    }

    public int getMoneda()
    {
        return moneda;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public String getCanal()
    {
        return canal;
    }

    public String getFiid()
    {
        return fiid;
    }

    public boolean isHostOnLine()
    {
        return hostOnLine;
    }

    public String getPeriodo()
    {
        return periodo;
    }

    public String getIdAnticipo()
    {
        return idAnticipo;
    }

    public boolean isPrePago()
    {
        return prePago;
    }
    
    public String getCuitEmpleador(){
    	return cuitEmpleador;
    }

    /* Setters */
    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }

    public void setLeyenda(String leyenda)
    {
        this.leyenda = leyenda;
    }

    public void setFechaPago(Date fechaPago)
    {
        this.fechaPago = fechaPago;
    }

    public void setImporte(double importe)
    {
        this.importe = importe;
    }

    public void setIdCliente(String idCliente)
    {
        this.idCliente = idCliente;
    }

    public void setCuenta(AccountDTO cuenta)
    {
        this.cuenta = cuenta;
    }

    public void setNroTransac(String nroTransac)
    {
        this.nroTransac = nroTransac;
    }

    public void setNroControl(String nroControl)
    {
        this.nroControl = nroControl;
    }

    public void setMoneda(int moneda)
    {
        this.moneda = moneda;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setCanal(String canal)
    {
        this.canal = canal;
    }

    public void setFiid(String fiid)
    {
        this.fiid = fiid;
    }

    public void setHostOnLine(boolean hostOnLine)
    {
        this.hostOnLine = hostOnLine;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }

    public void setIdAnticipo(String idAnticipo)
    {
        this.idAnticipo = idAnticipo;
    }

    public Date getVencimiento()
    {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento)
    {
        this.vencimiento = vencimiento;
    }

    public void setPrePago(boolean prePago)
    {
        this.prePago = prePago;
    }

    public void setCuitEmpleador(String cuitEmpleador)
    {
    	this.cuitEmpleador = cuitEmpleador;
    }
    
    public boolean isAnulado() {
    	return anulado;
    }
    
    public void setAnulado(boolean anulado) {
    	this.anulado = anulado;
    }

    /* Metodos */

    /**
     * Devuelve un String que identifica univocamente el pago.
     */
    public String getFirm()
    {
        StringBuffer sb = new StringBuffer();

        sb.append(getCorpId());
        sb.append("_");
        sb.append(getIdCliente());
        sb.append("_");
        sb.append(getMoneda());
        sb.append("_");
        sb.append(formatAmount(getImporte()).replace('.', '_').replace(',', '_').trim());
        sb.append("_");
        sb.append(getNroTransac());
        sb.append("_");
        sb.append(getNroControl());

        if (getFechaPago() != null)
        {
            sb.append("_");
            sb.append(toYYYYMMDD(getFechaPago()));
        }

        if (getDescripcion() != null)
        {
            sb.append("_");
            sb.append(getDescripcion().trim());
        }

        if (getLeyenda() != null)
        {
            sb.append("_");
            sb.append(getLeyenda().trim());
        }

        if (getPeriodo() != null)
        {
            sb.append("_");
            sb.append(getPeriodo().trim());
        }

        if (getIdAnticipo() != null)
        {
            sb.append("_");
            sb.append(getIdAnticipo().trim());
        }

        return sb.toString().replace('/', '_').replace(' ', '_').replace('.', '_');
    }

    /**
     * Para ordenarlo por fecha descendente.
     */
    public int compareTo(UltimoPagoInfoDTO p)
    {
        int ret = 0;

        if (getFechaPago().before(p.getFechaPago()))
        {
            ret = 1;
        }
        else if (getFechaPago().after(p.getFechaPago()))
        {
            ret = -1;
        }

        return ret;
    }
    
    private final String toYYYYMMDD(final java.util.Date date)
    {
    	SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd");
        return day.format(date);
    }
    
    private static String formatAmount(final double amount)
    {
        return formatAmount(amount, false);
    }
    
    public static String formatAmount(final double amount, boolean p)
    {
    	DecimalFormat amountFormat = new DecimalFormat("###,###,##0.00");
    	DecimalFormat amountFormatSinComa = new DecimalFormat("########0.00");
        char[] tmp;

        if ( p )
        {
            tmp = amountFormatSinComa.format(amount).toCharArray();
        }
        else
        {
            tmp = amountFormat.format(amount).toCharArray();
        }

        for ( int i = 0; i < tmp.length; i++ )
        {
            if ( tmp[ i ] == '.' )
            {
                tmp[ i ] = ',';
            }
            else if ( tmp[ i ] == ',' )
            {
                tmp[ i ] = '.';
            }
        }

        return new String(tmp);
    }
}
