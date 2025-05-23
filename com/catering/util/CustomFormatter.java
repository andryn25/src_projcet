// Kelas ini membuat custom format untuk tampilan pada log
package com.catering.util;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFormatter extends Formatter {

    // Format timestamp: 2025-05-22 15:30:10.123

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        // 1. Timestamp
        sb.append(sdf.format(new Date(record.getMillis())));
        sb.append(" ");

        // 2. Level log
        sb.append(String.format("%-7s", record.getLevel().getName()));
        sb.append(" ");

        // 3. Nama Logger (Kelas)
        sb.append(record.getLoggerName());
        sb.append(" - ");

        // 4. Pesan
        sb.append(formatMessage(record));

        // 5. Tampilkan stack trace singkat jika ada exception
        if (record.getThrown() != null) {
            sb.append(" : ");
            sb.append(record.getThrown().toString());
        }

        sb.append("\n");
        return sb.toString();
    }
}
