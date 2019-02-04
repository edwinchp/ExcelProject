import ExcelScenarios.TagsAndScenarios;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    private static String[] columns = {"Tag", "Scenario", "File"} ;
    private static TagsAndScenarios arrays = new TagsAndScenarios();

    public static void main(String[] args) throws IOException {
        System.out.println("TEST: " + arrays.getNameFileList());

        /*
        ================================================
                        Workbook stuff
        ================================================
        */
        Workbook workbook = new XSSFWorkbook();
        CreationHelper helper = workbook.getCreationHelper();
        // Sheet
        Sheet sheet = workbook.createSheet();
        // Font
        Font headerFont =  workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        //Create a cell style with the FONT
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(headerFont);
        
        // ROW
        Row row = sheet.createRow(0);

        // CELLS
        for (int i = 0; i < columns.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(cellStyle);
        }

        // Cells style for formatting date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(helper.createDataFormat().getFormat("dd-MM-yyyy"));

        // ROWS AND CELLS with arrays data
        int tagNumber = 1;
        int indexScenario = 0;
        int indexScenario3 = 0;
        for(String rowExcel: arrays.getTagsList()){
            Row excelRow = sheet.createRow(tagNumber++);
            excelRow.createCell(0).setCellValue(rowExcel);
            excelRow.createCell(1).setCellValue(arrays.getScenariosList().get(indexScenario++));
            excelRow.createCell(2).setCellValue(arrays.getNameFileList().get(indexScenario3++));

        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output file
        FileOutputStream fileOut = new FileOutputStream("new-excel-file.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();







    }


}
