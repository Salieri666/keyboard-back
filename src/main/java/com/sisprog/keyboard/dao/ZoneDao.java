package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneDao extends JpaRepository<Zone, Long> {
}
