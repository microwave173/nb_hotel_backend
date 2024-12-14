package com.example.ac_system_backend.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface IExcelService {
    public ResponseEntity<byte[]> getCostXlsx(String roomId) throws IOException;
    public ResponseEntity<byte[]> getLogXlsx(String roomId) throws IOException;
}
