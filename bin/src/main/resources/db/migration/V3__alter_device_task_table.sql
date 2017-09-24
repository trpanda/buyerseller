ALTER TABLE task DROP COLUMN  time_queued;
ALTER TABLE task ADD COLUMN  queued_time bigint;

