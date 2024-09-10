package xyz.victorl.scrontchback.model.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;
import java.time.format.DateTimeParseException;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, String> {

    @Override
    public String convertToDatabaseColumn(Duration duration) {
        if (duration == null) {
            return null;
        }
        return duration.toString(); // Converts to ISO-8601 string format
    }

    @Override
    public Duration convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            // Try to parse directly from the database string format
            return Duration.parse(dbData);
        } catch (DateTimeParseException e) {
            // Handle PostgreSQL interval format (HH:MM:SS)
            String[] parts = dbData.split(":");
            if (parts.length == 3) {
                long hours = Long.parseLong(parts[0]);
                long minutes = Long.parseLong(parts[1]);
                long seconds = Long.parseLong(parts[2]);
                return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
            }
            throw new IllegalArgumentException("Cannot parse duration: " + dbData, e);
        }
    }
}

