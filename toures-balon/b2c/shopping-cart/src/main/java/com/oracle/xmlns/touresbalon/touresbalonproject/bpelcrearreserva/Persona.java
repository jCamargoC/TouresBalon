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
 * <p>Clase Java para Persona complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Persona">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoDoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroDoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="genero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="titular" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nroTelefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tarjeta" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Tarjeta"/>
 *         &lt;element name="tipoCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Persona", propOrder = {
    "idCliente",
    "nombre",
    "apellido",
    "tipoDoc",
    "nroDoc",
    "correo",
    "genero",
    "titular",
    "nroTelefono",
    "tarjeta",
    "tipoCliente"
})
public class Persona {

    @XmlElement(required = true)
    protected String idCliente;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String apellido;
    @XmlElement(required = true)
    protected String tipoDoc;
    @XmlElement(required = true)
    protected String nroDoc;
    @XmlElement(required = true)
    protected String correo;
    @XmlElement(required = true)
    protected String genero;
    protected boolean titular;
    @XmlElement(required = true)
    protected String nroTelefono;
    @XmlElement(required = true)
    protected Tarjeta tarjeta;
    @XmlElement(required = true)
    protected String tipoCliente;

    /**
     * Obtiene el valor de la propiedad idCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCliente(String value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Define el valor de la propiedad tipoDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDoc(String value) {
        this.tipoDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad nroDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroDoc() {
        return nroDoc;
    }

    /**
     * Define el valor de la propiedad nroDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroDoc(String value) {
        this.nroDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad genero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define el valor de la propiedad genero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenero(String value) {
        this.genero = value;
    }

    /**
     * Obtiene el valor de la propiedad titular.
     * 
     */
    public boolean isTitular() {
        return titular;
    }

    /**
     * Define el valor de la propiedad titular.
     * 
     */
    public void setTitular(boolean value) {
        this.titular = value;
    }

    /**
     * Obtiene el valor de la propiedad nroTelefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroTelefono() {
        return nroTelefono;
    }

    /**
     * Define el valor de la propiedad nroTelefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroTelefono(String value) {
        this.nroTelefono = value;
    }

    /**
     * Obtiene el valor de la propiedad tarjeta.
     * 
     * @return
     *     possible object is
     *     {@link Tarjeta }
     *     
     */
    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    /**
     * Define el valor de la propiedad tarjeta.
     * 
     * @param value
     *     allowed object is
     *     {@link Tarjeta }
     *     
     */
    public void setTarjeta(Tarjeta value) {
        this.tarjeta = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Define el valor de la propiedad tipoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCliente(String value) {
        this.tipoCliente = value;
    }

}
