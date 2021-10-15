package Citibanamex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Citibanamex.entity.CreditCard;
import Citibanamex.repository.CreditCardRepository;

@Service
@Transactional
public class CreditCardService {
	@Autowired
	CreditCardRepository CreditCardRepository;
	
    public List<CreditCard> list(){
        return CreditCardRepository.findAll();
    }

    public List<CreditCard> findByYourPassion(String yourPassion){
        return CreditCardRepository.findByYourPassion(yourPassion);
    }

    public void save(CreditCard CreditCard){
    	CreditCardRepository.save(CreditCard);
    }

    public void delete(long id){
    	CreditCardRepository.deleteById(id);
    }

    public boolean existsById(long id){
        return CreditCardRepository.existsById(id);
    }

    public boolean existsByYourPassion(String yourPassion){
        return CreditCardRepository.existsByYourPassion(yourPassion);
    }
}
