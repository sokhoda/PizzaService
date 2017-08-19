package web.infrastructure;

import domain.Pizza;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class ExcelPriceListParser implements PriceListParser<Pizza>{

    public static final int MAX_ROWS_TO_SKIP_AT_THE_BEGINNING = 10;

    public List<Pizza> parse(InputStream file){
        Assert.notNull(file, "File cannot be null");

        List<Pizza> pizzas = new ArrayList<>();

        try {
            POIFSFileSystem fs = new POIFSFileSystem(file);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            cols = getCols(sheet, rows);

            for(int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    for(int c = 0; c < cols; c++) {
                        String value = getCellValue(row, c);
                    }
                }
            }
        } catch(Exception ioe) {
            throw new RuntimeException("Error while parsing file", ioe);
        }
        return pizzas;
    }

    private String getCellValue(HSSFRow row, int col) {
        HSSFCell cell;
        cell = row.getCell((short)col);
        if(cell != null) {
            // Your code here
            switch (cell.getCellTypeEnum())
            {
                case NUMERIC:
                    return String.valueOf(cell.getNumericCellValue());
                case STRING:
                    return cell.getStringCellValue();
            }
        }
        return "";
    }

    private int getCols(HSSFSheet sheet, int rows) {
        HSSFRow row;
        int tmp, cols = 0;
        // This trick ensures that we get the data properly even if it doesn't start from first few rows
        for(int i = 0; i < MAX_ROWS_TO_SKIP_AT_THE_BEGINNING || i < rows; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                cols = tmp > cols ? tmp : cols;
            }
        }
        return cols;
    }
}
