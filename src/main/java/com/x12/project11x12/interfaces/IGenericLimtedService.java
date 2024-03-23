package com.x12.project11x12.interfaces;

import java.util.List;

public interface IGenericLimtedService<T> {
    public List<T>getAll();
    public T getById(Long id) throws Exception;
    public T save(T obj);
    void deleteById(Long id) throws Exception;
    // public List<Scholarship> saveAll(List<Scholarship> scholarships);
}
