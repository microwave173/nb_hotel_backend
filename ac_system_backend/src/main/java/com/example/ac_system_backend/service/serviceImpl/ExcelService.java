package com.example.ac_system_backend.service.serviceImpl;

import com.example.ac_system_backend.pojo.LogUnit;
import com.example.ac_system_backend.pojo.Room;
import com.example.ac_system_backend.service.IExcelService;
import com.example.ac_system_backend.service.ILogsService;
import com.example.ac_system_backend.service.IRoomService;
import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService implements IExcelService {
    @Value("${ac_settings.mi_per_du}")
    private float miPerDu;

    @Autowired
    IRoomService iRoomService;

    @Autowired
    ILogsService iLogsService;

    @Override
    public ResponseEntity<byte[]> getCostXlsx(String roomId) throws IOException {
        Room room = iRoomService.getRoomByRoomId(roomId);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("房间号");
        header.createCell(1).setCellValue("总花销");
        header.createCell(2).setCellValue("空调花销");

        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue(room.getRoomId());
        row.createCell(1).setCellValue(room.getCost());
        row.createCell(2).setCellValue(room.getDu() * miPerDu);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "room" + roomId + "bill.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(outputStream.toByteArray());
    }

    @Override
    public ResponseEntity<byte[]> getLogXlsx(String roomId) throws IOException {
        List<LogUnit> logs = iLogsService.listLogByRoomId(roomId);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("房间号");
        header.createCell(1).setCellValue("类型");
        header.createCell(2).setCellValue("费率");
        header.createCell(3).setCellValue("总花销");
        header.createCell(4).setCellValue("时间");

        int idx = 1;
        for(LogUnit log : logs){
            Row row = sheet.createRow(idx);
            row.createCell(0).setCellValue(log.getRoomId());
            row.createCell(1).setCellValue(log.getLogType());
            row.createCell(2).setCellValue(log.getCostRate());
            row.createCell(3).setCellValue(log.getCostSum());
            row.createCell(4).setCellValue(log.getLogTime());
            idx += 1;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "room" + roomId + "specific_list.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(outputStream.toByteArray());

    }
}
