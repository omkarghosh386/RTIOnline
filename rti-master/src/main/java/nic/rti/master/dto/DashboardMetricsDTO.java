package nic.rti.master.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardMetricsDTO {
    private int appealPending;
    private int newAppeals;
    private int appealsUnderProcess;
    private int commentsReceivedFromPIO;
}
