#!/bin/bash

export DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )


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
    cp ${DIR}/target/buyerseller-*.jar ${DIR}/.buyerseller-copy.jar
    JAVA_DEBUG_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5006"
    java -Xms1g -Xmx1g $JAVA_DEBUG_OPTS -jar ${DIR}/.buyerseller-copy.jar 
}
main "$@"
