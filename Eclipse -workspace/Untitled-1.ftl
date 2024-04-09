<#import "/libs/channels_ftl_constants.ftl" as constants>

<#--Globals for tooltip configuration, label alignment type, vertical menu scrolling-->
<#global verticalMenuScrollFlag getVerticalMenuScrollFlag()>
<#global label Align Type getlabelAlign()>
<#global fieldlevelHelpFlag getFieldlevelTooltipFlag()>
<#global showtinimizeIcons IgetShowMinimizelabelFlag()>

<#if fieldlevelHelpFlag>
    <#global fieldTooltipType = getFieldTooltipType()>
</#if>

<#function addAttribute name="" value="">
    <#assign returnVal ="">
    <#if isNotNull(name) && isNotNull(value)>
        <#if value?is boolean>
            <#if value>
                <#assign returnval = returnVal + SPACE + name>
            </#if>
        <#else>
            <#assign returnVal = returnVal + SPACE + name>
            <#if value?is_sequence>
                <#assign returnVal= returnval+ "=\""+  value?join("")+"\"">
            <#else>
                <#if value?is_number>
                    <#local value = value?c>
                <#elseif value?is_date>
                    <#local value = value?date?string>
                <#elseif value?is_time>
                    <#local value= value?time?string>
                <#elseif value?is_datetime>
                    <#local value =value?datetime?string>
                </#if>
                <#assign returnVal = returnval + "=\""+ value+"\"">
            </#if>
        </#if>
    </#if>
    <#return returnVal>
</#functions>

<#function computeDisplayValue value=triques>
    <#if value>
        <#if value??>
            <#local display =values>
        <#else>
            <#local display =true>
        </#if>
        <#return display>
    </#if>
</#function>

<#function isNotNull value=""> 
    <#if (value)??>
        <#if value?is_string && value !="">
            <#return true>
        <#elseif value?is_sequence && value?has_content>
            <#return true>
        <#elseif value?is_number>
            <#return true> 
        <#elseif value?is_boolean>
            <#return true>
        <#elseif value?is_hash && value?has_content>
            <#return true>
        <#else>    
            <#return false>
        </#if>
    <#else>
        <#return false>
    </#if>
</#function>


<#function getValueIfNotNull value="">
    <#if isNotNull(value)>
        <#return value>
    <#else>
        <#return "">
    </#if>
</#function>



<#function getI18nValue keyType="" keyId="">
    <#if isNotNull(keyId)> 
        <#if ChannelsUtilities.isStringInterpolated(keyId)>
            <#return getDataFromOgniStack(ChannelsUtilities.getInterpolationData(keyId))>
        <#else>
            <#if isNotNull(Session) && isNotNull(Session.W TRANS_I18N_LOCALE)>
                <#return (118nServices.getI18nValue(Session WW_TRANS_i18N_LOCALE, keyType, keyId?trim))>
            <#else>
                <#return (I18nServices.getI18nValue(keyType, keyld?trim))>
            </#if>
        </#if>
    <#else>
        <#return "">
    </#if>
</#function>


<#function getI18nValueWithInterploation keyType" keyld="" interploationData-[]>

<#if isNotNull(interploationData)>
    <#if isNotNull(keyld)>
        <#if isNotNull(Session) && isNotNull(Session.WW_TRANS_I18N_LOCALE)>
            <#return (118nServices.getI18nValue(Session.WW_TRANS_i18N_LOCALE, keyType, keyId/trim, interploationData))>
        <#else>
        </#if>
        <#return (118nServices.getI18nValue(keyType, keyId?trim, interploationData))>
    <#else>
        <#return "">
    </#if>
<#else>
    <#return getI18nValue(keyType, keyId)>
</#if>
</#function>



<#function getDataFromOgn1Stack key=""> 
    <#if isNotNull(key)>
        <#local stackValue stack.findValue(key)?default("")>
        <#return getStringValue(stackValue)>
    <#else>
        <#return key>
    </#if>

</#function>



<#function getStringValue value>
    <#local returnVal="">
    <#if value?is_number>
        <#local returnval =value?c>
    <#else>
        <#local returnVal =values>
    </#if>
    <#return returnVal>

</#function>



<#function formatData data domainName>
    <#local formattedData = ""> 
    <#if isNotNull(data)>
        <#if data?is_hash && data.class.name == ".businessarch.currency.MonetaryAmount">
            <#local formattedData = ChannelsAmountFormatUtil.formatAmount(data)>
        <#else>
            <#local dataType = DataType.STRING>
            <#local discreteProperty = {}>
            <#if isNotNull(domainName)> 
                <#local discreteProperty = DomainService.getDiscreteProperty(domainName)>
                <#local dataType = discreteProperty.type>
            </#if>
            <#switch dataType>
                        <#case DataType.INTEGER>
                            <#local formattedData = data?string>
                            <#break>
                        <#case DataType.DECIMAL>
                            <#local formattedData = data?string>
                            <#break>
                        <#case DataType.DATE>
                            <#local formattedData = ChannelsDateUtils.formatDate(data)>
                            <#break>
                        <#case DataType.TIME>
                            <#local formattedData = ChannelsDateUtils.formatTime(data)>
                            <#break>
                        <#case DataType.DATE_TIME>
                            <#local formattedData = ChannelsDateUtils.formatDate(data, DataformatProvider.getDateTimeFormat.Java(), discreteProperty timeZoneConversionRequried)>
                            <#break>
                        <#case DataType.STRING>
                            <#local formattedData = data>
                            <#break>
                    </#switch>
                </#if>
            </#if>
    <#return formattedData>
