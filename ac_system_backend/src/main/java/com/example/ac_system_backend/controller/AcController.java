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

    @PostMapping("api/turn_on_ac")
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

    @PostMapping("api/turn_off_ac")
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

    @PostMapping("api/change_ac_params")
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

    @PostMapping("api/change_ac_temp")
    public String changeAcTemp(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            AcRequest acRequest1 = iAcService.getAcRequestByRoomId(acRequest.getRoomId());
            acRequest1.setAcTemperature(acRequest.getAcTemperature());
            iAcService.updateAc(acRequest1, "update temperature");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @PostMapping("api/change_ac_mode")
    public String changeAcMode(@RequestBody AcRequest acRequest, @CookieValue("token") String token){
        if(needCookie && !iUserService.checkUser(token)) return "failed";
        try{
            AcRequest acRequest1 = iAcService.getAcRequestByRoomId(acRequest.getRoomId());
            acRequest1.setAcMode(acRequest.getAcMode());
            iAcService.updateAc(acRequest1, "update mode");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "failed";
        }
        return "success";
    }

    @GetMapping("api/tic")
    public void tic(){
        iAcService.tic();
    }

    @GetMapping("api/show_queue")
    public String showQueue(){
        return iAcService.showQueue();
    }
}
