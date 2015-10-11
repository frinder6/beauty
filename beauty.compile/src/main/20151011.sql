SELECT DISTINCT
	COLUMN_NAME
FROM
	information_schema.`COLUMNS`
WHERE
	TABLE_SCHEMA = 'beauty'
AND TABLE_NAME NOT IN ('beauty_conf_grid', 'beauty_conf_columns')