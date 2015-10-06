-- 查询当前用户的resource
SELECT DISTINCT
	re.id, re.`code`, re.url, re.`name`
FROM
	beauty_resource re
LEFT JOIN beauty_authority_resource ar ON re.id = ar.resource_id AND type = 2
LEFT JOIN beauty_authority a ON a.id = ar.authority_id
LEFT JOIN beauty_role_authority ra ON ra.authority_id = a.id
LEFT JOIN beauty_role r ON r.id = ra.role_id
LEFT JOIN beauty_user_role ur ON ur.role_id = r.id
LEFT JOIN beauty_user u ON u.id = ur.user_id
WHERE
	u.id = 1
ORDER BY
	re.id;

