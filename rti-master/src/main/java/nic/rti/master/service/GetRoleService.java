package nic.rti.master.service;


import nic.rti.master.dao.GetRoleRepository;
import nic.rti.master.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRoleService {

    @Autowired
    private GetRoleRepository roleRepository;

    public List<Role> getRole(){
        return roleRepository.findAll();
    }

}
