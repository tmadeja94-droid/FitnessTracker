package pl.wsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Główna klasa  aplikacji FitnessTracker.
 * Odpowiada za:
 * - konfigurację Spring Boot,
 * - skanowanie encji JPA,
 * - skanowanie repozytoriów,
 * - uruchomienie kontekstu aplikacji.
 */
// Skanowanie encji JPA w podanym pakiecie.
@EntityScan(basePackages = "pl.wsb.fitnesstracker")
// automatyczne wykrywanie i tworzenie implementacji repozytoriów JPA w pakiecie pl.wsb.fitnesstracker
@EnableJpaRepositories(basePackages = "pl.wsb.fitnesstracker")
// Główna adnotacja Spring Boot - włącza autokonfigurację, skanowanie komponentów i konfigurację aplikacji.
@SpringBootApplication
// Główna klasa aplikacji - punkt startowy programu.
public class FitnessTracker {

    public static void main(String[] args) {
        SpringApplication.run(FitnessTracker.class, args);
    }

}
