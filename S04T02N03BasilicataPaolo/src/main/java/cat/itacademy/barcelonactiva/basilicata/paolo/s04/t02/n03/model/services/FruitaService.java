package cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n03.model.domain.Fruita;

public interface FruitaService {
	
	
	public void addFruita(Fruita fruita);
	
    public Fruita updateFruita(Fruita fruita);
	
	public void deleteFruita(long id);
	
	public Optional<Fruita> getOne(long id);
	
	public List<Fruita> getAll();

}
