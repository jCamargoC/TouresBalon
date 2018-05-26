package com.touresbalon.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SOAPInvoker {

	public static void callSoapWebService(String soapEndpointUrl, String soapAction, String envelope) {
		try {
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			soapConnection.call(createSOAPRequest(soapAction, envelope), soapEndpointUrl);

		} catch (Exception e) {
			System.err.println(
					"\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
			e.printStackTrace();
		}
	}

	private static Document toDocument(SOAPMessage soapMsg)
			throws TransformerConfigurationException, TransformerException, SOAPException, IOException {
		Source src = soapMsg.getSOAPPart().getContent();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMResult result = new DOMResult();
		transformer.transform(src, result);
		return (Document) result.getNode();
	}

	private static SOAPMessage createSOAPRequest(String soapAction, String body) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		InputStream is = new ByteArrayInputStream(body.getBytes());
		SOAPMessage soapMessage = messageFactory.createMessage(null, is);

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);

		soapMessage.saveChanges();

		/* Print the request message, just for debugging purposes */
		System.out.println("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println("\n");

		return soapMessage;
	}

	public static void main(String[] args) {
		String url = "http://192.168.0.26:7001/soa-infra/services/default/TouresBalonProject/bpelcrearreserva_client_ep";
		String soapAction = "process";
		String envelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bpel=\"http://xmlns.oracle.com/TouresBalon/TouresBalonProject/BPELCrearReserva\">\r\n"
				+ "   <soapenv:Header/>\r\n" + "   <soapenv:Body>\r\n" + "      ﻿﻿<bpel:ReservaInput>\r\n"
				+ "         <bpel:idReserva>?</bpel:idReserva>\r\n"
				+ "         <bpel:valorReserva>3500000</bpel:valorReserva>\r\n" + "         <bpel:persona>\r\n"
				+ "            <bpel:nombre>Pepito</bpel:nombre>\r\n"
				+ "            <bpel:apellido>Perez</bpel:apellido>\r\n"
				+ "            <bpel:tipoDoc>CC</bpel:tipoDoc>\r\n"
				+ "            <bpel:nroDoc>1234567890</bpel:nroDoc>\r\n"
				+ "            <bpel:correo>andreszambrano18@gmail.com</bpel:correo>\r\n"
				+ "            <bpel:genero>M</bpel:genero>\r\n" + "            <bpel:titular>true</bpel:titular>\r\n"
				+ "            <bpel:nroTelefono>2511846</bpel:nroTelefono>\r\n" + "            <bpel:tarjeta>\r\n"
				+ "               <bpel:franquicia>?</bpel:franquicia>\r\n"
				+ "               <bpel:nroTarjeta>?</bpel:nroTarjeta>\r\n"
				+ "               <bpel:fechaVencimiento>?</bpel:fechaVencimiento>\r\n"
				+ "               <bpel:membresia>?</bpel:membresia>\r\n"
				+ "               <bpel:codigoSeguridad>?</bpel:codigoSeguridad>\r\n"
				+ "            </bpel:tarjeta>\r\n" + "            <bpel:tipoCliente>Dorado</bpel:tipoCliente>\r\n"
				+ "         </bpel:persona>\r\n" + "         <bpel:vuelo>\r\n"
				+ "            <bpel:idReserva>1</bpel:idReserva>\r\n" + "            <bpel:silla>2</bpel:silla>\r\n"
				+ "            <bpel:nroVuelo>3</bpel:nroVuelo>\r\n"
				+ "            <bpel:origen>Bogota</bpel:origen>\r\n"
				+ "            <bpel:destino>Miami</bpel:destino>\r\n"
				+ "            <bpel:fechaInicio>2018/05/21</bpel:fechaInicio>\r\n"
				+ "            <bpel:fechaFin>2018/05/21</bpel:fechaFin>\r\n"
				+ "            <bpel:puertaEmbarque>2</bpel:puertaEmbarque>\r\n"
				+ "            <bpel:grupo>1</bpel:grupo>\r\n" + "            <bpel:hayVuelo>true</bpel:hayVuelo>\r\n"
				+ "            <bpel:empresa>Avianca</bpel:empresa>\r\n" + "         </bpel:vuelo>\r\n"
				+ "         <bpel:fechaReserva>2018/05/21</bpel:fechaReserva>\r\n"
				+ "         <bpel:estadoReserva>Reservado</bpel:estadoReserva>\r\n" + "         <bpel:boletas>\r\n"
				+ "            <bpel:persona>\r\n" + "               <bpel:nombre>Pepito</bpel:nombre>\r\n"
				+ "            <bpel:apellido>Perez</bpel:apellido>\r\n"
				+ "            <bpel:tipoDoc>CC</bpel:tipoDoc>\r\n"
				+ "            <bpel:nroDoc>1234567890</bpel:nroDoc>\r\n"
				+ "            <bpel:correo>andreszambrano18@gmail.com</bpel:correo>\r\n"
				+ "            <bpel:genero>M</bpel:genero>\r\n" + "            <bpel:titular>true</bpel:titular>\r\n"
				+ "            <bpel:nroTelefono>2511846</bpel:nroTelefono>\r\n" + "               <bpel:tarjeta>\r\n"
				+ "                  <bpel:franquicia>?</bpel:franquicia>\r\n"
				+ "                  <bpel:nroTarjeta>?</bpel:nroTarjeta>\r\n"
				+ "                  <bpel:fechaVencimiento>?</bpel:fechaVencimiento>\r\n"
				+ "                  <bpel:membresia>?</bpel:membresia>\r\n"
				+ "                  <bpel:codigoSeguridad>?</bpel:codigoSeguridad>\r\n"
				+ "               </bpel:tarjeta>\r\n" + "               <bpel:tipoCliente>?</bpel:tipoCliente>\r\n"
				+ "            </bpel:persona>\r\n" + "            <bpel:tipoEvento>FUTBOL</bpel:tipoEvento>\r\n"
				+ "            <bpel:lugar>CAMPIN</bpel:lugar>\r\n" + "            <bpel:sector>1</bpel:sector>\r\n"
				+ "            <bpel:fila>2</bpel:fila>\r\n" + "            <bpel:silla>3</bpel:silla>\r\n"
				+ "            <bpel:grada>4</bpel:grada>\r\n" + "            <bpel:idBoleta>5</bpel:idBoleta>\r\n"
				+ "            <bpel:fecha>2018/05/21</bpel:fecha>\r\n" + "            <bpel:hora>?</bpel:hora>\r\n"
				+ "            <bpel:valor>123456</bpel:valor>\r\n"
				+ "            <bpel:hayEvento>true</bpel:hayEvento>\r\n"
				+ "            <bpel:empresa>TuBoleta</bpel:empresa>\r\n" + "         </bpel:boletas>\r\n"
				+ "      </bpel:ReservaInput>\r\n" + "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";
		callSoapWebService(url, soapAction, envelope);
		
	}
}
