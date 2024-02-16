package com.telandash.intranet.repositories;

import com.telandash.intranet.models.InstitutionsTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionsTypeRepository extends JpaRepository<InstitutionsTypeModel, Long> {
}
