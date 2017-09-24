# Edge Gateway Cloud Service
The Edge Gateway Service deployed in Cloud Foundry 

Run Integration test
from int env
mvn clean verify -DUAA_URL=https://77f263ce-67e4-4834-b4e6-3353c374e252.predix-uaa-staging.grc-apps.svc.ice.ge.com -DCLIENT_ID=edge-default-app-client -DCLIENT_SECRET=edge-default-app-secret -DEDGEGATEWAY_URL=https://edgemanager-int.grc-apps.svc.ice.ge.com/svc/gateway -Pcloud -DUSE_ZONE_ID_HEADER=true -DTENANT_ZONE_ID=edge-default 

local env
mvn clean verify -DUAA_URL=https://77f263ce-67e4-4834-b4e6-3353c374e252.predix-uaa-staging.grc-apps.svc.ice.ge.com -DCLIENT_ID=edge-default-app-client -DCLIENT_SECRET=edge-default-app-secret -DEDGEGATEWAY_URL=http://localhost:8080 -Pcloud -DUSE_ZONE_ID_HEADER=true -DTENANT_ZONE_ID=edge-default

