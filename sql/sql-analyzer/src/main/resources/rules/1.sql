CREATE TABLE delete_with_true_condition_info AS
SELECT
  1 AS rule_id,
  STRING_AGG(q.id::text, ',') AS query_ids
FROM
  query_analysis_model q
  JOIN query_context qc ON q.query_context_id = qc.id
  JOIN where_clause wc ON qc.where_clause_id = wc.id
WHERE
  q.query_type = 'DELETE'
  AND wc.has_true_condition = true;