package com.telandash.intranet.services;

import com.telandash.intranet.models.RoleModel;
import com.telandash.intranet.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleModel> getAll(){
        return roleRepository.findAll();
    }

    public Optional<RoleModel> getById(Long id){
        return roleRepository.findById(id);
    }

    public RoleModel createRole(RoleModel roleModel){
        return roleRepository.save(roleModel);
    }

    public RoleModel updateRole(Long id, RoleModel roleModel){
        return roleRepository.findById(id)
                .map(existing -> {
                    existing.setName(roleModel.getName());
                    return roleRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteRole(Long id){
         roleRepository.deleteById(id);
    }

}
