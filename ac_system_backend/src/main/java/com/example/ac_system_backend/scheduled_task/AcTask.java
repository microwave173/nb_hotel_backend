package com.example.ac_system_backend.scheduled_task;

import com.example.ac_system_backend.service.IAcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AcTask {
    @Autowired
    private IAcService iAcService;

    @Scheduled(fixedRateString = "${ac_settings.ms_per_tic}")
    public void taskPerTic() {
        iAcService.tic();
        iAcService.showQueue();
    }
}
