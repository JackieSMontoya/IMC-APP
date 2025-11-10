package com.example.service;

import com.example.model.IMCRecord;
import com.example.model.User;
import com.example.repository.IMCRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IMCService {

    private final IMCRecordRepository imcRepo;

    public IMCService(IMCRecordRepository imcRepo) {
        this.imcRepo = imcRepo;
    }

    public IMCRecord calculateIMC(User user, double weight) throws Exception {
        if (weight <= 0)
            throw new Exception("Peso inválido");

        double imc = weight / (user.getHeight() * user.getHeight());
        String category;

        if (imc < 18.5)
            category = "Bajo peso";
        else if (imc < 25)
            category = "Normal";
        else if (imc < 30)
            category = "Sobrepeso";
        else
            category = "Obesidad";

        IMCRecord record = new IMCRecord(weight, imc, category, LocalDateTime.now(), user);
        return imcRepo.save(record);
    }

    public List<IMCRecord> getHistory(User user) {
        return imcRepo.findByUser(user);
    }
}
