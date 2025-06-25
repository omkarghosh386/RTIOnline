package nic.rti.master.controller;

import nic.rti.master.dto.DashboardMetricsDTO;
import nic.rti.master.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rti-faa")

public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard-summary")
    public DashboardMetricsDTO getDashboardSummary(
            @RequestParam("appealId") int appealId,
            @RequestParam("appealCode") String appealCode
    ) {
        return dashboardService.getDashboardData(appealId, appealCode);
    }
}
