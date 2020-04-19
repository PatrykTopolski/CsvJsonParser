package com.patryk.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.patryk.model.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.util.Collections;
import java.util.List;

@Repository
public class CsvReader implements DataReader{

    public  List<User> ReadData( String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';')
                    .withoutQuoteChar();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<User> readValues =
                    mapper.reader(User.class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
