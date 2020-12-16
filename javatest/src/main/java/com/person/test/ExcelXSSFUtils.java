package com.person.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @author rainbowPerfect/RainbowPerfect
 * @version v1.0
 * @create 2020/11/9/0:57
 */

public class ExcelXSSFUtils {
    public static void main(String[] args) {
        try {
            readExcel("D:测试2.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readExcel(String excelFile)
            throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(new FileInputStream(excelFile));
        // XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
        if (wb instanceof XSSFWorkbook) {
            XSSFWorkbook workbook = (XSSFWorkbook) wb;
            readWorkbook(workbook);
        } else if (wb instanceof HSSFWorkbook) {
            throw new RuntimeException("该文件是.xls文档，该工具类不支持");
        } else {
            throw new RuntimeException("不支持该类型的文件");
        }
    }

    public static void readWorkbook(XSSFWorkbook workbook) {
        int firstVisibleTab = workbook.getFirstVisibleTab();
        System.err.println("firstVisibleTab=" + firstVisibleTab);
        System.err.println("sheet firstVisibleTab name=" + workbook.getSheetAt(firstVisibleTab).getSheetName());
        System.err.println("Sheet2 name=" + workbook.getSheet("Sheet2").getSheetName());
        System.err.println("sheet 0 name=" + workbook.getSheetAt(0).getSheetName());
        System.err.println("sheet 1 name=" + workbook.getSheetAt(1).getSheetName());
        XSSFSheet sheet = workbook.getSheetAt(firstVisibleTab);
        readSheet(sheet);
    }

    /**
     * 读取Sheet的数据<br>
     * sheet.getRow 下标从0开始计算<br>
     *
     * @param sheet
     */
    public static void readSheet(XSSFSheet sheet) {
        for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            List<Object> rowValue = getRowValue(row);
            System.err.println("rowValue=" + rowValue);
        }
    }

    /**
     * 获取Row的数据<br>
     * row.getCell 下标从0开始计算<br>
     *
     * @param row
     * @return
     */
    public static List<Object> getRowValue(XSSFRow row) {
        List<Object> linked = new LinkedList<Object>();
        XSSFCell cell = null;
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Object value = null;
            cell = row.getCell(i);
            if (cell != null) {
                value = ExcelXSSFUtils.getCellValue(cell);
            }
            linked.add(value);
        }
        return linked;
    }

    /**
     * 获取Cell的值
     *
     * @param cell
     * @return
     */
    public static Object getCellValue(XSSFCell cell) {
        Object value = null;
        if (cell == null) {
            return value;
        }
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                // String类型返回String数据
                value = cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                // 日期数据返回LONG类型的时间戳
                if ("yyyy\"年\"m\"月\"d\"日\";@".equals(cell.getCellStyle().getDataFormatString())) {
                    // System.out.println(cell.getNumericCellValue()+":日期格式："+cell.getCellStyle().getDataFormatString());
                    Date javaDate = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    value = javaDate.getTime() / 1000;
                } else {
                    // 数值类型返回double类型的数字
                    // System.out.println(cell.getNumericCellValue()+":格式："+cell.getCellStyle().getDataFormatString());
                    double a = cell.getNumericCellValue();
                    if (a == (int) (a)) {// 转换成整型
                        value = (int) a;
                    }
                }
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                // 布尔类型
                value = cell.getBooleanCellValue();
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                // 空单元格
                break;
            default:
                value = cell.toString();
        }
        return value;
    }
}