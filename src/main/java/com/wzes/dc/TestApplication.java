package com.wzes.dc;

import com.wzes.dc.util.GzipUtils;

import java.io.*;

/**
 * @author Create by xuantang
 * @date on 11/14/17
 */
public class TestApplication {
    public static void main(String[] args) {
//        File file = new File("/home/xuantang/Downloads/dictionary.sql");
//        BufferedReader readFile = null;
//        FileReader fileReader = null;
//
//        BufferedWriter writeFile = null;
//        FileWriter fileWriter = null;
//        try {
//            fileReader = new FileReader("/home/xuantang/Downloads/dictionary.sql");
//            readFile = new BufferedReader(fileReader);
//
//            fileWriter = new FileWriter("/home/xuantang/Downloads/dictionary1.csv");
//            writeFile = new BufferedWriter(fileWriter);
//            String line;
//            int i = 0;
//            while ((line = readFile.readLine()) != null) {
//                line = line.replace(");", "")
//                        .replace("INSERT INTO dictionary(pinyin, word, firstLetters, " +
//                                "defaultSort, frequence, latestFlag, createTime, modifyTime) VALUES (", "")
//                        .replace("INSERT INTO `dictionary` VALUES (", "");
//                //System.out.println(line + "\n");
//                writeFile.write(line + "\n");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileReader.close();
//                readFile.close();
//                writeFile.close();
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
        File inFile = new File("/home/xuantang/Downloads/slide.db");
        File outFile = new File("/home/xuantang/Downloads/slide.zip");
        try {
            FileInputStream fileInputStream = new FileInputStream(inFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            int len = fileInputStream.available();
            byte[] conent = new byte[len];
            byte[] buf = new byte[1024];
            int count;
            int index = 0;
            while ((count = bufferedInputStream.read(buf)) != -1) {
                System.arraycopy(buf, 0, conent, index*1024, count);
                index++;
            }
            byte[] compress = GzipUtils.compress(conent);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outFile));

            assert compress != null;
            bufferedOutputStream.write(compress);

            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}