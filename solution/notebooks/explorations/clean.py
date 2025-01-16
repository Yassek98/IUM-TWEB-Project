import pandas as pd
import numpy as np
import re

# Funzione per pulire i dati in base ai caratteri da sostituire
def clean_columns(movies_df, columns_to_clean, characters_to_replace):
    for col in columns_to_clean:
        # Sostituire i caratteri con NaN per ciascuna colonna
        movies_df[col] = movies_df[col].replace(characters_to_replace, np.nan, regex=False)
    return movies_df


def replace_patterns(movies_df, patterns_to_replace, columns_to_clean):
    for col in columns_to_clean:
        # Sostituire i pattern con NaN in ogni colonna specificata
        movies_df[col] = movies_df[col].replace(patterns_to_replace, np.nan, regex=True)
    return movies_df

# Funzione per rimuovere virgolette esterne
def remove_outer_quotes(text):
    if isinstance(text, str):
        return re.sub(r"^['\"]+|['\"]+$", "", text)
    return text


def remove_outer_quotes_from_columns(movies_df, columns_to_clean):
    # Rimuovere virgolette esterne dalle colonne
    for col in columns_to_clean:
        movies_df[col] = movies_df[col].apply(remove_outer_quotes)
    return movies_df


# Funzione per rimuovere i punti finali dalle stringhe
def remove_trailing_period(text):
    if isinstance(text, str):
        return text.rstrip('.')
    return text


def remove_periods_from_columns(movies_df, columns_to_clean):
    # Rimuovere il punto finale dalle stringhe nelle colonne specificate
    for col in columns_to_clean:
        movies_df[col] = movies_df[col].apply(remove_trailing_period)
    return movies_df


# Funzione per normalizzare le stringhe vuote in NaN
def normalize_empty_to_nan(movies_df, columns_to_clean):
    for col in columns_to_clean:
        movies_df[col] = movies_df[col].apply(lambda x: np.nan if isinstance(x, str) and x.strip() == '' else x)
    return movies_df


# Funzione principale che gestisce la pulizia
def clean_data(movies_df, columns_to_clean, characters_to_replace, patterns_to_replace):
    movies_df = clean_columns(movies_df, columns_to_clean, characters_to_replace)
    movies_df = replace_patterns(movies_df, patterns_to_replace, columns_to_clean)  # Passa anche columns_to_clean
    movies_df = remove_outer_quotes_from_columns(movies_df, columns_to_clean)
    movies_df = remove_periods_from_columns(movies_df, columns_to_clean)
    movies_df = normalize_empty_to_nan(movies_df, columns_to_clean)
    return movies_df


# Funzione per rimuovere duplicati
def remove_duplicates(movies_df, columns_conditions):
    for columns, condition in columns_conditions.items():
        # Allineamento dell'indice della condizione per il DataFrame
        condition_aligned = condition.loc[movies_df.index]  # Allinea l'indice
        duplicati = movies_df[
            movies_df.duplicated(subset=columns, keep='first') & condition_aligned
            ]

        # Rimuovere duplicati
        movies_df = movies_df.drop(duplicati.index)

    return movies_df


# Funzione per ottenere le condizioni di duplicato
def get_columns_conditions(movies_df):
    return {
        ('name', 'description', 'date', 'tagline', 'minute'):(
            movies_df.duplicated(subset=['name', 'description', 'date', 'tagline', 'minute'], keep=False) &
            movies_df['rating'].isna()
        ),
        ('name', 'rating', 'date', 'tagline', 'minute'): (
                movies_df.duplicated(subset=['name', 'rating', 'date', 'tagline', 'minute'], keep=False) &
                movies_df['description'].isna()
        ),
        ('name', 'rating', 'description', 'tagline', 'minute'): (
                movies_df.duplicated(subset=['name', 'rating', 'description', 'tagline', 'minute'], keep=False) &
                movies_df['date'].isna()
        ),
        ('name', 'rating', 'description', 'date', 'minute'): (
                movies_df.duplicated(subset=['name', 'rating', 'description', 'date', 'minute'], keep=False) &
                movies_df['tagline'].isna()
        ),
        ('name', 'rating', 'description', 'date', 'tagline'): (
                movies_df.duplicated(subset=['name', 'rating', 'description', 'date', 'tagline'], keep=False) &
                movies_df['minute'].isna()
        ),
        ('name',): (
                movies_df.duplicated(subset=['name'], keep=False) &
                movies_df[['description', 'tagline', 'minute', 'rating', 'date']].isna().all(axis=1)
        ),
        ('name', 'description', 'date', 'tagline'): (
                movies_df.duplicated(subset=['name', 'description', 'date', 'tagline'], keep=False) &
                movies_df[['minute', 'rating']].isna().all(axis=1)
        ),
        ('name', 'minute', 'date', 'tagline'): (
                movies_df.duplicated(subset=['name', 'minute', 'date', 'tagline'], keep=False) &
                movies_df[['description', 'rating']].isna().all(axis=1)
        ),
        ('name', 'minute', 'description', 'tagline'): (
                movies_df.duplicated(subset=['name', 'minute', 'description', 'tagline'], keep=False) &
                movies_df[['date', 'rating']].isna().all(axis=1)
        ),
        ('name', 'date'): (
                movies_df.duplicated(subset=['name', 'date'], keep=False) &
                movies_df[['description', 'tagline', 'minute', 'rating']].isna().all(axis=1)
        ),
        ('name', 'date', 'minute'): (
                movies_df.duplicated(subset=['name', 'date', 'minute'], keep=False) &
                movies_df[['description', 'tagline', 'rating']].isna().all(axis=1)
        ),
        ('name', 'rating', 'tagline'): (
                movies_df.duplicated(subset=['name', 'rating', 'tagline'], keep=False) &
                movies_df[['description', 'date']].isna().all(axis=1)
        ),
        ('name', 'minute', 'rating'): (
                movies_df.duplicated(subset=['name', 'minute', 'rating'], keep=False) &
                movies_df[['description', 'tagline']].isna().all(axis=1)
        ),
        ('name', 'description'): (
                movies_df.duplicated(subset=['name', 'description'], keep=False) &
                movies_df['rating'].isna()
        ),
        ('name', 'date', 'rating'): (
                movies_df.duplicated(subset=['name', 'date', 'rating'], keep=False) &
                movies_df[['minute', 'tagline']].isna().all(axis=1)
        ),
        ('name', 'description', 'date', 'tagline', 'minute', 'rating'):
            movies_df.duplicated(subset=['name', 'description', 'date', 'tagline', 'minute', 'rating'], keep=False),

    }

