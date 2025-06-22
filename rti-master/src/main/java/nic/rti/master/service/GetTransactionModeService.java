package nic.rti.master.service;


import nic.rti.master.dao.GetTransactionModeRepository;
import nic.rti.master.entity.TransactionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionModeService {

    @Autowired
    private GetTransactionModeRepository transactionModeRepository;

    public List<TransactionMode> getTransactionMode(){
        return transactionModeRepository.findAll();
    }

}
