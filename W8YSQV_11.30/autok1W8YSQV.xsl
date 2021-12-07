<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Elias Daniel template </h2>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="auto">
		<xsl:for-each select="auto">
			<xsl:sort select="ar" />
			<p>
				<xsl:apply-templates select="@rsz" />
				<xsl:apply-templates select="ar" />
			</p>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="@rsz">
		ID:
		<span style="color:black">
			<xsl:value-of select="." />
		</span>
		<br />
	</xsl:template>
	<xsl:template match="ar">
		AR:
		<span style="color:black">
			<xsl:value-of select="." />
		</span>
		<br />
	</xsl:template>
</xsl:stylesheet>