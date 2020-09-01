package org.sid.service;

import java.util.List;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.AppUserRepository;
import org.sid.entities.Role;
import org.sid.entities.ApUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ApUser saveUser(String username, String password, String confirmedPassword) {
        ApUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        ApUser appUser=new ApUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public Role save(Role role) {
        return appRoleRepository.save(role);
    }

    @Override
    public ApUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        ApUser appUser=appUserRepository.findByUsername(username);
        Role appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }

	@Override
	public  List<ApUser> getAllUsers() {
		return appUserRepository.findAll();
	
	}
}
