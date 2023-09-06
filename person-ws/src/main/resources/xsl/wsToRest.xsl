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
     <rs:Party>
       <rs:id><xsl:value-of select="ws:Person/ws:id"/></rs:id>
       <rs:firstName><xsl:value-of select="ws:Person/ws:givenName"/></rs:firstName>
       <rs:lastName><xsl:value-of select="ws:Person/ws:surname"/></rs:lastName>
     </rs:Party>
  </xsl:template>
</xsl:stylesheet>
