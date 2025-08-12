package com.nucompany.parkingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nucompany.parkingsystem.model.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long> {

}
