package com.zlj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String startTime = "2023-07-13 00:00:00";
        String endTime = "2023-07-113 23:59:59";
        boolean isSameDay = isSameDay(startTime, endTime);
        System.out.println(isSameDay);
    }

    public static boolean isSameDay(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        
        LocalDate startDate = startDateTime.toLocalDate();
        LocalDate endDate = endDateTime.toLocalDate();
        
        return startDate.isEqual(endDate);
    }
}
