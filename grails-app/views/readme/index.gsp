<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Roman Numeral Converter</title>
</head>
<body>
<g:render template="/template/dropdownNav" />

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}">Home</a></li>
    </ul>
</div>

<div id="stats" class="content scaffold-list" role="main">
    <markdown:renderHtml template="/template/README" />
</div>

</body>
</html>