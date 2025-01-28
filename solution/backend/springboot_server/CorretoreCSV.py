import csv

input_file = 'C:/Users/yasse/OneDrive/Desktop/YASSEK~1/IUM&TWEB/PROGET~1/IUM-TW~1/NOTEBO~1/csv/movies.csv'
output_file = 'C:/Users/yasse/OneDrive/Desktop/YASSEK~1/IUM&TWEB/PROGET~1/IUM-TW~1/NOTEBO~1/csv/movies_corrected.csv'

with open(input_file, 'r', encoding='utf-8') as infile, open(output_file, 'w', newline='', encoding='utf-8') as outfile:
    reader = csv.reader(infile, delimiter=',', quotechar='"', escapechar='\\', quoting=csv.QUOTE_MINIMAL)
    writer = csv.writer(outfile, delimiter=',', quotechar='"', escapechar='\\', quoting=csv.QUOTE_MINIMAL)
    
    for row in reader:
        # Unisci i campi che contengono ritorni a capo non citati
        corrected_row = []
        for field in row:
            if '\n' in field and not (field.startswith('"') and field.endswith('"')):
                field = '"' + field.replace('"', '""') + '"'
            corrected_row.append(field)
        writer.writerow(corrected_row)

print("CSV file corrected and saved as", output_file)