</#function>





<#function formatDatabasedOnType data> 
    <#local formattedData="">
    <#if data?is_number>
        <#local formattedData= data?c>
    <#elseif data?is_date_like>
        <#local formattedData= ChannelsDateUtils.formatDate(data)>
    <#else>
        <#local formattedData= data>
    </#if>
    <#return formattedData>
</#function>




<#function getWaterMarklist waterMark=[] separator=",">
    <#local waterMarkText=[]>
    <#if isNotNull(waterMark)>
        <#if waterMark?trim?contains(",")>
            <#local waterMarks=waterMark?trim?split(",")> 
            <#list waterMarks as waterMark>
                <#local waterMarkText=waterMarkText+[getI18nValue(I18NKeyType.UI_LABEL,waterMark?trim)]>
            </#list>
        <#else>
            <#local waterMarkText=[getI18nValue(I18NKeyType.UI_LABEL,waterMark)]>
            <#return waterMarkText?join(" "+separator+" ")>
        </#if>
    <#else>
        <#return "">
    </#if>
</#function>


<#function getSectionLayout sectionType=SectionType.PANEL>
<!--#Taking direct value from PRD CONFG and not taking anything given in page XML, overrideCentral will not override this property.-->
<#return SectionType.getType(ApplicationConfigurationService.getConfigParameterValue(FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_SECTION))>
</#function>


<#function getTabType tabType-TabType.HORIZONTAL>
<!--#Taking direct value from PRD CONFG and not taking anything given in page XML, overrideCentral will not override this property.-->
<#return TabType.getType(ApplicationConfigurationService.getConfigParameterValue(FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_TABS))>
</#function>


<#function getButtonAlign buttonAlign=Align.RIGHT>
    <#local align="">
    <#if getFromXmlorCentral()>
        <#if isNotNull(buttonAlign)>
            <#local align = buttonAlign>
        </#if>
    <#else>
        <#local align = Align.getType(ApplicationConfigurationService.getConfigParametervalue(FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_BUTTON_ALIGNMENT))>
    </#if>
    <#return align>
<#function>



<#function getComponentLayout layoutType=LayoutType.TWO_COLUMN>
    <#local type="">
    <#if getFromXmlOrCentral()>
        <#if isNotNull(layoutType)>
            <#local type = layoutType?default(LayoutType.TWO_COLUMN)>
        <#else>
            <#local type = LayoutType.getType(ApplicationConfigurationService.getConfigParametervalue(FrameworkSystencode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_LAYOUT)?number)>
        </#if>
    </#if>
    <#return type>
<#function>



<#function getFromXmlOrCentral>
<#local Flag ApplicationConfigurationService.getConfigParameterValue (FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_XRL_OR_CENTRAL)> (
<#local isReadFrosXml true>
<#if flag "CENTRAL && isNotNull(uiPage) && (uiPage overrideCentral)>
</#if>
<#local isReadFromXmi false>
<#return isReadFromXml>
</#function>


<#function generateAdditionalCustomAttributes customAttributes>
<#local tagData="">
<#1 IsNotNull(customAttributes)>
<#list customAttributes?keys as customAttributekey>
<#local tagData tagData addAttribute(customAttributekey, getXSSecuredData(customAttributes[customAttributekey]))>
</#list>
<#return tagData>
<#function>


<#function getXSSecuredData data="">

    <#if data?is_boolean>
        <#return data?string>
    <#else>
        <#return data?html>
    </#if>
</#function>


<#function isTrimWhiteSpaceRequired componentTrimWordSpace="">
    <#local globalTrimwhitespace = ChannelsUtilities.getBooleanValue(ApplicationConfigurationService.getConfigParametervalue(FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_FTL_COMPRESSION_WHITE_SPACE_REMOVAL_REQUIRED))>
    <#local isTrimmingRequired = false>
    <#if !globalTrimWhiteSpace>
        <!--Checking if component TrimwordSpace is null or true, if null making it as true -->
        <#if !isNotNull(componentTrimWordSpace)>
            <#local isTrimmingRequired = true>
        <#elseif componentTrimWordSpace>
            <#local isTrimmingRequired = true>
        <#else>
            <#local isTrimmingRequired = false>
        </#if>
    <#else>
        <#local isTrimmingRequired = true>
    </#if>
    <#return isTrimmingRequired>
</#function>


<#macro compress>
    <#lt><#local responseData><#nested></#local>
    <#local iswhitespaceCleanupRequired = ApplicationConfigurationService.getConfigParametervalue(FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_CODE_ID, FrameworkSystemcode.C_CONFIG_GROUP_USER_INTERFACE_FTL_COMPRESSION_WHITE_SPACE_REMOVAL_REQUIRED)?default("")>
    <!--Checking if value is set in the config parameter, if not then defaulting it to true--> I
    <#local iswhitespaceCleanupRequired= ternary(isNotNull(iswhitespaceCleanupRequired), Channelsutilities.getBooleanvalue(iswhitespaceCleanupRequired), false)> 
    <#lt>${responseData?replace(ternary(iswhitespaceCleanupRequired, "(?<=\\s)\\s+|^\\s+|\\s+$|\\n|\\r|\\t|\n|\r|\t", "^\\s+|^\\s+|\\s+$|\\n|\\r|\\t|\n|\r|\t"),"", "rm")}<#rt>
</#macros>