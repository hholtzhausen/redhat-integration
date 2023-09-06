<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
              xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
              xmlns:fn="http://www.w3.org/2005/xpath-functions"
              xmlns:xs="http://www.w3.org/2001/XMLSchema"
              xmlns:prs="http://examples.org/party"
              exclude-result-prefixes="xsl fn xs">

<!--
  <xsl:template match="text()"/>
-->

  <xsl:template match="/">
     <prs:Status>
       <prs:code>SUCCESS</prs:code>
       <prs:description><xsl:value-of select="concat('Successfully processed PERSON party ',prs:Party/prs:firstName)"/></prs:description>
     </prs:Status>
  </xsl:template>
</xsl:stylesheet>

