package com.example.repository;

import com.example.model.IMCRecord;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IMCRecordRepository extends JpaRepository<IMCRecord, Long> {
    List<IMCRecord> findByUser(User user);
}
