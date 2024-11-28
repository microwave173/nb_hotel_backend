package com.example.ac_system_backend;

import com.example.ac_system_backend.mapper.UserMapper;
import com.example.ac_system_backend.pojo.AcRequest;
import com.example.ac_system_backend.service.IAcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AcSystemBackendApplicationTests {
    @Autowired
    IAcService iAcService;

    @Test
    void contextLoads() {
        AcRequest ac1 = new AcRequest("0", 23, 0, true);
        AcRequest ac2 = new AcRequest("1", 23, 0, true);
        AcRequest ac3 = new AcRequest("2", 23, 0, true);
        iAcService.addAcRequest(ac1);
        iAcService.addAcRequest(ac2);
        iAcService.addAcRequest(ac3);

    }
}
