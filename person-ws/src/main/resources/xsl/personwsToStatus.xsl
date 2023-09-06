<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
              xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
              xmlns:fn="http://www.w3.org/2005/xpath-functions"
              xmlns:xs="http://www.w3.org/2001/XMLSchema"
              xmlns:prs="http://tempuri.org/"
              exclude-result-prefixes="xsl fn xs">

<!--
  <xsl:template match="text()"/>
-->

  <xsl:template match="/">
     <prs:PersonStatus>
       <prs:statusCode>SUCCESS</prs:statusCode>
       <prs:message><xsl:value-of select="concat('Successfully processed personws request for ',prs:Person/prs:givenName)"/></prs:message>
     </prs:PersonStatus>
  </xsl:template>
</xsl:stylesheet>

