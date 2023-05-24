package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Historia_ClinicaRepository;
import com.example.demo.model.Historia_Clinica;

@Service
public class Historia_ClinicaService implements Historia_ClinicaRepository {
	
	@Autowired
	private Historia_ClinicaRepository historia_clinicaRepository;
	
	@Override
	public List<Historia_Clinica> findAll() {
		// TODO Auto-generated method stub
		return historia_clinicaRepository.findAll();
	}
	
	@Override
	public Optional<Historia_Clinica> findById(Long id) {
	    List<Historia_Clinica> historias_clinicas = historia_clinicaRepository.findAll();
	    Optional<Historia_Clinica> historia_clinicaRespuesta = historias_clinicas.stream()
	            .filter(historia_clinica -> Long.valueOf(historia_clinica.getId()).equals(id))
	            .findFirst();
	    return historia_clinicaRespuesta;
	}
	
	@Override
	public <S extends Historia_Clinica> S save(S entity) {
		// TODO Auto-generated method stub
		return historia_clinicaRepository.save(entity);
	}
	
	@Override
	public void delete(Historia_Clinica id) {
		// TODO Auto-generated method 
		historia_clinicaRepository.delete(id);
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Historia_Clinica> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Historia_Clinica> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Historia_Clinica> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Historia_Clinica getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historia_Clinica getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historia_Clinica getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Historia_Clinica> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Historia_Clinica> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Historia_Clinica> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Historia_Clinica> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Historia_Clinica> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Historia_Clinica> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Historia_Clinica> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Historia_Clinica> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Historia_Clinica> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Historia_Clinica> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Historia_Clinica> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Historia_Clinica, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
