package com.intesasanpaolo.Y1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.Test;

import com.intesasanpaolo.Y1.WLP4Docker.view.PocWLP4DockerWS;
import com.intesasanpaolo.Y1.WLP4Docker.view.iPocWLP4DockerWS;

public class WSClientTest {

	@Test
	public void shouldCheckCreditCardValidity() throws MalformedURLException {
		String _port = System.getProperty("liberty.test.port");
		String _war = System.getProperty("war.name");
		String _url = "http://localhost:" + _port + "/" + _war + "/";

		_url = "http://localhost:9080/WLP4Docker/poc?wsdl";
		System.out.println("pippo " + _url);
		// Publishes the SOAP Web Service
		// Endpoint endpoint = Endpoint.publish(_url, new PocWLP4DockerWS ());
		// {http://web.WLP4Docker.Y1.intesasanpaolo.com/}PocWLP4Dockerws non è un
		// servizio valido. I servizi validi sono:
		// {http://web.WLP4Docker.Y1.intesasanpaolo.com/}PocWLP4Dockerws

		// {http://web.WLP4Docker.Y1.intesasanpaolo.com/}PocWLP4DockerWSPort
		URL wsdlUrl = new URL(_url);
		QName serviceName = new QName("http://view.WLP4Docker.Y1.intesasanpaolo.com/", "poc");
		QName _qnamePort = new QName("http://view.WLP4Docker.Y1.intesasanpaolo.com/", "PocWLP4DockerWSPort");
		Service service = null;
		try {
			service = Service.create(wsdlUrl, serviceName);
			iPocWLP4DockerWS portq = service.getPort(_qnamePort, iPocWLP4DockerWS.class);
			

			String _r = portq.HW();
			System.out.println(_r);

			assertEquals("Hello from EG", _r);
			// Iterator<QName> _ports = service.getPorts();
			//
			// while (_ports.hasNext()) {
			// QName qName = (QName) _ports.next();
			// System.out.println(qName.getLocalPart());
			// iPocWLP4DockerWS port = service.getPort(qName, iPocWLP4DockerWS.class);
			// System.out.println(port.HW());
			//
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

		Endpoint endpoint = Endpoint.create(_url, new PocWLP4DockerWS());
		assertTrue(endpoint.isPublished());
		assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

		// Data to access the web service
		URL wsdlDocumentLocation = new URL(_url + "?wsdl");
		// String namespaceURI = "http://chapter21.javaee7.book.agoncal.org/";
		// String servicePart = "CardValidatorService";
		// String portName = "CardValidatorPort";
		// QName serviceQN = new QName(namespaceURI, servicePart);
		// QName portQN = new QName(namespaceURI, portName);
		//
		// // Creates a service instance
		// Service service = Service.create(wsdlDocumentLocation, serviceQN);
		// Validator cardValidator = service.getPort(portQN, Validator.class);
		//
		// // Invokes the web service
		// CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
		//
		// assertFalse("Credit card should be valid",
		// cardValidator.validate(creditCard));
		// creditCard.setNumber("12341233");
		// assertTrue("Credit card should not be valid",
		// cardValidator.validate(creditCard));
		//
		// // Unpublishes the SOAP Web Service
		// endpoint.stop();
		// assertFalse(endpoint.isPublished());
	}

}