SELECT DISTINCT
	COLUMN_NAME
FROM
	information_schema.`COLUMNS`
WHERE
	TABLE_SCHEMA = 'beauty'
AND TABLE_NAME NOT IN ('beauty_conf_grid', 'beauty_conf_columns')



INSERT INTO beauty_schema_columns (column_name, `data`) SELECT DISTINCT
	COLUMN_NAME,
	COLUMN_NAME
FROM
	information_schema.`COLUMNS`
WHERE
	TABLE_SCHEMA = 'beauty'
AND COLUMN_NAME NOT IN (SELECT column_name FROM beauty_schema_columns);



INSERT beauty_table_columns (table_name, `data`, column_name, title, column_id)
SELECT
	'BEAUTY_TABLE_COLUMNS', `data`, column_name, title, id
FROM
	beauty_schema_columns
WHERE
	column_name IN (
		'editable'
	)