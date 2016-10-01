#!/usr/bin/env bash

export MEM_SIZE=$1
export JAR_MODULE=$2
export IP=$(/sbin/ip -o -4 addr list eth0 | awk '{print $4}' | cut -d/ -f1)
export MEM_ARGS="-Xmx$1m -Xss256k"
export JMX_ARGS="-Dcom.sun.management.jmxremote.rmi.port=3333 \
    -Dcom.sun.management.jmxremote=true \
    -Dcom.sun.management.jmxremote.port=3333 \
    -Dcom.sun.management.jmxremote.ssl=false \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.local.only=false \
    -Djava.rmi.server.hostname=$IP"

echo "Executing java -jar $MEM_ARGS $JMX_ARGS $MEM_SIZE $JAR_MODULE"
java -jar $MEM_ARGS $JMX_ARGS $JAR_MODULE