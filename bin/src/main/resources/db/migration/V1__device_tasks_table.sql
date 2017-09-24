CREATE TABLE task (
                       id bigint UNIQUE, 
					   task_type VARCHAR(255), 
					   priority int, 
					   tenant_id VARCHAR(255), 
					   device_id VARCHAR(255), 
					   payload VARCHAR(4192),
					   time_queued timestamp,
					   is_cancellable BOOLEAN default true
					   
					   );
					   
CREATE TABLE device_online_status (
					   tenant_id VARCHAR(255), 
					   device_id VARCHAR(255), 
					   status VARCHAR(4192),
					   device_poll_time int,
					   device_last_online_time timestamp
					   );					   
