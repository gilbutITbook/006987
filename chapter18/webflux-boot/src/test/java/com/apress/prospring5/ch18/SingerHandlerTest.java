package com.apress.prospring5.ch18;

import com.apress.prospring5.ch18.entities.Singer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by iuliana.cosmina on 8/3/17.
 */
public class SingerHandlerTest {

	private static Logger logger = LoggerFactory.getLogger(SingerHandlerTest.class);

	public static final String HOST = "localhost";

	public static final int PORT = 8080;

	private static ExchangeFunction exchange;

	@BeforeAll
	public static void init(){
		exchange = ExchangeFunctions.create(new ReactorClientHttpConnector());
	}

	@Test
	public void noSinger(){
		//singer 가져오기
		URI uri = URI.create(String.format("http://%s:%d/singers/99", HOST, PORT));
		logger.debug("조회 요청: "+ uri.toString());
		ClientRequest request = ClientRequest.method(HttpMethod.GET, uri).build();

		Mono<Singer> singerMono = exchange.exchange(request)
				.flatMap(response -> response.bodyToMono(Singer.class));
		Singer singer = singerMono.block();
		assertNull(singer);
	}

	@Test
	public void editSinger() {
		//singer 가져오기
		URI uri = URI.create(String.format("http://%s:%d/singers/1", HOST, PORT));
		logger.debug("조회 요청: "+ uri.toString());
		ClientRequest request = ClientRequest.method(HttpMethod.GET, uri).build();

		Mono<Singer> singerMono = exchange.exchange(request)
				.flatMap(response -> response.bodyToMono(Singer.class));
		Singer singer = singerMono.block();
		assertAll("singer", () ->
		{
			assertNotNull(singer);
					assertAll("singer",
	        				() -> assertEquals("John", singer.getFirstName()),
		    				() -> assertEquals("Mayer", singer.getLastName()));
		});

		logger.info("가수:" + singer.toString());

		//edit singer
		singer.setFirstName("John Clayton");
		uri = URI.create(String.format("http://%s:%d/singers", HOST, PORT));
		logger.debug("수정 요청: "+ uri.toString());
		 request = ClientRequest.method(HttpMethod.POST, uri)
				.body(BodyInserters.fromObject(singer)).build();

		Mono<ClientResponse> response = exchange.exchange(request);
		assertEquals(HttpStatus.OK, response.block().statusCode());
		logger.info("수정 요청 후 응답받은 상태 코드: " + response.block().statusCode());
	}

	@Test
	public void printAllSingers() {
		URI uri = URI.create(String.format("http://%s:%d/singers", HOST, PORT));
		logger.debug("모든 요청: "+ uri.toString());
		ClientRequest request = ClientRequest.method(HttpMethod.GET, uri).build();

		Flux<Singer> singers = exchange.exchange(request)
				.flatMapMany(response -> response.bodyToFlux(Singer.class));

		Mono<List<Singer>> singerList = singers.collectList();
		singerList.block().forEach(singer -> logger.info(singer.toString()));
	}

	@Test
	public void createSinger() {
		URI uri = URI.create(String.format("http://%s:%d/singers", HOST, PORT));
		logger.debug("생성 요청: "+ uri.toString());
		Singer singer = new Singer();
		singer.setFirstName("Ed");
		singer.setLastName("Sheeran");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1991, 2, 17)).getTime().getTime()));

		ClientRequest request = ClientRequest.method(HttpMethod.POST, uri)
				.body(BodyInserters.fromObject(singer)).build();

		Mono<ClientResponse> response = exchange.exchange(request);
		assertEquals(HttpStatus.OK, response.block().statusCode());

		logger.info("생성 요청 후 응답받은 상태 코드: " + response.block().statusCode());
	}


}
