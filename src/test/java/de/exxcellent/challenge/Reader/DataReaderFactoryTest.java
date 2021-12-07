package de.exxcellent.challenge.Reader;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataReaderFactoryTest {

    // Test exception for file types for which no reader exists
    @Test
    void testDataReaderException1() {
        DataReaderFactory dataReaderFactory = new DataReaderFactory();
        assertThrows(NotImplementedException.class, () -> dataReaderFactory.getDataReader("test.invalidFileFormat"));
    }

    // Test correct selection of CSV reader
    @Test
    void testDataReaderCSVSelection() {
        DataReaderFactory dataReaderFactory = new DataReaderFactory();
        DataReader csvReader = dataReaderFactory.getDataReader("test.csv");
        assertTrue(csvReader instanceof CSVdataReader);

    }

}