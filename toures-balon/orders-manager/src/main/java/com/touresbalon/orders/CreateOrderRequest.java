//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.23 a las 01:02:04 PM COT 
//


package com.touresbalon.orders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.touresbalon.entities.orders.SaleOrder;


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
 *         &lt;element name="saleOrder" type="{http://www.touresbalon.com/orders}saleOrder"/>
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
    "saleOrder"
})
@XmlRootElement(name = "createOrderRequest")
public class CreateOrderRequest {

    @XmlElement(required = true)
    protected SaleOrder saleOrder;

    /**
     * Obtiene el valor de la propiedad saleOrder.
     * 
     * @return
     *     possible object is
     *     {@link SaleOrder }
     *     
     */
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    /**
     * Define el valor de la propiedad saleOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleOrder }
     *     
     */
    public void setSaleOrder(SaleOrder value) {
        this.saleOrder = value;
    }

}
