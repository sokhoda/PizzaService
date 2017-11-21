package web.app.view;

import domain.DomainHelper;
import domain.Pizza;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelView extends AbstractExcelView {

    private static final String SHEET_NAME = "sheet 1";

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Pizza pizza = (Pizza) model.get(DomainHelper.PIZZA);

        Sheet sheet = workbook.createSheet(SHEET_NAME);
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        Row row = null;
        Cell cell = null;
        int rowCount = 0;
        int colCount = 0;

        // Create header cells
        row = sheet.createRow(rowCount++);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue(DomainHelper.PIZZA_ID);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue(DomainHelper.PIZZA_NAME);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue(DomainHelper.PIZZA_TYPE);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue(DomainHelper.PIZZA_PRICE);

        // Create data cells
        row = sheet.createRow(rowCount++);
        colCount = 0;
        row.createCell(colCount++).setCellValue(pizza.getPizzaId());
        row.createCell(colCount++).setCellValue(pizza.getName());
        row.createCell(colCount++).setCellValue(pizza.getType().name());
        row.createCell(colCount++).setCellValue(pizza.getPizzaId());

        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i, true);
        }
    }
}
