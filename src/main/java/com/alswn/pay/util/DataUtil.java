package com.alswn.pay.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class DataUtil {

	private static final CsvMapper mapper = new CsvMapper();
    public static <T> List<T> read(Class<T> clazz, InputStream stream, String fileName) throws IOException {
    	if(clazz.getName().contains("Branch")){
    		CsvSchema schema = CsvSchema.builder()
    	            .addColumn("code")
    	            .addColumn("name")
    	            .build().withHeader();
    		
    		ObjectReader reader = mapper.readerFor(clazz).with(schema);
            return reader.<T>readValues(stream).readAll();

    	} else if (clazz.getName().contains("Customer")){
    		CsvSchema schema = CsvSchema.builder()
    	            .addColumn("acctNo",CsvSchema.ColumnType.STRING)
    	            .addColumn("name",CsvSchema.ColumnType.STRING)
    	            .addColumn("code",CsvSchema.ColumnType.STRING)
    	            .build().withHeader();
    		
    		ObjectReader reader = mapper.readerFor(clazz).with(schema);
            return reader.<T>readValues(stream).readAll();
    	} else {
    		CsvSchema schema = CsvSchema.builder()
    	            .addColumn("trTime",CsvSchema.ColumnType.NUMBER_OR_STRING)
    	            .addColumn("acctNo",CsvSchema.ColumnType.STRING)
    	            .addColumn("seq",CsvSchema.ColumnType.STRING)
    	            .addColumn("trAmt",CsvSchema.ColumnType.NUMBER)
    	            .addColumn("trComm",CsvSchema.ColumnType.STRING)
    	            .addColumn("status",CsvSchema.ColumnType.STRING)
    	            .build().withHeader();
    		
    		ObjectReader reader = mapper.readerFor(clazz).with(schema);
            return reader.<T>readValues(stream).readAll();
    	}
    }

}
