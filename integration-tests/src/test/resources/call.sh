#!/bin/sh


#curl -k -X POST https://person-ws-middleware.apps-crc.testing/cxf/person \

curl -X POST http://localhost:8080/customer \
    -H "Content-Type: application/json;charset=UTF-8" \
    -H "Authorization: Bearer $TKN" \
    -d '{ "id": "1",
          "firstName": "Piet",
          "lastName": "Pompies" }'
