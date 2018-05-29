//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.23 a las 01:02:04 PM COT 
//


package com.touresbalon.entities.orders;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;


/**
 * <p>Clase Java para reserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="empresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/> *         
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserva", propOrder = {
    "empresa",
    "id",
    "idReserva",
    "tipoReserva"
})
@Entity
@Table
public class Reserva {

    protected String empresa;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    protected String idReserva;
    @OneToOne(optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="ordenId",unique=false,foreignKey=@ForeignKey(name="fk_Reserva_orderId_SaleOrder_id"))
    @XmlTransient
    @JsonIgnore
    protected SaleOrder orden;
    
    protected String tipoReserva;

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
     * Obtiene el valor de la propiedad orden.
     * 
     * @return
     *     possible object is
     *     {@link SaleOrder }
     *     
     */
    public SaleOrder getOrden() {
        return orden;
    }

    /**
     * Define el valor de la propiedad orden.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleOrder }
     *     
     */
    public void setOrden(SaleOrder value) {
        this.orden = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoReserva() {
        return tipoReserva;
    }

    /**
     * Define el valor de la propiedad tipoReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoReserva(String value) {
        this.tipoReserva = value;
    }

}
