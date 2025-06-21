package nic.rti.master.service;

import nic.rti.master.dao.MasUserRepository;
import nic.rti.master.entity.MasUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasUserService {

    @Autowired
    private MasUserRepository masUserRepository;

    public List<MasUser> getUsers() {
        List<MasUser> users = masUserRepository.getUsers();
        return users;
    }
}
