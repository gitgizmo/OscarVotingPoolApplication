package ca.nexcel.oscar.model;

public class Ranking extends Vote implements Comparable {
	int counter = 0;
	
	public Ranking(Vote vote) {
		  userid = vote.getUserid();
		 bestPicture = vote.getBestPicture();
		 bestActorinaLeadingRole = vote.getBestActorinaLeadingRole();
		 bestActressinaLeadingRole = vote.getBestActressinaLeadingRole();
		 bestActorinaSupportingRole = vote.getBestActorinaSupportingRole();
		 bestActressinaSupportingRole = vote.getBestActressinaSupportingRole();
		 bestAnimatedFeature = vote.getBestAnimatedFeature();
		 bestCinematography = vote.getBestCinematography();
		 bestCostumeDesign = vote.getBestCostumeDesign();
		 bestDirector = vote.getBestDirector();
		 bestDocumentaryFeature = vote.getBestDocumentaryFeature();
		 bestDocumentaryShort = vote.getBestDocumentaryShort();
		 bestFilmEditing = vote.getBestFilmEditing();
		 bestForeignLanguageFilm = vote.getBestForeignLanguageFilm();
		 bestMakeupandHairstyling = vote.getBestMakeupandHairstyling();
		 bestOriginalScore = vote.getBestOriginalScore();
		 bestOriginalSong = vote.getBestOriginalSong();
		 bestProductionDesign = vote.getBestProductionDesign();
		 bestAnimatedShortFilm = vote.getBestAnimatedShortFilm();
		 bestLiveActionShortFilm = vote.getBestLiveActionShortFilm();
		 bestSoundEditing = vote.getBestSoundEditing();
		 bestSoundMixing = vote.getBestSoundMixing();
		 bestVisualEffects = vote.getBestVisualEffects();
		 bestAdaptedScreenplay = vote.getBestAdaptedScreenplay();
		 bestOriginalScreenplay = vote.getBestOriginalScreenplay();
	}
	
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

    public int compareTo(Object object) {
       Ranking ranking = (Ranking) object;
	   return ranking.getCounter() - counter;
    }
}
