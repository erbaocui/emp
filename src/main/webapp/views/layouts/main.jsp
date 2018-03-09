<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title>My Site-<decorator:title default="Welcome!"/></title>
    <decorator:head/>
</head>
<body>
<h1><decorator:title default="Welcome to MyHouse"/></h1>
<p><decorator:body/></p>
<p><small>(<a href="#">printable version</a>)</small></p>
</body>
</html>