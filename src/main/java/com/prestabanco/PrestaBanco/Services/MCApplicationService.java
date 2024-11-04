package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;
import com.prestabanco.PrestaBanco.Repositories.MCApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MCApplicationService {

    @Autowired
    MCApplicationRepository mcApplicationRepository;

    public MCApplicationEntity saveMCApplication(MCApplicationEntity mcApplicationEntity) {
        return mcApplicationRepository.save(mcApplicationEntity);
    }

}
