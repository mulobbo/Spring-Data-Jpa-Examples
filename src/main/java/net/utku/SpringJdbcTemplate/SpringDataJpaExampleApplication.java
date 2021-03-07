package net.utku.SpringJdbcTemplate;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringDataJpaExampleApplication implements CommandLineRunner{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaExampleApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.debug("Starting...");
		
		printDBInfo();
		
	}

	private void printDBInfo() {
EntityManagerFactory emf = entityManager.getEntityManagerFactory();
	Map<String, Object> emfPropertiesMap = emf.getProperties();	
	 log.debug(">> EMF PROPERTIES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
     for(Map.Entry<String, Object> entry : emfPropertiesMap.entrySet()) {
         log.debug("{} = {}", entry.getKey(), entry.getValue());
     }
     log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	
	
	
	}

}
