package ca.nexcel.oscar.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ca.nexcel.oscar.model.Vote;

public class VoteValidator implements Validator{

	public boolean supports(Class clazz) {
		return Vote.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Vote vote = (Vote)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestPicture", "required.bestPicture");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestActorinaLeadingRole", "required.bestActorinaLeadingRole");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestActressinaLeadingRole", "required.bestActressinaLeadingRole");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestActorinaSupportingRole", "required.bestActorinaSupportingRole");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestActressinaSupportingRole", "required.bestActressinaSupportingRole");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestAnimatedFeature", "required.bestAnimatedFeature");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestCinematography", "required.bestCinematography");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestCostumeDesign", "required.bestCostumeDesign");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestDirector", "required.bestDirector");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestDocumentaryFeature", "required.bestDocumentaryFeature");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestDocumentaryShort", "required.bestDocumentaryShort");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestFilmEditing", "required.bestFilmEditing");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestForeignLanguageFilm", "required.bestForeignLanguageFilm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestMakeupandHairstyling", "required.bestMakeupandHairstyling");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestOriginalScore", "required.bestOriginalScore");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestOriginalSong", "required.bestOriginalSong");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestProductionDesign", "required.bestProductionDesign");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestAnimatedShortFilm", "required.bestAnimatedShortFilm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestLiveActionShortFilm", "required.bestLiveActionShortFilm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestSoundEditing", "required.bestSoundEditing");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestSoundMixing", "required.bestSoundMixing");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestVisualEffects", "required.bestVisualEffects");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestAdaptedScreenplay", "required.bestAdaptedScreenplay");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bestOriginalScreenplay", "required.bestOriginalScreenplay");
	}
	
}