package com.nttdata.exchangerate.repositoryMemory;

import com.nttdata.exchangerate.dto.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetRepositoryMemory extends JpaRepository<Memory, String> {
}
