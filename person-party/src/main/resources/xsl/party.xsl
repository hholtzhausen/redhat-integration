<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
              xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
              xmlns:fn="http://www.w3.org/2005/xpath-functions"
              xmlns:xs="http://www.w3.org/2001/XMLSchema"
              xmlns:prs="http://examples.org/party"
              exclude-result-prefixes="xsl fn xs">

  <xsl:template match="/">
     <prs:Party>
       <prs:id><xsl:value-of select="/xml/id"/></prs:id>
       <prs:firstName>Piet</prs:firstName>
       <prs:lastName>Pompies</prs:lastName>
     </prs:Party>
  </xsl:template>
</xsl:stylesheet>

