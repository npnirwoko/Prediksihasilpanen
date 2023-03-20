/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dokumen {
    public ArrayList<ArrayList> load_excel(String filename) {

        ArrayList<ArrayList> data = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(new File(filename));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = (Sheet) workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            ArrayList<String> data_from_excel = new ArrayList<>();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                ArrayList<Double> angka = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        data_from_excel.add(currentCell.getStringCellValue().trim().toLowerCase());
//
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        data_from_excel.add(String.valueOf((double) currentCell.getNumericCellValue()));
                    }

                }
                if(data_from_excel.size() > 0) data.add(data_from_excel);
                data_from_excel = new ArrayList<>();
            }
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
