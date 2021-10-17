package Citibanamex.controller;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Citibanamex.findBranchOfficeATM.FindBranchOfficeATM;
import Citibanamex.message.Message;
import Citibanamex.model.Coordenadas;

@RestController
@RequestMapping("/SucursalATM")
@CrossOrigin(origins = "*")
public class BranchOfficeATMController {

	@Value("${variables.keys}")
	private String[] keys;
	@Value("${varia.arre}")
	private String[] arre; 
	@Value("${iterator.fin}")
	private int fin;


	@PostMapping("/BranchOfficeATM")
	public  ResponseEntity<?> BranchOfficeATM(@Valid @RequestBody Coordenadas coordenadas,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
            return  new ResponseEntity<Message>(new Message ("Something is wrong"),HttpStatus.BAD_REQUEST);
        }
		FindBranchOfficeATM branchOffice = new FindBranchOfficeATM();	
		ArrayList<?> response = branchOffice.findBranchOffice(coordenadas,keys,arre,fin);
		return response.isEmpty()? new ResponseEntity<Message>(new Message ("No matches, sorry"),HttpStatus.OK):ResponseEntity.ok(response);
	}
}
