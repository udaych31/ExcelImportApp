package com.hcl.excel.app.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.entity.Transaction;
import com.hcl.excel.app.repository.TransactionRepository;

@Component
public class ExcelImportToDB {

	private static final Logger logger = LogManager.getLogger(ExcelImportToDB.class);

	@Autowired
	private TransactionRepository transactionRepository;

	public ExcelResponse loadDataToDB() {

		ExcelResponse response = new ExcelResponse();
		FileInputStream input = null;
		XSSFSheet sheet = null;
		XSSFWorkbook workbook=null;
		try {

			input = new FileInputStream("C:\\uday\\product.xlsx");
			workbook = (XSSFWorkbook) WorkbookFactory.create((input));

			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			List<Transaction> transactionList=new ArrayList<>();
			Row row;
			int result = 0;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				if (result == 0) {
					result = 1;
				} else {
					int id = (int) row.getCell(0).getNumericCellValue();
					logger.info("id ::" + id);
					int userId = (int) row.getCell(1).getNumericCellValue();
					int productId = (int) row.getCell(2).getNumericCellValue();
					int quantity = (int) row.getCell(3).getNumericCellValue();
					Cell cell = row.getCell(4);
					Date dateCellValue = cell.getDateCellValue();
					logger.info(dateCellValue);
					double price = row.getCell(5).getNumericCellValue();
					String productNm = row.getCell(6).getStringCellValue();
					Transaction transaction = new Transaction();
					transaction.setCreateDt(dateCellValue);
					transaction.setPrice(price);
					transaction.setProductId(productId);
					transaction.setProductName(productNm);
					transaction.setQuantity(quantity);
					transaction.setUserId(userId);

					transaction.setTotalPrice(quantity * price);
					transaction.setTransactionId(id);
					transactionList.add(transaction);
					
				}

			}
			transactionRepository.saveAll(transactionList);
			response.setMessage("success");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
		} finally {
			try {
				if(workbook!=null) {
					workbook.close();
				}
				if(input!=null) {
					input.close();
				}				
				sheet = null;
			} catch (Exception e) {
				logger.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
			}

		}
		return response;
	}

}
