package com.br.fiap.initialvalue.repository;

import com.br.fiap.initialvalue.entities.PropertyInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyInformationRepo extends JpaRepository<PropertyInformation, Long> {
}
