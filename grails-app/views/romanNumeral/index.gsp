<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Roman Numeral Converter</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}">Clear</a></li>
        <li><g:link uri="https://github.com/dekay2323/RomanNumerals" target="_blank">GitHub</g:link> </li>
    </ul>
</div>

<div id="stats" class="content scaffold-list" role="main">
    <h2>Simple Roman Numeral converter, handles subtractive notation</h2>

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
        <ol class="property-list">

            <li class="fieldcontain">
                <span id="project-label" class="property-label">RomanNumeral</span>
                <g:field class="property-value ${hasErrors(bean:command, field:'romanNumeral', 'error')}" type="text" name="romanNumeral" value="${command?.romanNumeral}" maxlength="8"/>
            </li>
            <li class="fieldcontain">
                <span id="project-label" class="property-label">Decimal</span>
                <g:field class="property-value ${hasErrors(bean:command, field:'number', 'error')}" type="text" name="number" value="${command?.number}"  maxlength="5"/>
            </li>
        </ol>
        <fieldset class="buttons">
            <g:submitButton name="calculate" class="save" value="Calculate" />
        </fieldset>
    </g:form>
</div>



<script>
    $('#romanNumeral').on('input',function(e) {
        if ($(this).val().length > 0) {
            $('#number').val('');
        }
    });
    $('#number').on('input',function(e) {
        if ($(this).val().length > 0) {
            $('#romanNumeral').val('');
        }
    })
</script>
</body>
</html>