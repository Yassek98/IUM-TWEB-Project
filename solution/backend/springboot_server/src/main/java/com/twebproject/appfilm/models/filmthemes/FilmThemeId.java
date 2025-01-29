package com.twebproject.appfilm.models.filmthemes;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
/**
 * Represents the composite primary key for the FilmTheme entity.
 */
@Embeddable
public record FilmThemeId(
        Long id,
        String theme
) implements Serializable {
    public FilmThemeId {
        // Default constructor provided by record
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmThemeId that = (FilmThemeId) o;
        return Objects.equals(id, that.id) && Objects.equals(theme, that.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme);
    }
}
