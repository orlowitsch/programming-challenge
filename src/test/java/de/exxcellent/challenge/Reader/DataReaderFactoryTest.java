package de.exxcellent.challenge.Reader;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataReaderFactoryTest {

    @Test
    void testDataReaderException1() {
        DataReaderFactory dataReaderFactory = new DataReaderFactory();
        assertThrows(NotImplementedException.class, () -> dataReaderFactory.getDataReader("test.invalidFileFormat"));
    }

    @Test
    void testDataReaderException2() {
        DataReaderFactory dataReaderFactory = new DataReaderFactory();
        DataReader csvReader = dataReaderFactory.getDataReader("test.csv");
        assertTrue(csvReader instanceof CSVdataReader);

    }

}