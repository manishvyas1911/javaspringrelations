package com.mani.controller;

import com.mani.entity.Role;
import com.mani.repository.RoleRepository;
import com.mani.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RoleController {

	@Autowired
    RoleService roleService;


    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return  roleService.addRole(role);
    }
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
    @GetMapping("/role/details/{id}")
    public Role getRole(@PathVariable Long id) {
    	Optional<Role> opRole = roleService.getRoleById(id);
        if(opRole.isPresent()) {
            return opRole.get();
        }
        else { return null;
        }
    }
    @GetMapping("/role/all")
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }
    @PutMapping("/role/update/{id}")
    public ResponseEntity<Object> updateRole(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }


}




