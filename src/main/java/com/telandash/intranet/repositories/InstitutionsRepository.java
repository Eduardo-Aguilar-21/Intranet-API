package com.telandash.intranet.repositories;

import com.telandash.intranet.models.InstitutionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionsRepository extends JpaRepository<InstitutionsModel, Long> {
}
