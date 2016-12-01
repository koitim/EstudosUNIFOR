package br.com.koitim.estudosunifor.repository;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

import br.com.koitim.estudosunifor.model.IModel;

/**
 * Created by koitim on 26/11/2016.
 */

public abstract class GenericRepository<T extends IModel> {

    private List<T> list;

    public GenericRepository() {
        list = new ArrayList<>();
    }

    public void insert(T obj) {
        list.add(obj);
    }

    public void update(T obj) {
        //TODO: Fazer quando trabalhar com BD
    }

    public void delete(T obj) {
        list.remove(obj);
    }

    public T find(Long id) {
        // Implementar quando trabalhar com BD
        return null;
    }

    public List<T> findAll() {
        return list;
    }

    public abstract ContentValues getContentVaslues(T obj);
}