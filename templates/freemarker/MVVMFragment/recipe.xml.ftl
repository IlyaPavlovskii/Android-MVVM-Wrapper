<?xml version="1.0"?>
<recipe>

	<instantiate from="src/app_package/fragments/SimpleFragment.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/${fragmentDir}/${fragmentClass}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${fragmentDir}/${fragmentClass}.java" />

  <instantiate from="src/app_package/viewdata/SimpleViewData.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/${viewDataDir}/${viewDataClass}.java" />
  <open file="${escapeXmlAttribute(srcOut)}/${viewDataDir}/${viewDataClass}.java" />

  <instantiate from="src/app_package/viewmodel/SimpleViewModel.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/${viewModelDir}/${viewModelClass}.java" />
  <open file="${escapeXmlAttribute(srcOut)}/${viewModelDir}/${viewModelClass}.java" />
	
  <#if generateLayout>
  	<instantiate from="res/layout/layout.xml.ftl"
                     to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
  	<open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
	</#if>

</recipe>