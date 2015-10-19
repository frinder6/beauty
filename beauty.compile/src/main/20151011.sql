SELECT DISTINCT
	COLUMN_NAME
FROM
	information_schema.`COLUMNS`
WHERE
	TABLE_SCHEMA = 'beauty'
AND TABLE_NAME NOT IN ('beauty_conf_grid', 'beauty_conf_columns')



INSERT INTO beauty_conf_columns (column_name, `data`) SELECT DISTINCT
	COLUMN_NAME,
	COLUMN_NAME
FROM
	information_schema.`COLUMNS`
WHERE
	TABLE_SCHEMA = 'beauty'
AND TABLE_NAME IN ('beauty_conf_columns')
AND COLUMN_NAME NOT IN (SELECT column_name FROM beauty_conf_columns);



INSERT beauty_table_columns (table_name, `data`, column_name, title)
SELECT
	'BEAUTY_TABLE_COLUMNS', `data`, column_name, title
FROM
	beauty_table_columns
WHERE
	column_name IN (
		'data',
		'column_name',
		'title'
	)