//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.23 a las 01:02:04 PM COT 
//


package com.touresbalon.entities.orders;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para saleOrder complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="saleOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reservaEspectaculo" type="{http://www.touresbalon.com/orders}reserva" minOccurs="0"/>
 *         &lt;element name="reservaHospedaje" type="{http://www.touresbalon.com/orders}reserva" minOccurs="0"/>
 *         &lt;element name="reservaTransporte" type="{http://www.touresbalon.com/orders}reserva" minOccurs="0"/>
 *         &lt;element name="reservaVuelo" type="{http://www.touresbalon.com/orders}reserva" minOccurs="0"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saleOrder", propOrder = {
    "estado",
    "fecha",
    "id",
    "idCliente",
    "idProducto",
    "idReserva",
    "reservaEspectaculo",
    "reservaHospedaje",
    "reservaTransporte",
    "reservaVuelo",
    "valor"
})
@Entity
@Table
public class SaleOrder implements Serializable{

    protected String estado;
    
    protected String fecha;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    protected Long idCliente;
    protected Long idProducto;
    protected String idReserva;
    @OneToOne(optional=true,mappedBy="orden",fetch=FetchType.LAZY)
    protected Reserva reservaEspectaculo;
    @OneToOne(optional=true,mappedBy="orden",fetch=FetchType.LAZY)
    protected Reserva reservaHospedaje;
    @OneToOne(optional=true,mappedBy="orden",fetch=FetchType.LAZY)
    protected Reserva reservaTransporte;
    @OneToOne(optional=true,mappedBy="orden",fetch=FetchType.LAZY)
    protected Reserva reservaVuelo;
    protected Float valor;

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
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
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
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad idCliente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdCliente(Long value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdProducto(Long value) {
        this.idProducto = value;
    }

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
     * Obtiene el valor de la propiedad reservaEspectaculo.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getReservaEspectaculo() {
        return reservaEspectaculo;
    }

    /**
     * Define el valor de la propiedad reservaEspectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setReservaEspectaculo(Reserva value) {
        this.reservaEspectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad reservaHospedaje.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getReservaHospedaje() {
        return reservaHospedaje;
    }

    /**
     * Define el valor de la propiedad reservaHospedaje.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setReservaHospedaje(Reserva value) {
        this.reservaHospedaje = value;
    }

    /**
     * Obtiene el valor de la propiedad reservaTransporte.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getReservaTransporte() {
        return reservaTransporte;
    }

    /**
     * Define el valor de la propiedad reservaTransporte.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setReservaTransporte(Reserva value) {
        this.reservaTransporte = value;
    }

    /**
     * Obtiene el valor de la propiedad reservaVuelo.
     * 
     * @return
     *     possible object is
     *     {@link Reserva }
     *     
     */
    public Reserva getReservaVuelo() {
        return reservaVuelo;
    }

    /**
     * Define el valor de la propiedad reservaVuelo.
     * 
     * @param value
     *     allowed object is
     *     {@link Reserva }
     *     
     */
    public void setReservaVuelo(Reserva value) {
        this.reservaVuelo = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setValor(Float value) {
        this.valor = value;
    }

}
