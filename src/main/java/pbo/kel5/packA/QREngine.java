/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.kel5.packA;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.HybridBinarizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author ubaid
 */
public class QREngine {
    public void createQR(String data, String path, String charset, Map hashMap,
            int height, int weight) throws WriterException, IOException{
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, weight, height);
        MatrixToImageWriter.writeToFile(matrix, path.substring(
        path.lastIndexOf('.') + 1), new File(path));
    }
    
    public String readQR(String path, String charset,
            Map hashMap) throws FileNotFoundException, IOException, NotFoundException{
        BinaryBitmap binaryBitmap
                = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(
                        ImageIO.read(
                            new FileInputStream(path)))));
        Result result
                = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }
}
