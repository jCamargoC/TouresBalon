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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Vuelo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Vuelo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="silla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroVuelo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="origen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="puertaEmbarque" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grupo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hayVuelo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="empresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vuelo", propOrder = {
    "idReserva",
    "silla",
    "nroVuelo",
    "origen",
    "destino",
    "fechaInicio",
    "fechaFin",
    "puertaEmbarque",
    "grupo",
    "hayVuelo",
    "empresa"
})
public class Vuelo {

    @XmlElement(required = true)
    protected String idReserva;
    @XmlElement(required = true)
    protected String silla;
    @XmlElement(required = true)
    protected String nroVuelo;
    @XmlElement(required = true)
    protected String origen;
    @XmlElement(required = true)
    protected String destino;
    @XmlElement(required = true)
    protected String fechaInicio;
    @XmlElement(required = true)
    protected String fechaFin;
    @XmlElement(required = true)
    protected String puertaEmbarque;
    @XmlElement(required = true)
    protected String grupo;
    protected boolean hayVuelo;
    @XmlElement(required = true)
    protected String empresa;

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
     * Obtiene el valor de la propiedad silla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSilla() {
        return silla;
    }

    /**
     * Define el valor de la propiedad silla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSilla(String value) {
        this.silla = value;
    }

    /**
     * Obtiene el valor de la propiedad nroVuelo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroVuelo() {
        return nroVuelo;
    }

    /**
     * Define el valor de la propiedad nroVuelo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroVuelo(String value) {
        this.nroVuelo = value;
    }

    /**
     * Obtiene el valor de la propiedad origen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Define el valor de la propiedad origen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigen(String value) {
        this.origen = value;
    }

    /**
     * Obtiene el valor de la propiedad destino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Define el valor de la propiedad destino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestino(String value) {
        this.destino = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Define el valor de la propiedad fechaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicio(String value) {
        this.fechaInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Define el valor de la propiedad fechaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFin(String value) {
        this.fechaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad puertaEmbarque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuertaEmbarque() {
        return puertaEmbarque;
    }

    /**
     * Define el valor de la propiedad puertaEmbarque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuertaEmbarque(String value) {
        this.puertaEmbarque = value;
    }

    /**
     * Obtiene el valor de la propiedad grupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * Define el valor de la propiedad grupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupo(String value) {
        this.grupo = value;
    }

    /**
     * Obtiene el valor de la propiedad hayVuelo.
     * 
     */
    public boolean isHayVuelo() {
        return hayVuelo;
    }

    /**
     * Define el valor de la propiedad hayVuelo.
     * 
     */
    public void setHayVuelo(boolean value) {
        this.hayVuelo = value;
    }

    /**
     * Obtiene el valor de la propiedad empresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Define el valor de la propiedad empresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresa(String value) {
        this.empresa = value;
    }

}
