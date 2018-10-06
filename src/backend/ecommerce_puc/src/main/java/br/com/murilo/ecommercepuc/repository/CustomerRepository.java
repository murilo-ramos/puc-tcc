package br.com.murilo.ecommercepuc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.murilo.ecommercepuc.entity.Customer;

/**
 * Interface representando o repositório de dados referentes ao cliente
 * Implementação é feita em tempo de execução pelo Spring
 * @author murilocosta
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query("SELECT t FROM Customer t WHERE t.email = ?1")
    public Optional<Customer> findByEmail(String email);
	
	@Query("SELECT t FROM Customer t WHERE t.name LIKE %?1%")
    public List<Customer> findAllByName(String name);
}
