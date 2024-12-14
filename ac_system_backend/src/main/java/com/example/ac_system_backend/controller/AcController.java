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

    /**
     * 开启空调。
     *
     * @param acRequest 空调请求信息（房间号、模式、温度等）
     * @param token     用户认证的 Cookie
     * @return 返回 "success" 表示成功，"failed" 表示失败
     */
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

    /**
     * 关闭空调。
     *
     * @param acRequest 空调请求信息
     * @param token     用户认证的 Cookie
     * @return 返回 "success" 表示成功，"failed" 表示失败
     */
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

    /**
     * 更改空调的参数（如风速、湿度等）。
     *
     * @param acRequest 空调请求信息
     * @param token     用户认证的 Cookie
     * @return 返回 "success" 表示成功，"failed" 表示失败
     */
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

    /**
     * 更改空调的温度设置。
     *
     * @param acRequest 空调请求信息（包括房间号和目标温度）
     * @param token     用户认证的 Cookie
     * @return 返回 "success" 表示成功，"failed" 表示失败
     */
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

    /**
     * 更改空调的运行模式。
     *
     * @param acRequest 空调请求信息（包括房间号和目标模式）
     * @param token     用户认证的 Cookie
     * @return 返回 "success" 表示成功，"failed" 表示失败
     */
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

    /**
     * 调试用：更新系统时间步。
     * 模拟时间步的推进，用于测试系统运行。
     */
    @GetMapping("api/tic")
//    @CrossOrigin(origins = "*")
    public void tic(){
        iAcService.tic();
    }

    /**
     * 调试用：展示当前的服务队列和等待队列。
     *
     * @return 返回服务队列和等待队列的状态信息
     */
    @GetMapping("api/show_queue")
//    @CrossOrigin(origins = "*")
    public String showQueue(){
        return iAcService.showQueue();
    }
}
