<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
	<body>
	<h2>Hallgatok adatai:</h2>
	<table border="1">
	<tr><th>id</th><th>Vezeteknev</th><th>Keresztnev</th><th>Becenev</th><th>Kor</th><th>Fokozat</th></tr>
	<xsl:for-each select="class/student">
	<tr>
	<td><xsl:value-of select="@id"></xsl:value-of></td>
	<td><xsl:value-of select="vezeteknev"></xsl:value-of></td>
	<td><xsl:value-of select="keresztnev"></xsl:value-of></td>
	<td><xsl:value-of select="becenev"></xsl:value-of></td>
	<td><xsl:value-of select="kor"></xsl:value-of></td>
	 <xsl:choose>
        <xsl:when test="fizetes &gt;= 0">
          <td>Alacsony</td>
        </xsl:when>
                <xsl:when test="fizetes &gt;= 300000 and fizetes &lt;= 1000000">
          <td>Közepes</td>
        </xsl:when>
                <xsl:when test="fizetes &gt;= 1000000 ">
          <td>Magas</td>
        </xsl:when>
        <xsl:otherwise>
          <td>Nem ertelmezheto</td>
        </xsl:otherwise>
      </xsl:choose>
	</tr>
	</xsl:for-each>
	</table>
	</body>
	</html>
	</xsl:template>
</xsl:stylesheet>