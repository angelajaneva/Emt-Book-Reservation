package mk.ukim.finki.emt.reservation.port.client;

import mk.ukim.finki.emt.reservation.application.BookCatalog;
import mk.ukim.finki.emt.reservation.domain.model.Book;
import mk.ukim.finki.emt.reservation.domain.model.BookId;
import mk.ukim.finki.emt.sharedkernel.domain.base.RemoteEventLog;
import mk.ukim.finki.emt.sharedkernel.infra.eventlog.RemoteEventLogService;
import mk.ukim.finki.emt.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
//@PropertySource(ignoreResourceNotFound = true,value={"classpath:book-catalog.properties"})
public class BookCatalogClient implements BookCatalog, RemoteEventLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookCatalogClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public BookCatalogClient(@Value("${app.book-catalog.url}") String serverUrl,
                         @Value("${app.book-catalog.connect-timeout-ms}") int connectTimeout,
                         @Value("${app.book-catalog.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }


    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }


    @Override
    public List<Book> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/books").build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
            }).getBody();
        } catch (Exception ex){
            LOGGER.error("error retrieving books", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public Book findById(BookId productId) {
        try {
            return restTemplate.exchange(uri().path("/api/books/" + productId.getId()).build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<Book>() {
            }).getBody();
        } catch (Exception ex){
            LOGGER.error("error retrieving books", ex);
            return null;
        }
    }

    @Override
    @NonNull
    public String source() {
        return "http://localhost:8082/";
    }

    @Override
    public RemoteEventLog currentLog(long lastProcessedId) {
        URI currentLogUri = UriComponentsBuilder.fromUriString(serverUrl).path
                (String.format("/api/event-log/%d", lastProcessedId)).build().toUri();
        System.out.println(lastProcessedId + "last ");
        return retrieveLog(currentLogUri);
    }

    @NonNull
    private RemoteEventLog retrieveLog(@NonNull URI uri) {
        ResponseEntity<List<StoredDomainEvent>> response = restTemplate.exchange
                (uri, HttpMethod.GET, null, new
                        ParameterizedTypeReference<List<StoredDomainEvent>>() {
                        });
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException("Could not retrieve log from URI " + uri);
        }
        return new RemoteEventLog() {
            @Override
            public List<StoredDomainEvent> events() {
                return response.getBody();
            }
        };
    }
}
