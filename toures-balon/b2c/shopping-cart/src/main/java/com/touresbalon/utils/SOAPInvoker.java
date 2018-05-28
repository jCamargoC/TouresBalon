package com.touresbalon.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import com.touresbalon.common.BusinessException;
import com.touresbalon.common.ErrorsEnum;

public class SOAPInvoker {

	public static <T>T callSoapWebService(String soapEndpointUrl, String soapAction, String envelope,Class<T> clazz) {
		try {
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			SOAPMessage soapMsg=soapConnection.call(createSOAPRequest(soapAction, envelope), soapEndpointUrl);
			
			Unmarshaller m=JAXBContext.newInstance(clazz).createUnmarshaller();
			
			T obj=(T)m.unmarshal(soapMsg.getSOAPBody().extractContentAsDocument());
			return obj;
		} catch (Exception e) {
			throw new BusinessException(ErrorsEnum.BPEL_INVOKE_ERROR);
		}
		
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

}
