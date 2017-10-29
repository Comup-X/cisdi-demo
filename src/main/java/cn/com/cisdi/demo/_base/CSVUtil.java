package cn.com.cisdi.demo._base;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Comup
 */
public class CSVUtil {
    private CSVUtil() {
    }

    /**
     * 改变值
     *
     * @param fileToUpdate 操作的文件
     * @param replace      新值
     * @param row          行
     * @param col          列
     * @throws IOException 文件读写异常
     */
    public static void setCSVField(String fileToUpdate, String replace,
                                   int row, int col) throws IOException {
        synchronized (fileToUpdate.intern()) {
            File inputFile = new File(fileToUpdate);
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            List<String[]> csvBody = reader.readAll();
            csvBody.get(row)[col] = replace;
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        }
    }

    /**
     * 删除行
     *
     * @param fileToUpdate 操作的文件
     * @param row          需要删除的行
     * @throws IOException 文件操作异常
     */
    public static void delCSVRow(String fileToUpdate, int row) throws IOException {
        synchronized (fileToUpdate.intern()) {
            File inputFile = new File(fileToUpdate);
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            List<String[]> csvBody = reader.readAll();
            csvBody.remove(row);
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        }
    }

    /**
     * 删除列
     *
     * @param fileToUpdate 操作的文件
     * @param col          需要删除的列
     * @throws IOException 文件操作异常
     */
    public static void delCSVColumn(String fileToUpdate, int col) throws IOException {
        synchronized (fileToUpdate.intern()) {
            File inputFile = new File(fileToUpdate);
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            List<String[]> csvBody = reader.readAll();
            List<String[]> toWrite = new ArrayList<>();
            csvBody.forEach(column -> {
                ArrayList<String> strings = new ArrayList<>(Arrays.asList(column));
                strings.remove(col);
                toWrite.add(strings.toArray(new String[]{}));
            });
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
            writer.writeAll(toWrite);
            writer.flush();
            writer.close();
        }
    }
}