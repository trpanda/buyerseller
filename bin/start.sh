#!/bin/bash
#export PROXY_OPTS="-Dhttp.proxyHost=proxy-src.research.ge.com -Dhttp.proxyPort=8080"
export DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

export  APP_MGMT_URI=https://edgemanager-sysint.grc-apps.svc.ice.ge.com/svc/apps
export  DEFAULT_TENANT_CLIENT_ID=edge-default-app-client
export  DEFAULT_TENANT_CLIENT_SECRET=
export  EM_TENANT_SERVICE_URL=https://edgemanager-sysint.grc-apps.svc.ice.ge.com/svc/tenant/v1/tenant
export  ENROLLMENT_CLIENT_ID=pm-enrollment-client
export  ENROLLMENT_CLIENT_SECRET=
export  ENROLLMENT_TIMESERIES_ZONE_ID=ecdf6e3b-7545-4d83-8270-4994c71a5e77
export  ENROLLMENT_UAA_URL=https://77f263ce-67e4-4834-b4e6-3353c374e252.predix-uaa-staging.grc-apps.svc.ice.ge.com
export  NEW_RELIC_APP_NAME=EdgeManager-R2-int-device
export  RA_CLIENT_ID=caas-app
export  RA_SVC_URL=https://certificate-qa.run.asv-pr.ice.predix.io/cs/v1/certificate
export  RA_TOKEN_URL=https://aa8ca190-36ee-49f1-8bab-c317115fe612.predix-uaa.run.asv-pr.ice.predix.io/oauth/token
export  SERVICE_BASE_DOMAIN=edgemanager-sysint.grc-apps.svc.ice.ge.com
export  SERVICE_ID=predix-edge
export  SPRING_PROFILES_ACTIVE=local
export  TENANT_SERVICE_CLIENT_ID=em-tenant-manager
export  TENANT_SERVICE_CLIENT_SECRET=
export  ASSET_SVC_URL=http://predix-asset-rc.grc-apps.svc.ice.ge.com
export ASSET_SCRIPT_ENG_BASE_DOMAIN=predix-script-engine-rc.grc-apps.svc.ice.ge.com

export COMMAND_URL=https://edgemanager-int.run.aws-usw02-dev.ice.predix.io/svc/command
export DEFAULT_TENANT_CLIENT_ID=default-app-client
export DEFAULT_TENANT_CLIENT_SECRET=
export EDGEGATEWAY_URL= https://default.edgemanager-int.run.aws-usw02-dev.ice.predix.io/svc/gateway
export EM_TENANT_SERVICE_URL=https://edgemanager-int.run.aws-usw02-dev.ice.predix.io/svc/tenant/v1/tenant
export NEW_RELIC_APP_NAME=CF3-integration-em-edgegateway
export SERVICE_BASE_DOMAIN=edgemanager-int.run.aws-usw02-dev.ice.predix.io
export SERVICE_ID=edgemanager-client
export SYNC_INTERVAL_LATENCY=10
export TENANT_SERVICE_CLIENT_ID=em-tenant-manager
export TENANT_SERVICE_CLIENT_SECRET=
export TMS_BASE_URL=tms-release.run.aws-usw02-dev.ice.predix.io
export TMS_CREDS_CLIENT_ID=zac-em-client
export TMS_CREDS_CLIENT_SECRET=
export TMS_CREDS_ZAC_UAA_URL=https://predix-uaa.run.aws-usw02-dev.ice.predix.io/oauth/token
export UAA_URL=https://edgemanager-cf3-int.predix-uaa.run.aws-usw02-dev.ice.predix.io
export ZAC_CLIENT_ID=zac-edgemanager-client
export ZAC_CLIENT_SECRET=
export ZAC_UAA_URL_TOKEN=https://predix-uaa.run.aws-usw02-dev.ice.predix.io/oauth/token
export ZAC_URL=https://predix-zac.run.aws-usw02-dev.ice.predix.io
export SYNC_INTERVAL_FACTOR=0.1
export TASK_TIMEOUT_SYNC_RATE=300000


main() {
    while [ "$1" != "" ]; do
        case $1 in
            'debug')
                JAVA_DEBUG_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5006"
                shift
                ;;
            *)
                break
                ;;
        esac
    done
  
    echo ${DIR}
    cp ${DIR}/target/edge-gateway-*.jar ${DIR}/.edge-gateway-copy.jar
    JAVA_DEBUG_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5006"
    java -Xms1g -Xmx1g $JAVA_DEBUG_OPTS -jar ${DIR}/.edge-gateway-copy.jar 
}
main "$@"
