#!/usr/bin/env bash

# run inside docker container
export DISCOVERY_URL=ds-toolbox-discovery-service:8080
export CONFIG_URL=ds-toolbox-config-service:8080
export CMD=${@:1}
/scripts/wait-for-it.sh -t 60 -s $DISCOVERY_URL -- /scripts/wait-for-it.sh -t 60 -s $CONFIG_URL -- $CMD