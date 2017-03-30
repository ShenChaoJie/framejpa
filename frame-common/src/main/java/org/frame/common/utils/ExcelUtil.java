package org.frame.common.utils;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * TODO ExcelUtil
 * 
 * @author zjy
 * @version 1.0
 *          <p>
 *          <b>功能说明：</b>Excel工具类
 *          </p>
 *          <p>
 *          <b>创建时间：</b>2011-6-21
 *          </p>
 *          <p>
 *          <b>修改时间：</b>2011-6-21
 *          </p>
 */
public class ExcelUtil {

	/**
	 * 
	 * 功能：读取simId
	 * 
	 * @author zjy
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> readSimId(InputStream input, int first, int last) throws Exception {
		Map<String, String> rMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(input);
		Sheet sheet0 = wb.getSheetAt(0);
		for (int i = first; i < last; i++) {
			Row row = sheet0.getRow(i);
			for (Cell cell : row) {
				String simId = getCellValue(cell);
				if (StringUtils.isNotBlank(simId) && StringUtils.isNumeric(simId.trim()))
					rMap.put(simId.trim(), null);
			}
		}
		return rMap;
	}

	/**
	 * 
	 * 功能：获得单元格的值
	 * 
	 * @author zjy
	 * @param cell
	 * @return
	 */
	public static String getCellValue(Cell cell) {
		String result = null;

		switch (cell.getCellType()) {
		// 读取布尔值
		case Cell.CELL_TYPE_BOOLEAN:
			result = Boolean.toString(cell.getBooleanCellValue());
			break;
		// 读取日期或者数字
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				result = new SimpleDateFormat("yyyy-mm-dd").format(cell.getDateCellValue());
			} else {
				result = new DecimalFormat("#").format(cell.getNumericCellValue());
			}
			break;
		// 读取公式
		case Cell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;
		// 读取字符串
		case Cell.CELL_TYPE_STRING:
			result = cell.getRichStringCellValue().toString();
			break;
		}

		return result;
	}

}
