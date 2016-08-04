<?xml version="1.0"?>
<recipe>

	<instantiate from="src/app_package/activity/SimpleActivity.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/${activityDir}/${activityClass}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${activityDir}/${activityClass}.java" />

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

  <merge from="AndroidManifest.xml.ftl"
               to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

</recipe>

<!--
<dependency mavenUrl="com.android.support:support-v4:${buildApi}.+" />

    <merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <merge from="root/res/values/attrs.xml"
             to="${escapeXmlAttribute(resOut)}/values/attrs.xml" />
    <merge from="root/res/values/colors.xml"
             to="${escapeXmlAttribute(resOut)}/values/colors.xml" />
    <merge from="root/res/values/styles.xml.ftl"
              to="${escapeXmlAttribute(resOut)}/values/styles.xml" />
    <instantiate from="root/res/layout/activity_fullscreen.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

    <merge from="root/res/values/strings.xml.ftl"
             to="${escapeXmlAttribute(resOut)}/values/strings.xml" />

    <instantiate from="root/src/app_package/FullscreenActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${activityClass}.java" />

    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
-->
