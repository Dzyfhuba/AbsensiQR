/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pbo.kel5.packA;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ubaid
 */
public class Main {
    public static void main(String[] args) throws IOException, WriterException, FileNotFoundException, NotFoundException {
        QREngine qr = new QREngine();
        
//        Scanner scn = new Scanner(System.in);
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap 
                = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        
//        qr.createQR("ABC", "ABC_n.jpg", "UTF-8", hashMap, 200, 200);

//        System.out.println(qr.readQR(System.getProperty("user.dir")+"ABC_n.jpg", "UTF-8", hashMap));
        System.out.println(
                qr.readQR(
                        "/home/ubaid/Project/Javas/AbsensiDenganQRCode/ABC_n.jpg",
                        "UTF-8", hashMap));
    }

}
