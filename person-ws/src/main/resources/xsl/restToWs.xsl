<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
              xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
              xmlns:fn="http://www.w3.org/2005/xpath-functions"
              xmlns:xs="http://www.w3.org/2001/XMLSchema"
              xmlns:ws="http://tempuri.org/"
              xmlns:rs="http://examples.org/party"
              exclude-result-prefixes="xsl fn xs">

  <xsl:template match="text()"/>

  <xsl:template match="/">
     <ws:PersonStatus>
       <ws:statusCode><xsl:value-of select="rs:Status/rs:code"/></ws:statusCode>
       <ws:message><xsl:value-of select="rs:Status/rs:description"/></ws:message>
     </ws:PersonStatus>
  </xsl:template>
</xsl:stylesheet>

