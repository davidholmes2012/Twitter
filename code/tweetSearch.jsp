<%@include file="header.jsp" %>
<html>
<head>

<title>Search</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Search Tweets</h1>

<p>To search for a tweet enter the whole tag or part of the tag in the box below.</p>
<p>If you wish to view all the tweets then simply press submit</p>

<form action ="searchTweetResults.jsp" method="post">
<p>Tag:&nbsp;&nbsp;&nbsp;
<input name="search" type="text" ></p>
<p><input name="Submit1" type="submit" value="submit"></p>&nbsp;
</form>
</body>
</html>
