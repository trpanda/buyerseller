This is buyer seller application

instructions
1) download buyerseller project
2) from main directory Run mvn clean package
3)Then execute ./start.sh to start the server
4) Use any rest client tool such as PostMan to access rest endpoints

Use http://localhost:8080/svc/buyerseller/v1 as base rest url

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


