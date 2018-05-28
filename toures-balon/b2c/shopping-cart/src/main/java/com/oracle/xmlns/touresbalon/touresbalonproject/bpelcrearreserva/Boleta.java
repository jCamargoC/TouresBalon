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
 * <p>Clase Java para Boleta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Boleta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="persona" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Persona"/>
 *         &lt;element name="tipoEvento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lugar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fila" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="silla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idBoleta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hora" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="hayEvento" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "Boleta", propOrder = {
    "persona",
    "tipoEvento",
    "lugar",
    "sector",
    "fila",
    "silla",
    "grada",
    "idBoleta",
    "fecha",
    "hora",
    "valor",
    "hayEvento",
    "empresa"
})
public class Boleta {

    @XmlElement(required = true)
    protected Persona persona;
    @XmlElement(required = true)
    protected String tipoEvento;
    @XmlElement(required = true)
    protected String lugar;
    @XmlElement(required = true)
    protected String sector;
    @XmlElement(required = true)
    protected String fila;
    @XmlElement(required = true)
    protected String silla;
    @XmlElement(required = true)
    protected String grada;
    @XmlElement(required = true)
    protected String idBoleta;
    @XmlElement(required = true)
    protected String fecha;
    @XmlElement(required = true)
    protected String hora;
    protected float valor;
    protected boolean hayEvento;
    @XmlElement(required = true)
    protected String empresa;

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
     * Obtiene el valor de la propiedad tipoEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * Define el valor de la propiedad tipoEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEvento(String value) {
        this.tipoEvento = value;
    }

    /**
     * Obtiene el valor de la propiedad lugar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Define el valor de la propiedad lugar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugar(String value) {
        this.lugar = value;
    }

    /**
     * Obtiene el valor de la propiedad sector.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSector() {
        return sector;
    }

    /**
     * Define el valor de la propiedad sector.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSector(String value) {
        this.sector = value;
    }

    /**
     * Obtiene el valor de la propiedad fila.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFila() {
        return fila;
    }

    /**
     * Define el valor de la propiedad fila.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFila(String value) {
        this.fila = value;
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
     * Obtiene el valor de la propiedad grada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrada() {
        return grada;
    }

    /**
     * Define el valor de la propiedad grada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrada(String value) {
        this.grada = value;
    }

    /**
     * Obtiene el valor de la propiedad idBoleta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdBoleta() {
        return idBoleta;
    }

    /**
     * Define el valor de la propiedad idBoleta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdBoleta(String value) {
        this.idBoleta = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad hora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHora(String value) {
        this.hora = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     */
    public float getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     */
    public void setValor(float value) {
        this.valor = value;
    }

    /**
     * Obtiene el valor de la propiedad hayEvento.
     * 
     */
    public boolean isHayEvento() {
        return hayEvento;
    }

    /**
     * Define el valor de la propiedad hayEvento.
     * 
     */
    public void setHayEvento(boolean value) {
        this.hayEvento = value;
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
