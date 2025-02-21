package com.emersonmoura.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emersonmoura.workshopmongo.domain.User;
import com.emersonmoura.workshopmongo.dto.UserDTO;
import com.emersonmoura.workshopmongo.repositories.UserRepository;
import com.emersonmoura.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User>obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
