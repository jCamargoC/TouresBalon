//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.26 a las 07:48:48 PM COT 
//


package com.oracle.xmlns.touresbalon.touresbalonproject.bpelcancelarreserva;

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
 *         &lt;element name="input" type="{http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCancelarReserva}Reservas"/>
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
    "input"
})
@XmlRootElement(name = "ReservaInput")
public class ReservaInput {

    @XmlElement(required = true)
    protected Reservas input;

    /**
     * Obtiene el valor de la propiedad input.
     * 
     * @return
     *     possible object is
     *     {@link Reservas }
     *     
     */
    public Reservas getInput() {
        return input;
    }

    /**
     * Define el valor de la propiedad input.
     * 
     * @param value
     *     allowed object is
     *     {@link Reservas }
     *     
     */
    public void setInput(Reservas value) {
        this.input = value;
    }

}
