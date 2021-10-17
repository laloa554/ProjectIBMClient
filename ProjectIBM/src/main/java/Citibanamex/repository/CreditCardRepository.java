package Citibanamex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Citibanamex.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	List<CreditCard> findByYourPassion(String yourPassion);
	boolean existsByYourPassion(String yourPassion);

}

