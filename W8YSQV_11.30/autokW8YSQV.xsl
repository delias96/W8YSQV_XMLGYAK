<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Elias Daniel template </h2>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="auto">
		<p>
			<xsl:apply-templates select="@rsz" />
		</p>
	</xsl:template>
	<xsl:template match="@rsz">
		ID:
		<span style="color:black">
			<xsl:value-of select="." />
		</span>
		<br />
	</xsl:template>
</xsl:stylesheet>