package com.example.controller;

import com.example.model.IMCRecord;
import com.example.model.User;
import com.example.service.IMCService;
import com.example.controller.UserController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imc")
public class IMCController {

    private final IMCService imcService;
    private final UserController userController;

    public IMCController(IMCService imcService, UserController userController) {
        this.imcService = imcService;
        this.userController = userController;
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestParam double weight) {
        User user = userController.getLoggedInUser();
        if (user == null)
            return ResponseEntity.status(401).body("Usuario no ha iniciado sesión");

        try {
            IMCRecord record = imcService.calculateIMC(user, weight);
            return ResponseEntity.ok(record);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<?> history() {
        User user = userController.getLoggedInUser();
        if (user == null)
            return ResponseEntity.status(401).body("Usuario no ha iniciado sesión");

        List<IMCRecord> history = imcService.getHistory(user);
        return ResponseEntity.ok(history);
    }
}
