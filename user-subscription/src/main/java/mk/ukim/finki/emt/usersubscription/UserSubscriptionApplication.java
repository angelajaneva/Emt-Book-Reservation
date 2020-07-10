package mk.ukim.finki.emt.usersubscription;

import mk.ukim.finki.emt.sharedkernel.SharedConfiguration;
import mk.ukim.finki.emt.sharedkernel.infra.eventlog.RemoteEventLogService;
import mk.ukim.finki.emt.sharedkernel.port.client.RemoteEventLogServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@Import(SharedConfiguration.class)
public class UserSubscriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSubscriptionApplication.class, args);
    }

    @Bean
    public RemoteEventLogService UserEvents(@Value("${app.fine.url}") String serverUrl,
                                            @Value("${app.fine.connect-timeout-ms}") int connectTimeout,
                                            @Value("${app.fine.read-timeout-ms}") int readTimeout){
        return new RemoteEventLogServiceClient(serverUrl, connectTimeout, readTimeout);
    }
}
