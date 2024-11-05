package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.MCTypesEntity;
import com.prestabanco.PrestaBanco.Repositories.MCTypesRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MCTypesService {

    @Autowired
    MCTypesRepository mcTypesRepository;

    public List<MCTypesEntity> getAll() {
        return new ArrayList<>(mcTypesRepository.findAll());
    }

    @PostConstruct
    public void init() {
        createIfNotFound_1stHome();
        createIfNotFound_2ndHome();
        createIfNotFound_commProp();
        createIfNotFound_remodeling();
    }

    private void createIfNotFound_1stHome(){
        if(mcTypesRepository.findByType("Primera Vivienda")==null){
            mcTypesRepository.save(new MCTypesEntity(
                    null,
                    "Primera Vivienda",
                    30,
                    3.5,
                    5,
                    80
            ));
        }
    }

    private void createIfNotFound_2ndHome(){
        if(mcTypesRepository.findByType("Segunda Vivienda")==null){
            mcTypesRepository.save(new MCTypesEntity(
                    null,
                    "Segunda Vivienda",
                    20,
                    4,
                    6,
                    70
            ));
        }
    }

    private void createIfNotFound_commProp(){
        if(mcTypesRepository.findByType("Propiedades Comerciales")==null){
            mcTypesRepository.save(new MCTypesEntity(
                    null,
                    "Propiedades Comerciales",
                    25,
                    5,
                    7,
                    60
            ));
        }
    }

    private void createIfNotFound_remodeling(){
        if(mcTypesRepository.findByType("Remodelación")==null){
            mcTypesRepository.save(new MCTypesEntity(
                    null,
                    "Remodelación",
                    15,
                    4.5,
                    6,
                    50
            ));
        }
    }
}
