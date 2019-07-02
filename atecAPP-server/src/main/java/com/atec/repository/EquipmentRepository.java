package com.atec.repository;

import com.atec.model.Client;
import com.atec.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {


    List<Equipment> findAllByClientId(Long id);
}
