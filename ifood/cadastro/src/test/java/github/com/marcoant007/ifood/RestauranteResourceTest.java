package github.com.marcoant007.ifood;

import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.google.inject.Inject;

import github.com.marcoant007.ifood.models.Restaurante;
import github.com.marcoant007.ifood.repository.RestauranteRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


import javax.ws.rs.core.Response.Status;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestauranteResourceTest {

    @Inject RestauranteRepository restauranteRepository;

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testBuscarRestaurante(){
        String resultado = given().when().get("/restaurantes").then().statusCode(200).extract().asString();
        Approvals.verifyJson(resultado);
    }

    private RequestSpecification given(){
        return RestAssured.given().contentType(ContentType.JSON);
    }

    //TEST PUT
    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testAlterarRestaurante(){
        Restaurante restauranteDTO = new Restaurante();
        restauranteDTO.setNome("NovoNome");
        Integer parameterValue = 123;
        given().with().pathParam("id", parameterValue).body(restauranteDTO).when().put("/restaurantes/id").then().statusCode(Status.NO_CONTENT.getStatusCode()).extract().asString();

        Restaurante findbyId = restauranteRepository.findById(parameterValue);
        Assert.assertEquals(restauranteDTO.getNome(), findbyId.getNome());
        
    }
    
}
