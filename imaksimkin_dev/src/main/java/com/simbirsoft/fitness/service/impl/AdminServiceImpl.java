package com.simbirsoft.fitness.service.impl;

import com.simbirsoft.fitness.model.user.Admin;
import com.simbirsoft.fitness.repository.AdminRepository;
import com.simbirsoft.fitness.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdmin(Long id) {
        return adminRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(
                Admin.builder()
                        .name(admin.getName())
                        .surname(admin.getSurname())
                        .lastname(admin.getLastname())
                        .birthday(admin.getBirthday())
                        .phone(admin.getPhone())
                        .password(admin.getPassword())
                        .build()
        );
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Admin currentAdmin = getAdmin(id);
        currentAdmin.setName(admin.getName());
        currentAdmin.setSurname(admin.getSurname());
        currentAdmin.setLastname(admin.getLastname());
        currentAdmin.setBirthday(admin.getBirthday());
        currentAdmin.setPhone(admin.getPhone());
        currentAdmin.setPassword(admin.getPassword());
        return adminRepository.save(currentAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
