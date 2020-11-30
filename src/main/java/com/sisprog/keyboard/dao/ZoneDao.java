package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneDao extends JpaRepository<Zone, Long> {
}
