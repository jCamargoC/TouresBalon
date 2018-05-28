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
 * <p>Clase Java para Tarjeta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Tarjeta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="franquicia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroTarjeta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="membresia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoSeguridad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tarjeta", propOrder = {
    "franquicia",
    "nroTarjeta",
    "fechaVencimiento",
    "membresia",
    "codigoSeguridad"
})
public class Tarjeta {

    @XmlElement(required = true)
    protected String franquicia;
    @XmlElement(required = true)
    protected String nroTarjeta;
    @XmlElement(required = true)
    protected String fechaVencimiento;
    @XmlElement(required = true)
    protected String membresia;
    @XmlElement(required = true)
    protected String codigoSeguridad;

    /**
     * Obtiene el valor de la propiedad franquicia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFranquicia() {
        return franquicia;
    }

    /**
     * Define el valor de la propiedad franquicia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFranquicia(String value) {
        this.franquicia = value;
    }

    /**
     * Obtiene el valor de la propiedad nroTarjeta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroTarjeta() {
        return nroTarjeta;
    }

    /**
     * Define el valor de la propiedad nroTarjeta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroTarjeta(String value) {
        this.nroTarjeta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVencimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Define el valor de la propiedad fechaVencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaVencimiento(String value) {
        this.fechaVencimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad membresia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMembresia() {
        return membresia;
    }

    /**
     * Define el valor de la propiedad membresia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMembresia(String value) {
        this.membresia = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoSeguridad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    /**
     * Define el valor de la propiedad codigoSeguridad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSeguridad(String value) {
        this.codigoSeguridad = value;
    }

}
