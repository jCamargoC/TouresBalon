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
 * <p>Clase Java para Reservas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Reservas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idReservaPadre" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Reserva"/>
 *         &lt;element name="idReservaHospedaje" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Reserva"/>
 *         &lt;element name="idReservaTransporte" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Reserva"/>
 *         &lt;element name="idReservaEspectaculo" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Reserva"/>
 *         &lt;element name="idReservaVuelo" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva}Reserva"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservas", propOrder = {
    "respuesta",
    "estado",
    "codigo",
    "idReservaPadre",
    "idReservaHospedaje",
    "idReservaTransporte",
    "idReservaEspectaculo",
    "idReservaVuelo"
})
public class Reservas {

    @XmlElement(required = true)
    protected String respuesta;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String codigo;
    @XmlElement(required = true)
    protected Reserva idReservaPadre;
    @XmlElement(required = true)
    protected Reserva idReservaHospedaje;
    @XmlElement(required = true)
    protected Reserva idReservaTransporte;
    @XmlElement(required = true)
    protected Reserva idReservaEspectaculo;
    @XmlElement(required = true)
    protected Reserva idReservaVuelo;

    /**
     * Obtiene el valor de la propiedad respuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * Define el valor de la propiedad respuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespuesta(String value) {
        this.respuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad idReservaPadre.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getIdReservaPadre() {
        return idReservaPadre;
    }

    /**
     * Define el valor de la propiedad idReservaPadre.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setIdReservaPadre(Reserva value) {
        this.idReservaPadre = value;
    }

    /**
     * Obtiene el valor de la propiedad idReservaHospedaje.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getIdReservaHospedaje() {
        return idReservaHospedaje;
    }

    /**
     * Define el valor de la propiedad idReservaHospedaje.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setIdReservaHospedaje(Reserva value) {
        this.idReservaHospedaje = value;
    }

    /**
     * Obtiene el valor de la propiedad idReservaTransporte.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getIdReservaTransporte() {
        return idReservaTransporte;
    }

    /**
     * Define el valor de la propiedad idReservaTransporte.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setIdReservaTransporte(Reserva value) {
        this.idReservaTransporte = value;
    }

    /**
     * Obtiene el valor de la propiedad idReservaEspectaculo.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getIdReservaEspectaculo() {
        return idReservaEspectaculo;
    }

    /**
     * Define el valor de la propiedad idReservaEspectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setIdReservaEspectaculo(Reserva value) {
        this.idReservaEspectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad idReservaVuelo.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getIdReservaVuelo() {
        return idReservaVuelo;
    }

    /**
     * Define el valor de la propiedad idReservaVuelo.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setIdReservaVuelo(Reserva value) {
        this.idReservaVuelo = value;
    }

}
