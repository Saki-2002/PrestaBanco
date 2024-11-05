package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.UserEntity;
import com.prestabanco.PrestaBanco.Services.UserService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public ResponseEntity<?> register (@RequestBody Map<String, Object> requestData){
        String name = requestData.get("name").toString();
        String password = requestData.get("password").toString();
        String role = requestData.get("role").toString();

        UserEntity user = userService.register(name, password, role);
        if(user!=null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ya existe un usuario con ese nombre");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, Object> requestData){
        String name = requestData.get("name").toString();
        String password = requestData.get("password").toString();

        UserEntity user = userService.login(name, password);
        if(user!=null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o Contraseña incorrectas");
        }
    }

}
