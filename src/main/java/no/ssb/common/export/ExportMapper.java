package no.ssb.common.export;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.SimpleDateFormat;

public class ExportMapper extends ObjectMapper {

    private static ExportMapper exportMapper = null;

    private ExportMapper() {
        this.registerModule(new JavaTimeModule());
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static ExportMapper getInstance() {
        if (exportMapper == null)
            exportMapper = new ExportMapper();
        return exportMapper;
    }


}
