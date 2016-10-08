#!/usr/bin/env bash

export MEM_SIZE=$1
export JAR_MODULE=/app/$2
export NEWRELIC_CONFIGFILE=$3
export IP=$(/sbin/ip -o -4 addr list eth0 | awk '{print $4}' | cut -d/ -f1)
export NEWRELIC_ARGS="-javaagent:/newrelic/newrelic.jar -Dnewrelic.config.file=/newrelic/config/$NEWRELIC_CONFIGFILE"
export MEM_ARGS="-Xmx$1m -Xss$1m"
export JMX_ARGS="-Dcom.sun.management.jmxremote.rmi.port=3333 \
    -Dcom.sun.management.jmxremote=true \
    -Dcom.sun.management.jmxremote.port=3333 \
    -Dcom.sun.management.jmxremote.ssl=false \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.local.only=false \
    -Djava.rmi.server.hostname=$IP"

echo "Executing java -jar $NEWRELIC_ARGS $MEM_ARGS $JMX_ARGS $MEM_SIZE $JAR_MODULE"
java -jar $NEWRELIC_ARGS $MEM_ARGS $JMX_ARGS $JAR_MODULE