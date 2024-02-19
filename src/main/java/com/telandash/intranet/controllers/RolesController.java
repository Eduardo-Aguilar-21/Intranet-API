package com.telandash.intranet.controllers;

import com.telandash.intranet.models.RoleModel;
import com.telandash.intranet.models.UsersModel;
import com.telandash.intranet.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleModel>> getAll(){
        List<RoleModel> data = roleService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleModel> getRoleId(@PathVariable Long id){
        Optional<RoleModel> data = roleService.getById(id);
        return data.map(existing -> new ResponseEntity<>(existing, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoleModel> createRole(@RequestBody RoleModel role){
        RoleModel data =roleService.createRole(role);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleModel> updateRole(@PathVariable Long id, @RequestBody RoleModel role){
        RoleModel data = roleService.updateRole(id, role);
        return data != null ?
                new ResponseEntity<>(data, HttpStatus.OK) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleModel> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
