package ca.appspace.homework.ui.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ca.appspace.homework.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class HelloWorldWebserviceTest {
	
	@Autowired
	private HelloWorldWebservice _webservice;
	
	@Test
	public void testGetTextLocally() {
		assertNotNull("Webservice was not initialized. Does Spring container start?", _webservice);
		testSend("Hello");
	}

	@Test
	public void testGetTextWithNullValue() {
		//TODO: Ask customer on what border cases should be and how the system must react on them.
		assertNotNull("Webservice was not initialized. Does Spring container start?", _webservice);
		testSend(null);
	}

	
	private void testSend(String request) {
		final String response = _webservice.getText(request);
		assertEquals("Expected "+request+" but received "+response, request, response);
	}

	
	/*
	 * For now - commented out as it requires web app to be running to pass the test
	@Test
	public void testGetTextViaHTTP() {
		final String value = "Hello1";
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.TEXT_PLAIN);
	    headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));

	    RestTemplate template = new RestTemplate();

	    HttpEntity<String> requestEntity = new HttpEntity<String>(value, headers);

	    ResponseEntity<String> entity = template.postForEntity("http://localhost:8080/"+HelloWorldWebservice.GET_TEXT_URL, requestEntity, String.class);

	    assertEquals(HttpStatus.OK, entity.getStatusCode());
	    assertEquals(value, entity.getBody());
	    
	}
	*/
}
