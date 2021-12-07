package de.exxcellent.challenge.Reader;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.NotImplementedException;

public class DataReaderFactory {
    public DataReader getDataReader(String data) {
        String dataFormat = FilenameUtils.getExtension(data);
        switch (dataFormat) {
            case "csv":
                return new CSVdataReader(data);
            default:
                throw new NotImplementedException("No implemented reader for files of type " +
                        dataFormat + ".");
        }
    }
}
