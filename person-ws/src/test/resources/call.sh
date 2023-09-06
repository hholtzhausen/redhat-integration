#!/bin/sh


#curl -k -X POST https://person-ws-middleware.apps-crc.testing/cxf/person \

curl -X POST http://localhost:8080/cxf/person \
    -H "Content-Type: text/xml;charset=UTF-8" -H "SOAPAction: http://tempuri.org/process" \
    -H "Authorization: Bearer $TKN" \
    -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
        <soapenv:Header/>
        <soapenv:Body>
        <tem:Person>
        <tem:id>i</tem:id>
        <tem:givenName>Piet</tem:givenName>
        <tem:surname>Pompies</tem:surname>
       </tem:Person>
       </soapenv:Body>
       </soapenv:Envelope>'
