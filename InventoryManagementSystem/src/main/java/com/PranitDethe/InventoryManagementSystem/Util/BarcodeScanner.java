package com.PranitDethe.InventoryManagementSystem.Util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BarcodeScanner {

    public static String scanBarcodeFromFile(File barcodeFile) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(barcodeFile);
        return decodeBarcode(bufferedImage);
    }

    public static String scanBarcodeFromBytes(byte[] barcodeBytes) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(barcodeBytes);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        return decodeBarcode(bufferedImage);
    }

    private static String decodeBarcode(BufferedImage bufferedImage) throws Exception {
        BufferedImageLuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        HybridBinarizer binarizer = new HybridBinarizer(luminanceSource);
        Result result = new MultiFormatReader().decodeWithState(new com.google.zxing.BinaryBitmap(binarizer));
        return result.getText();
    }
}
