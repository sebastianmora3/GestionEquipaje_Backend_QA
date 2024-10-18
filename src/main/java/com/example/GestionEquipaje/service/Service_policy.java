package com.example.GestionEquipaje.service;

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

import com.example.GestionEquipaje.model.CollectionPolitic;
import com.example.GestionEquipaje.repository.Repository_politic;

@Service
public class Service_policy implements Repository_politic{

    @Autowired
    private Repository_politic repository_policy;

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllInBatch(Iterable<CollectionPolitic> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CollectionPolitic getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CollectionPolitic getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CollectionPolitic getReferenceById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CollectionPolitic> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CollectionPolitic> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> S save(S entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<CollectionPolitic> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(CollectionPolitic entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll(Iterable<? extends CollectionPolitic> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CollectionPolitic> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<CollectionPolitic> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> long count(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends CollectionPolitic, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
