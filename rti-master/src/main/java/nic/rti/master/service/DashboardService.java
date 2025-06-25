package nic.rti.master.service;

import nic.rti.master.dao.AppealRepository;
import nic.rti.master.dto.DashboardMetricsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private AppealRepository appealRepository;

    public DashboardMetricsDTO getDashboardData(int appealId, String appealCode) {

        int pendingAppeals = appealRepository.countAppealsPending10Days(appealId, appealCode);

        return new DashboardMetricsDTO(
                pendingAppeals,
                0,  // newAppeals - to be done
                0,  // appealsUnderProcess - to be done
                0   // commentsReceivedFromPIO - to be done
        );
    }
}