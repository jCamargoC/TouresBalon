//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.26 a las 07:48:48 PM COT 
//


package com.oracle.xmlns.touresbalon.touresbalonproject.bpelcrearreserva;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Hospedaje complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Hospedaje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="habitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hotel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoHabitacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaReserva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaIngreso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroHabitaciones" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="cantidadPersonas" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="hayHospedaje" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "Hospedaje", propOrder = {
    "idReserva",
    "habitacion",
    "hotel",
    "tipoHabitacion",
    "estadoReserva",
    "fechaReserva",
    "fechaIngreso",
    "fechaSalida",
    "nroHabitaciones",
    "cantidadPersonas",
    "hayHospedaje",
    "empresa"
})
public class Hospedaje {

    @XmlElement(required = true)
    protected String idReserva;
    @XmlElement(required = true)
    protected String habitacion;
    @XmlElement(required = true)
    protected String hotel;
    @XmlElement(required = true)
    protected String tipoHabitacion;
    @XmlElement(required = true)
    protected String estadoReserva;
    @XmlElement(required = true)
    protected String fechaReserva;
    @XmlElement(required = true)
    protected String fechaIngreso;
    @XmlElement(required = true)
    protected String fechaSalida;
    @XmlElement(required = true)
    protected BigInteger nroHabitaciones;
    @XmlElement(required = true)
    protected BigInteger cantidadPersonas;
    protected boolean hayHospedaje;
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
     * Obtiene el valor de la propiedad habitacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * Define el valor de la propiedad habitacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHabitacion(String value) {
        this.habitacion = value;
    }

    /**
     * Obtiene el valor de la propiedad hotel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Define el valor de la propiedad hotel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotel(String value) {
        this.hotel = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoHabitacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Define el valor de la propiedad tipoHabitacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoHabitacion(String value) {
        this.tipoHabitacion = value;
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
     * Obtiene el valor de la propiedad fechaIngreso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Define el valor de la propiedad fechaIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaIngreso(String value) {
        this.fechaIngreso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Define el valor de la propiedad fechaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSalida(String value) {
        this.fechaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad nroHabitaciones.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNroHabitaciones() {
        return nroHabitaciones;
    }

    /**
     * Define el valor de la propiedad nroHabitaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNroHabitaciones(BigInteger value) {
        this.nroHabitaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadPersonas.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCantidadPersonas() {
        return cantidadPersonas;
    }

    /**
     * Define el valor de la propiedad cantidadPersonas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCantidadPersonas(BigInteger value) {
        this.cantidadPersonas = value;
    }

    /**
     * Obtiene el valor de la propiedad hayHospedaje.
     * 
     */
    public boolean isHayHospedaje() {
        return hayHospedaje;
    }

    /**
     * Define el valor de la propiedad hayHospedaje.
     * 
     */
    public void setHayHospedaje(boolean value) {
        this.hayHospedaje = value;
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
