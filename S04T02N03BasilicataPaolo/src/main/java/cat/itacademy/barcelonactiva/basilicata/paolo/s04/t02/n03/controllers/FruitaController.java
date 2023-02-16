package cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.services.FruitaServiceImpl;



@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	
	@Autowired
	private FruitaServiceImpl fruitaServiceImpl;
	
	
	@PostMapping("/add")
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita){
		try {
			fruitaServiceImpl.addFruita(fruita);
			return new ResponseEntity<>(fruita, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruita){
		Optional<Fruita> fruitaData = fruitaServiceImpl.getOne(fruita.getId());
		if(fruitaData.isPresent()) {
			Fruita _fruita = new Fruita(fruita.getId(),fruita.getNom(),fruita.getQuantitatQuilos()); //fruitaData.get();
			//_fruita.setNom(fruita.getNom());
			//_fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
			fruitaServiceImpl.updateFruita(_fruita);
			return new ResponseEntity<>(_fruita,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id){
		try {
			fruitaServiceImpl.deleteFruita(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") long id){
		Optional<Fruita> fruitaData = fruitaServiceImpl.getOne(id);
		if(fruitaData.isPresent()) {
			return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruita>> getAllFruites(){
		List<Fruita> fruites = fruitaServiceImpl.getAll();
		return new ResponseEntity<>(fruites, HttpStatus.OK);
		
	}
	

}
