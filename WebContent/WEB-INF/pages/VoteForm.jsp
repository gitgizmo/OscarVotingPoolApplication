<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<title>Oscar Voting 2014</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css" />
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>



<body>


<form:form method="POST" commandName="voteForm">

<fieldset class="action">
    <h2>Oscar 2014 Voting form</h2>
  	<input type="submit" name="submit" id="submit" value="Save" /> |
   	<a href="home.htm">Home</a> |
    <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</fieldset>

<form:errors path="*" cssClass="errorblock" element="div"/>



<fieldset>
  <legend>Best Picture</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestPicture" items="${bestPictureList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Actor in a Leading Role</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestActorinaLeadingRole" items="${bestActorinaLeadingRoleList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Actress in a Leading Role</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestActressinaLeadingRole" items="${bestActressinaLeadingRoleList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Actor in a Supporting Role</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestActorinaSupportingRole" items="${bestActorinaSupportingRoleList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Actress in a Supporting Role</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestActressinaSupportingRole" items="${bestActressinaSupportingRoleList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Animated Feature</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestAnimatedFeature" items="${bestAnimatedFeatureList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Cinematography</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestCinematography" items="${bestCinematographyList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Costume Design</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestCostumeDesign" items="${bestCostumeDesignList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Director</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestDirector" items="${bestDirectorList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Documentary Feature</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestDocumentaryFeature" items="${bestDocumentaryFeatureList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Documentary Short</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestDocumentaryShort" items="${bestDocumentaryShortList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Film Editing</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestFilmEditing" items="${bestFilmEditingList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Foreign Language Film</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestForeignLanguageFilm" items="${bestForeignLanguageFilmList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Makeup and Hairstyling</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestMakeupandHairstyling" items="${bestMakeupandHairstylingList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Original Score</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestOriginalScore" items="${bestOriginalScoreList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Original Song</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestOriginalSong" items="${bestOriginalSongList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Production Design</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestProductionDesign" items="${bestProductionDesignList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Animated Short Film</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestAnimatedShortFilm" items="${bestAnimatedShortFilmList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Live Action Short Film</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestLiveActionShortFilm" items="${bestLiveActionShortFilmList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Sound Editing</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestSoundEditing" items="${bestSoundEditingList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Sound Mixing</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestSoundMixing" items="${bestSoundMixingList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Visual Effects</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestVisualEffects" items="${bestVisualEffectsList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Adapted Screenplay</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestAdaptedScreenplay" items="${bestAdaptedScreenplayList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

<fieldset>
  <legend>Best Original Screenplay</legend>  <dl>
     <dt></dt>
       <dd>
          <form:radiobuttons path="bestOriginalScreenplay" items="${bestOriginalScreenplayList}" element="br"/> 
       </dd>
  </dl>
</fieldset>

    <fieldset class="action">
    	<input type="submit" name="submit" id="submit1" value="Save" /> | 
    	<a href="home.htm">Home</a> |
        <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
    </fieldset>

</form:form>

</body>
</html>