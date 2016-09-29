#!/usr/bin/env bash
set -x
export MEM_ARGS="-Xmx128m -Xss256k"
export JMX_ARGS="-Dcom.sun.management.jmxremote.rmi.port=3333 \
    -Dcom.sun.management.jmxremote=true \
    -Dcom.sun.management.jmxremote.port=3333 \
    -Dcom.sun.management.jmxremote.ssl=false \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.local.only=false \
    -Djava.rmi.server.hostname=localhost"

java -jar $MEM_ARGS $JMX_ARGS $1