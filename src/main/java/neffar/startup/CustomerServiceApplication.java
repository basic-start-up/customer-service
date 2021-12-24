package neffar.startup;

import neffar.startup.entity.Customer;
import neffar.startup.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration configuration) {
        return args -> {
            configuration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer(null, "Ali", "ali@email.fr"));
            customerRepository.save(new Customer(null, "Samir", "samir@email.fr"));
            customerRepository.save(new Customer(null, "Youssef", "youssef@email.fr"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
