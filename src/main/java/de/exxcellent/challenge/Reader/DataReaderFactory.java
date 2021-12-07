package de.exxcellent.challenge.Reader;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.NotImplementedException;


public class DataReaderFactory {

    /**
     * Returns appropriate DataReader based on filetype (file name ending).
     * Will throw an exception if there is no appropriate reader for the data file.
     *
     * @param dataPath Path to the data file with filename and ending
     * @return Appropriate DataReader
     */
    public DataReader getDataReader(String dataPath) {
        String dataFormat = FilenameUtils.getExtension(dataPath);
        switch (dataFormat) {
            case "csv":
                return new CSVdataReader(dataPath);
            default:
                throw new NotImplementedException("No implemented reader for files of type " +
                        dataFormat + ".");
        }
    }
}
