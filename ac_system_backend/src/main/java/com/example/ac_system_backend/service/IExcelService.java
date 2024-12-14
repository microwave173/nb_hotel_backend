package com.example.ac_system_backend.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface IExcelService {

    /**
     * 获取账单。
     *
     * @param roomId 房间号
     * @return 返回xlsx的二进制流。
     */
    public ResponseEntity<byte[]> getCostXlsx(String roomId) throws IOException;


    /**
     * 获取详单。
     *
     * @param roomId 房间号
     * @return 返回xlsx的二进制流。
     */
    public ResponseEntity<byte[]> getLogXlsx(String roomId) throws IOException;
}
