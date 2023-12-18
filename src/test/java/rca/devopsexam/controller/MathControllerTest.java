package rca.devopsexam.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rca.devopsexam.v1.dtos.DoMathRequestDTO;
import rca.devopsexam.v1.payload.ApiResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Success(){
        DoMathRequestDTO dto = new DoMathRequestDTO(2, 5, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath",dto,ApiResponse.class);

        assertEquals(200, response.getStatusCode().value());
    }
    @Test
    public void doMathOperation_Addition(){
        DoMathRequestDTO dto = new DoMathRequestDTO(2, 5, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath",dto,ApiResponse.class);

        assertEquals(7.0, response.getBody().getData());
    }
    @Test
    public void doMathOperation_Subtraction(){
        DoMathRequestDTO dto = new DoMathRequestDTO(5, 2, "-");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath",dto,ApiResponse.class);

        assertEquals(3.0, response.getBody().getData());
    }
    @Test
    public void doMathOperation_Division(){
        DoMathRequestDTO dto = new DoMathRequestDTO(6, 2, "/");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath",dto,ApiResponse.class);

        assertEquals(3.0, response.getBody().getData());
    }
    @Test
    public void doMathOperation_Multiplication(){
        DoMathRequestDTO dto = new DoMathRequestDTO(6, 2, "*");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath",dto,ApiResponse.class);

        assertEquals(12.0, response.getBody().getData());
    }
}
