package util;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class ConvertDateSQL {

    Date date = new java.sql.Date(0);

    public Date localDateToDate(LocalDate localDate) {
        java.util.Date date = java.sql.Date.valueOf(localDate);
        return date;
    }

    public LocalDate dateToLocalDate(Date date) {
        LocalDate ld = new java.sql.Date(date.getTime()).toLocalDate();
        return ld;
    }
}
