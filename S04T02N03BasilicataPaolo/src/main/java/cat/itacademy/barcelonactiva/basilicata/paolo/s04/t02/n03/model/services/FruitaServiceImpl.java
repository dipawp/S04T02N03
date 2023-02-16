package cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.repository.FruitaRepository;


@Repository
public class FruitaServiceImpl implements FruitaService{

	
	
	@Autowired
	FruitaRepository fruitaRepository;
	
	
	@Override
	public void addFruita(Fruita fruita) {
		// TODO Auto-generated method stub
		fruitaRepository.insert(fruita);
	}
	
	
	@Override
	public Fruita updateFruita(Fruita fruita) {
		fruitaRepository.save(fruita);
		return fruita;
	}

	@Override
	public void deleteFruita(long id) {
		// TODO Auto-generated method stub
		fruitaRepository.deleteById(id);
	}

	@Override
	public Optional<Fruita> getOne(long id) {
		Optional<Fruita> fruita = fruitaRepository.findById(id);
		return fruita;
	}

	@Override
	public List<Fruita> getAll() {
		// TODO Auto-generated method stub
		List<Fruita> fruitaList = fruitaRepository.findAll();
		return fruitaList;
	}

}
