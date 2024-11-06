package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;
import com.prestabanco.PrestaBanco.Services.MCApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mc-application")
@CrossOrigin("*")
public class MCApplicationController {

    @Autowired
    private MCApplicationService mcApplicationService;

    @PostMapping
    public ResponseEntity<MCApplicationEntity> createMCApplication(@RequestBody MCApplicationEntity mcApplicationEntity) {
        MCApplicationEntity savedApplication = mcApplicationService.saveMCApplication(mcApplicationEntity);
        return ResponseEntity.ok(savedApplication);
    }
}