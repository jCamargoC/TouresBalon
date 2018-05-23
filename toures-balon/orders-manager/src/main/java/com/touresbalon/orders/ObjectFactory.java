//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.23 a las 01:02:04 PM COT 
//


package com.touresbalon.orders;

import javax.xml.bind.annotation.XmlRegistry;

import com.touresbalon.entities.orders.Reserva;
import com.touresbalon.entities.orders.SaleOrder;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.touresbalon.orders package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.touresbalon.orders
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link SaleOrder }
     * 
     */
    public SaleOrder createSaleOrder() {
        return new SaleOrder();
    }

    /**
     * Create an instance of {@link CreateOrderRequest }
     * 
     */
    public CreateOrderRequest createCreateOrderRequest() {
        return new CreateOrderRequest();
    }

    /**
     * Create an instance of {@link Reserva }
     * 
     */
    public Reserva createReserva() {
        return new Reserva();
    }

}
