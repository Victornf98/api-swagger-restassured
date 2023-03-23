package restassured.dadosabertos;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BlocosPorId {

	int code;

	@Test
	public void testPesquisarBlocos() {

		// Acessando a API através do método GET da class RestAssured e guardando no
		// response da class Response
		Response response = RestAssured
				.get("https://dadosabertos.camara.leg.br/api/v2/blocos?ordem=ASC&ordenarPor=nome");

		// Guardando a resposta do status code na variável code
		code = response.getStatusCode();

		// Imprimindo no console o valor da variável code
		System.out.println("O estatus code retornado é " + code);

		// Comparando o retorno da API com o status code informado
		assertEquals(200, code);

	}

	@Test
	public void ValidarID() {

		Response response = RestAssured
		.get("https://dadosabertos.camara.leg.br/api/v2/blocos?ordem=ASC&ordenarPor=nome");

		String id = response.jsonPath().getString("dados.id[0]").toString();

		System.out.println(id);
	}
}