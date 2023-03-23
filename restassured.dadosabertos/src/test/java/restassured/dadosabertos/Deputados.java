package restassured.dadosabertos;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deputados {
	
public String ConsultarId() {

		Response response = RestAssured
		.get("https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome");

		String id = response.jsonPath().getString("dados.id[0]").toString();

		System.out.println(id);

		return id;
	}
	
	@Test
	public void ValidarDeputadoPorId() {

		String nomeEsperado = "ABILIO JACQUES BRUNINI MOUMER"; //massa de teste
		String id = ConsultarId();
		
		Response response = RestAssured
				.get("https://dadosabertos.camara.leg.br/api/v2/deputados/"+id);
		
		String nomeCapturado = response.jsonPath().getString("dados.nomeCivil").toString();

		assertEquals(nomeEsperado, nomeCapturado);
	}
}
