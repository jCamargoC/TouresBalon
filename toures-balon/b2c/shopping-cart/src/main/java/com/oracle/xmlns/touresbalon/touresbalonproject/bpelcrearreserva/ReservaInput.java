//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.26 a las 07:48:48 PM COT 
//


package com.oracle.xmlns.touresbalon.touresbalonproject.bpelcrearreserva;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idOrden" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valorReserva" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="persona" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Persona"/>
 *         &lt;element name="vuelo" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Vuelo"/>
 *         &lt;element name="fechaReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="boletas" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Boleta"/>
 *         &lt;element name="hospedaje" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Hospedaje"/>
 *         &lt;element name="transporte" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Transporte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idReserva",
    "idOrden",
    "valorReserva",
    "persona",
    "vuelo",
    "fechaReserva",
    "estadoReserva",
    "boletas",
    "hospedaje",
    "transporte"
})
@XmlRootElement(name = "ReservaInput")
public class ReservaInput {

    @XmlElement(required = true)
    protected String idReserva;
    @XmlElement(required = true)
    protected String idOrden;
    protected float valorReserva;
    @XmlElement(required = true)
    protected Persona persona;
    @XmlElement(required = true)
    protected Vuelo vuelo;
    @XmlElement(required = true)
    protected String fechaReserva;
    @XmlElement(required = true)
    protected String estadoReserva;
    @XmlElement(required = true)
    protected Boleta boletas;
    @XmlElement(required = true)
    protected Hospedaje hospedaje;
    @XmlElement(required = true)
    protected Transporte transporte;

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReserva(String value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOrden(String value) {
        this.idOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad valorReserva.
     * 
     */
    public float getValorReserva() {
        return valorReserva;
    }

    /**
     * Define el valor de la propiedad valorReserva.
     * 
     */
    public void setValorReserva(float value) {
        this.valorReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad persona.
     * 
     * @return
     *     possible object is
     *     {@link Persona }
     *     
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Define el valor de la propiedad persona.
     * 
     * @param value
     *     allowed object is
     *     {@link Persona }
     *     
     */
    public void setPersona(Persona value) {
        this.persona = value;
    }

    /**
     * Obtiene el valor de la propiedad vuelo.
     * 
     * @return
     *     possible object is
     *     {@link Vuelo }
     *     
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**
     * Define el valor de la propiedad vuelo.
     * 
     * @param value
     *     allowed object is
     *     {@link Vuelo }
     *     
     */
    public void setVuelo(Vuelo value) {
        this.vuelo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Define el valor de la propiedad fechaReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaReserva(String value) {
        this.fechaReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoReserva() {
        return estadoReserva;
    }

    /**
     * Define el valor de la propiedad estadoReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoReserva(String value) {
        this.estadoReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad boletas.
     * 
     * @return
     *     possible object is
     *     {@link Boleta }
     *     
     */
    public Boleta getBoletas() {
        return boletas;
    }

    /**
     * Define el valor de la propiedad boletas.
     * 
     * @param value
     *     allowed object is
     *     {@link Boleta }
     *     
     */
    public void setBoletas(Boleta value) {
        this.boletas = value;
    }

    /**
     * Obtiene el valor de la propiedad hospedaje.
     * 
     * @return
     *     possible object is
     *     {@link Hospedaje }
     *     
     */
    public Hospedaje getHospedaje() {
        return hospedaje;
    }

    /**
     * Define el valor de la propiedad hospedaje.
     * 
     * @param value
     *     allowed object is
     *     {@link Hospedaje }
     *     
     */
    public void setHospedaje(Hospedaje value) {
        this.hospedaje = value;
    }

    /**
     * Obtiene el valor de la propiedad transporte.
     * 
     * @return
     *     possible object is
     *     {@link Transporte }
     *     
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * Define el valor de la propiedad transporte.
     * 
     * @param value
     *     allowed object is
     *     {@link Transporte }
     *     
     */
    public void setTransporte(Transporte value) {
        this.transporte = value;
    }

}
