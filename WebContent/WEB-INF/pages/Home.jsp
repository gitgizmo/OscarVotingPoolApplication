<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<title>Oscar 2014</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css" />
</head>
<body>

<fieldset class="action">
<h2>Oscar Pool - Sunday March 2nd 2014 - ${username}</h2>
   <a href="vote.htm">Voting Booth</a> |
   <a href="myvote.htm">My Vote</a> |
   <a href="poolrankings.htm">Pool Rankings</a> |
   <a href="poolstats.htm">Pool Statistics</a> |
   <a href="oscarwinner.htm">2014 Oscar Award Results</a> |
   <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</fieldset>

<fieldset>
  <legend>Why should I play</legend>  <dl>
       <dd>
          <ol>
          <li>You have about a 20% chance of winning SOMETHING.</li>
          <li>The winner will be the envy of the office, and be able to strut the halls (ok, just one hall) with the confidence and swagger of a winner</li>
          <li>Unlike the real Oscars, this is not fixed.</li>
          <li>There are prizes, and one of them is <b>wine</b>. Do you need another reason?</li>
          </ol>
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>The Rules</legend>  <dl>
       <dd>
          <ol>
          <li>It costs $5 to play. I hope that is not too much.</li>
          <li>You have one vote for for all awards.</li>
          <li>You can change your vote as many times as you like up until 1 hour before the start of the awards show.</li>
          <li>You get one point for each award you get right.</li>
          <li>Once the results are published, this app will calculate the pool rankings and some basic statistics.</li>
          <li>In the rankings you will see 'monkey'. These are pure random choices so we can see if we are better than throwing a dart.</li>
          <li>There ain't no other rules. This is a very simple arrangement.</li>
          </ol>
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Prizes</legend>  <dl>
       <dd>
          <ol>
          <li>The person with the highest score gets 40% of the total collected.</li>
          <li>The person with the second highest score gets 30% of the total collected.</li>
          <li>The person with the third highest score gets 20% of the total collected.</li>
          <li>The person with the <b>lowest</b> score gets 10% of the total collected. Yes, it does pay to be last (sometimes).</li>
          <li>If there is a tie for a prize, then the prize money will be split evenly.</li>
          <li>A bottle of wine will be randomly awarded as a door prize among anyone who did not win any of the above</li>
          </ol>
          <p/>
          According to these rules, its possible that the top winners may not win the most in terms of value, but they might. Such is life.
       </dd>
  </dl>
</fieldset>

</body>
</html>










