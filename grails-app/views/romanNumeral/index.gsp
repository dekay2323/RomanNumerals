<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Roman Numeral Converter</title>
</head>
<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}">Home</a></li>
    </ul>
</div>

<div id="stats" class="content scaffold-list" role="main">
    <h1>Roman Numeral Converter</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:hasErrors bean="${this.command}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.command}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form action="calculate">
        <ol class="property-list strategy">

            <li class="fieldcontain">
                <span id="project-label" class="property-label">RomanNumeral</span>
                <g:field class="property-value" type="text" name="romanNumeral" value="${command?.romanNumeral}" /> ${calcNumber}
            </li>
            <li class="fieldcontain">
                <span id="project-label" class="property-label">Decimal</span>
                <g:field class="property-value" type="text" name="number" value="${command?.number}" /> ${calcRomanNumeral}
            </li>
        </ol>
        <fieldset class="buttons">
            <g:submitButton name="calculate" class="save" value="Calculate" />
        </fieldset>
    </g:form>

</div>
</body>
</html>