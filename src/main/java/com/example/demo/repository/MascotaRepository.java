package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;
import com.example.demo.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{

}
