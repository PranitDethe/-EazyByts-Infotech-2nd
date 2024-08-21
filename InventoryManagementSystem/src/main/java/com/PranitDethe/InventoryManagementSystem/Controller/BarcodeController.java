package com.PranitDethe.InventoryManagementSystem.Controller;

import com.PranitDethe.InventoryManagementSystem.Util.BarcodeScanner;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/barcode")
public class BarcodeController {

    @PostMapping("/scan")
    public String scanBarcode(@RequestParam("file") MultipartFile file) {
        try {
            byte[] fileBytes = file.getBytes();
            return BarcodeScanner.scanBarcodeFromBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error scanning barcode: " + e.getMessage();
        }
    }
}