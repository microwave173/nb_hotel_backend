package com.example.ac_system_backend.controller;

import com.example.ac_system_backend.pojo.AcRequest;
import com.example.ac_system_backend.service.IAcService;
import com.example.ac_system_backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AcController {
    @Autowired
    IAcService iAcService;

    @Autowired
    IUserService iUserService;

    @Value("${need_cookie}")
    private boolean needCookie;

    @PostMapping("api/turn_on_ac")  // trans ok
//    @CrossOrigin(origins = "*")
    public String turnOnAc(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            iAcService.addAcRequest(acRequest);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @PostMapping("api/turn_off_ac")  // trans ok
//    @CrossOrigin(origins = "*")
    public String turnOffAc(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            iAcService.removeAc(acRequest);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @PostMapping("api/change_ac_params")  // trans ok
//    @CrossOrigin(origins = "*")
    public String changeAcParams(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            iAcService.updateAc(acRequest, "update params");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @PostMapping("api/change_ac_temp")  // trans ok
//    @CrossOrigin(origins = "*")
    public String changeAcTemp(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            AcRequest acRequest1 = iAcService.getAcRequestByRoomId(acRequest.getRoomId());
            acRequest1.setAcTemperature(acRequest.getAcTemperature());
            acRequest1.setCool(acRequest.isCool());
            iAcService.updateAc(acRequest1, "update temperature");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @PostMapping("api/change_ac_mode")  // trans ok
//    @CrossOrigin(origins = "*")
    public String changeAcMode(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            AcRequest acRequest1 = iAcService.getAcRequestByRoomId(acRequest.getRoomId());
            acRequest1.setAcMode(acRequest.getAcMode());
            acRequest1.setCool(acRequest.isCool());
            iAcService.updateAc(acRequest1, "update mode");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @GetMapping("api/tic")
//    @CrossOrigin(origins = "*")
    public void tic(){
        iAcService.tic();
    }

    @GetMapping("api/show_queue")
//    @CrossOrigin(origins = "*")
    public String showQueue(){
        return iAcService.showQueue();
    }
}
