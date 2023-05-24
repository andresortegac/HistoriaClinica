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

import com.example.demo.repository.Detalle_Historia_ClinicaRepository;
import com.example.demo.model.Detalle_Historia_Clinica;

@Service

public class Detalle_Historia_ClinicaService implements Detalle_Historia_ClinicaRepository{
	
	@Autowired
	private Detalle_Historia_ClinicaRepository detalle_historia_clinicaRepository;
	
	@Override
	public List<Detalle_Historia_Clinica> findAll() {
		// TODO Auto-generated method stub
		return detalle_historia_clinicaRepository.findAll();
	}
	
	@Override
	public Optional<Detalle_Historia_Clinica> findById(Long id) {
	    List<Detalle_Historia_Clinica> detalles_historias_clinicas = detalle_historia_clinicaRepository.findAll();
	    Optional<Detalle_Historia_Clinica> detalle_historia_clinicaRespuesta = detalles_historias_clinicas.stream()
	            .filter(detalle_historia_clinica -> Long.valueOf(detalle_historia_clinica.getId()).equals(id))
	            .findFirst();
	    return detalle_historia_clinicaRespuesta;
	}
	
	@Override
	public <S extends Detalle_Historia_Clinica> S save(S entity) {
		// TODO Auto-generated method stub
		return detalle_historia_clinicaRepository.save(entity);
	}
	
	@Override
	public void delete(Detalle_Historia_Clinica id) {
		// TODO Auto-generated method 
		detalle_historia_clinicaRepository.delete(id);
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Detalle_Historia_Clinica> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Detalle_Historia_Clinica> entities) {
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
	public Detalle_Historia_Clinica getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detalle_Historia_Clinica getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detalle_Historia_Clinica getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detalle_Historia_Clinica> findAllById(Iterable<Long> ids) {
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
	public void deleteAll(Iterable<? extends Detalle_Historia_Clinica> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Detalle_Historia_Clinica> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Detalle_Historia_Clinica> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Detalle_Historia_Clinica> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Detalle_Historia_Clinica> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Detalle_Historia_Clinica, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
