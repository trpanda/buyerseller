

CREATE TABLE project_user (
                       user_id BIGSERIAL PRIMARY KEY, 
					   user_name VARCHAR(255), 
					   user_type Integer, 
					   );
					   
CREATE TABLE project (
                       project_id BIGSERIAL PRIMARY KEY, 
					   project_name VARCHAR(255), 
					   project_expire timestamp,
					   project_createdby bigint REFERENCES project_user (user_id),
					   );	
					   
CREATE TABLE bid (
                       bid_id BIGSERIAL PRIMARY KEY, 
					   bid_name VARCHAR(255), 
					   bid_value NUMERIC(100,2),
					   bid_rank INTEGER,
					   bid_project_id bigint REFERENCES project (project_id),
					   bid_user_id bigint REFERENCES project_user (user_id)
					   );	
					   
insert into project_user (user_name,user_type) values('seller1',1);
insert into project_user (user_name,user_type) values('seller2',1);
insert into project_user (user_name,user_type) values('seller3',1);

insert into project_user (user_name,user_type) values('bidder1',2);
insert into project_user (user_name,user_type) values('bidder2',2);
insert into project_user (user_name,user_type) values('bidder3',2);
insert into project_user (user_name,user_type) values('bidder4',2);
insert into project_user (user_name,user_type) values('bidder5',2);
insert into project_user (user_name,user_type) values('bidder6',2);
insert into project_user (user_name,user_type) values('bidder7',2);
insert into project_user (user_name,user_type) values('bidder8',2);
insert into project_user (user_name,user_type) values('bidder9',2);
insert into project_user (user_name,user_type) values('bidder10',2);
