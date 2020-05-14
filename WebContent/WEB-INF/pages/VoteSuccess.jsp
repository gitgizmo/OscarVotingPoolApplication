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
<h2>My Oscar Choices - ${username}</h2>
<a href="home.htm">Home</a> |
<a href="vote.htm">Voting Booth</a> |
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</fieldset>

<fieldset>
  <legend>My Choices are ...</legend>  <dl>
       <dd>
       
<br /> <b>Best Picture :</b> ${vote.bestPicture} 
<br /> <b>Best Actor in a Leading Role:</b> ${vote.bestActorinaLeadingRole} 
<br /> <b>Best Actress in a Leading Role:</b> ${vote.bestActressinaLeadingRole}
<br /> <b>Best Actor in a Supporting Role:</b> ${vote.bestActorinaSupportingRole}
<br /> <b>Best Actress in a Supporting Role:</b> ${vote.bestActressinaSupportingRole}
<br /> <b>Best Animated Feature:</b> ${vote.bestAnimatedFeature}
<br /> <b>Best Cinematography:</b> ${vote.bestCinematography}
<br /> <b>Best Costume Design:</b> ${vote.bestCostumeDesign}
<br /> <b>Best Director:</b> ${vote.bestDirector}
<br /> <b>Best Documentary Feature:</b> ${vote.bestDocumentaryFeature}
<br /> <b>Best Documentary Short:</b> ${vote.bestDocumentaryShort}
<br /> <b>Best Film Editing:</b> ${vote.bestFilmEditing}
<br /> <b>Best Foreign Language Film:</b> ${vote.bestForeignLanguageFilm}
<br /> <b>Best Makeup and Hairstyling:</b> ${vote.bestMakeupandHairstyling}
<br /> <b>Best Original Score:</b> ${vote.bestOriginalScore}
<br /> <b>Best Original Song:</b> ${vote.bestOriginalSong}
<br /> <b>Best Production Design:</b> ${vote.bestProductionDesign}
<br /> <b>Best Animated Short Film:</b> ${vote.bestAnimatedShortFilm}
<br /> <b>Best Live Action Short Film:</b> ${vote.bestLiveActionShortFilm}
<br /> <b>Best Sound Editing:</b> ${vote.bestSoundEditing}
<br /> <b>Best Sound Mixing:</b> ${vote.bestSoundMixing}
<br /> <b>Best Visual Effects:</b> ${vote.bestVisualEffects}
<br /> <b>Best Adapted Screenplay:</b> ${vote.bestAdaptedScreenplay}
<br /> <b>Best Original Screenplay:</b> ${vote.bestOriginalScreenplay}

       </dd>
  </dl>
</fieldset>

</body>
</html>