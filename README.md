This is buyer seller application

instructions
1) download buyerseller project
2) from main directory Run mvn clean package
3)Then execute ./start.sh to start the server
4) Use any rest client tool such as PostMan or curl command to access rest endpoints
5) This project uses in memory h2 database , hence no need to install any databases for this application.

Use http://localhost:8080/v1 as base rest url

This rest application does not provide any user authentication mechanism.
Instead Use http header User_Id in each rest call to indicate which user is bidding or posting project.
Following are prepopulated users ,UserType 1 is Seller and 2 is Bidder.
SELECT * FROM PROJECT_USER PROJECT_USER ;
USER_ID  	USER_NAME  	USER_TYPE  
1			seller1				1
2			seller2			1
3			seller3			1
4			seller4			1
5			bidder1			2
6			bidder2			2
7			bidder3			2
8			bidder4			2
9			bidder5			2
10			bidder6			2
11			bidder7			2
12			bidder8			2
13			bidder9			2
14			bidder10		2
15			bidder11		2
16			bidder12		2
17			bidder13		2
18			bidder14		2
19			bidder15		2
20			bidder16		2
21			bidder17		2
22			bidder18		2
23			bidder19		2
24			bidder20		2

Sample Payload Project:

{"projectId":0,"projectName":"prjectOne","projectDesc":null,"expiryDateTime":1506272586318,"winnerId":0,"sellerId":1,"winnerBidValue":null,"expired":false}

Sample Payload Bid:

{"projectId":1,"projectName":null,"bidderName":null,"bidUserId":0,"rank":-1,"bidValue":10}

Sample Curl Command:-

1) Create a Project:

curl -X PATCH \
  http://localhost:8080/v1/project \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'user_id: 1' \
  -d '{"projectName":"projectNewTest","projectDesc":null,"expiryDateTime":1506295441806,"winnerId":0,"sellerId":1,"winnerBidValue":null,"expired":false}'
  
  2) Get Project Details
  
  curl -X GET \
  http://localhost:8080/v1/project7 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'user_id: 1' 

   3) Update Project : Extend Expiry Time
   
   curl -X PATCH \
  http://localhost:8080/v1/project \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'user_id: 1' \
  -d '{projectId:"7",projectName":"projectNewTest","projectDesc":null,"expiryDateTime":1506295451806,"winnerId":0,"sellerId":1,"winnerBidValue":null,"expired":false}'
  
  4) Bid for The Project
  
  curl -X POST \
  http://localhost:8080/v1/bid/7 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'user_id: 5' \
  -d '{"bidId":0,"projectId":7,"projectName":null,"bidderName":null,"bidUserId":8,"rank":-1,"bidValue":30}'
  
  5) After Expiry Get Project Details Again To See Which user is winner and winning bid value
  
  curl -X GET \
  http://localhost:8080/v1/project7 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'user_id: 1'  

