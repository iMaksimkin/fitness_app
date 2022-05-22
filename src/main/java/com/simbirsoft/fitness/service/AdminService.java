package com.simbirsoft.fitness.service;

import com.simbirsoft.fitness.model.user.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmins();
    Admin getAdmin(Long id);
    Admin saveAdmin(Admin admin);
    Admin updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
}
