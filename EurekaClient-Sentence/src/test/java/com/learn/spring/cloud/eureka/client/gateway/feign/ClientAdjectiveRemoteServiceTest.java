package com.learn.spring.cloud.eureka.client.gateway.feign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureWireMock(port = 0)
public class ClientAdjectiveRemoteServiceTest {

    // A service that calls out over HTTP
    @Autowired
    private ClientAdjectiveRemoteService clientAdjectiveRemoteService;

    @Test
    public void ShouldRetrieveWordSuccessfully() {

        String expected = "like";
        stubFor(
                get(urlEqualTo("/word"))
                        .willReturn(
                                aResponse()
                                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(expected)));

        assertEquals(clientAdjectiveRemoteService.getAdjective(), expected);
    }

}