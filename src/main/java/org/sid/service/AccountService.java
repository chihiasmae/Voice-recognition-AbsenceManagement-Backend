package org.sid.service;

import org.sid.entities.Role;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.sid.entities.ApUser;
@CrossOrigin("*")
public interface AccountService {
    public ApUser saveUser(String username,String password,String confirmedPassword);
    public Role save(Role role);
    public ApUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public List<ApUser>  getAllUsers();
}
