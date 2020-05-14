package ca.nexcel.oscar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ca.nexcel.oscar.dao.JdbcVoteDAOImpl;
import ca.nexcel.oscar.dao.VoteDAO;
import ca.nexcel.oscar.model.Vote;

public class VoteController extends SimpleFormController{
	
	private VoteDAO voteDAO; 
	
	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	public VoteController(){
		setCommandClass(Vote.class);
		setCommandName("voteForm");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Vote vote = new Vote();
		String username = obtainLoginUserName(); 
		Vote storedVote = voteDAO.findById(username);
		if (storedVote != null) {
			vote = storedVote;
		}
		return vote;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,	HttpServletResponse response, Object command, BindException errors) throws Exception {
		String propertyValue = voteDAO.obtainProperty("voting");
		if ( ! propertyValue.equals("on")) {
			return new ModelAndView("PageUnavailable","message","The voting booth is now closed!");
		}
				
		
		Vote vote = (Vote) command;

		String username = obtainLoginUserName(); 
		 Vote storedVote = voteDAO.findById(username);
		 vote.setUserid(username);
		 
		 //sanity assertion
		 if ( (null != storedVote) && ( ! storedVote.getUserid().equals(vote.getUserid()))) {
			 throw new RuntimeException("username is not correct");
		 }
		 
        if (null == storedVote) {
        	voteDAO.insert(vote);
        } else {
        	voteDAO.update(vote);
        }
        
		ModelAndView model = new ModelAndView("VoteSuccess");
		model.addObject("vote",vote);
		model.addObject("username",username);
		return model;
	}

	private String obtainLoginUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return auth.getName();
	}
	
	protected Map referenceData(HttpServletRequest request) throws Exception {
		
		Map referenceData = new HashMap();
		
		List<String> bestPictureList = new ArrayList<String>();
		bestPictureList.add("American Hustle");
		bestPictureList.add("Captain Phillips");
		bestPictureList.add("Dallas Buyers Club");
		bestPictureList.add("Gravity");
		bestPictureList.add("Her");
		bestPictureList.add("Nebraska");
		bestPictureList.add("Philomena");
	    bestPictureList.add("12 Years a Slave");
	    bestPictureList.add("The Wolf of Wall Street");
	    referenceData.put("bestPictureList", bestPictureList);
	    
	    
	    
	    List<String> bestActorinaLeadingRoleList = new ArrayList<String>();
	    bestActorinaLeadingRoleList.add("Christian Bale (American Hustle)");
	    bestActorinaLeadingRoleList.add("Bruce Dern (Nebraska)");
	    bestActorinaLeadingRoleList.add("Leonardo DiCaprio (The Wolf of Wall Street)");
	    bestActorinaLeadingRoleList.add("Chiwetel Ejiofor (12 Years a Slave)");
	    bestActorinaLeadingRoleList.add("Matthew McConaughey (Dallas Buyers Club)");
	    referenceData.put("bestActorinaLeadingRoleList", bestActorinaLeadingRoleList);
	    
	    
	    List<String> bestActressinaLeadingRoleList = new ArrayList<String>();
	    bestActressinaLeadingRoleList.add("Amy Adams (American Hustle)");
	    bestActressinaLeadingRoleList.add("Cate Blanchett (Blue Jasmine)");
	    bestActressinaLeadingRoleList.add("Sandra Bullock (Gravity)");
	    bestActressinaLeadingRoleList.add("Judi Dench (Philomena)");
	    bestActressinaLeadingRoleList.add("Meryl Streep (August: Osage County)");
	    referenceData.put("bestActressinaLeadingRoleList", bestActressinaLeadingRoleList);


	    List<String> bestActorinaSupportingRoleList = new ArrayList<String>();
	    bestActorinaSupportingRoleList.add("Barkhad Abdi (Captain Phillips)");
	    bestActorinaSupportingRoleList.add("Bradley Cooper (American Hustle)");
	    bestActorinaSupportingRoleList.add("Michael Fassbender (12 Years a Slave)");
	    bestActorinaSupportingRoleList.add("Jonah Hill (The Wolf of Wall Street)");
	    bestActorinaSupportingRoleList.add("Jared Leto (Dallas Buyers Club)");
	    referenceData.put("bestActorinaSupportingRoleList", bestActorinaSupportingRoleList);


	    List<String> bestActressinaSupportingRoleList = new ArrayList<String>();
	    bestActressinaSupportingRoleList.add("Sally Hawkins (Blue Jasmine)");
	    bestActressinaSupportingRoleList.add("Jennifer Lawrence (American Hustle)");
	    bestActressinaSupportingRoleList.add("Lupita Nyong'o (12 Years a Slave)");
	    bestActressinaSupportingRoleList.add("Julia Roberts (August: Osage County)");
	    bestActressinaSupportingRoleList.add("June Squibb (Nebraska)");
	    referenceData.put("bestActressinaSupportingRoleList", bestActressinaSupportingRoleList);


	    List<String> bestAnimatedFeatureList = new ArrayList<String>();
	    bestAnimatedFeatureList.add("The Croods (Chris Sanders, Kirk DeMicco, Kristine Belson)");
	    bestAnimatedFeatureList.add("Despicable Me 2 (Chris Renaud, Pierre Coffin, Chris Meledandri)");
	    bestAnimatedFeatureList.add("Ernest & Celestine (Benjamin Renner, Didier Brunner)");
	    bestAnimatedFeatureList.add("Frozen (Chris Buck, Jennifer Lee, Peter Del Vecho)");
	    bestAnimatedFeatureList.add("The Wind Rises (Hayao Miyazaki, Toshio Suzuki)");
	    referenceData.put("bestAnimatedFeatureList", bestAnimatedFeatureList);


	    List<String> bestCinematographyList = new ArrayList<String>();
	    bestCinematographyList.add("The Grandmaster (Philippe Le Sourd)");
	    bestCinematographyList.add("Gravity (Emmanuel Lubezki)");
	    bestCinematographyList.add("Inside Llewyn Davis (Bruno Delbonnel)");
	    bestCinematographyList.add("Nebraska (Phedon Papamichael)");
	    bestCinematographyList.add("Prisoners (Roger A. Deakins)");
	    referenceData.put("bestCinematographyList", bestCinematographyList);


	    List<String> bestCostumeDesignList = new ArrayList<String>();
	    bestCostumeDesignList.add("American Hustle (Michael Wilkinson)");
	    bestCostumeDesignList.add("The Grandmaster (William Chang Suk Ping)");
	    bestCostumeDesignList.add("The Great Gatsby (Catherine Martin)");
	    bestCostumeDesignList.add("The Invisible Woman (Michael O'Connor)");
	    bestCostumeDesignList.add("12 Years a Slave (Patricia Norris)");
	    referenceData.put("bestCostumeDesignList", bestCostumeDesignList);


	    List<String> bestDirectorList = new ArrayList<String>();
	    bestDirectorList.add("American Hustle (David O. Russell)");
	    bestDirectorList.add("Gravity (Alfonso Cuarón)");
	    bestDirectorList.add("Nebraska (Alexander Payne)");
	    bestDirectorList.add("12 Years a Slave (Steve McQueen)");
	    bestDirectorList.add("The Wolf of Wall Street (Martin Scorsese)");
	    referenceData.put("bestDirectorList", bestDirectorList);


	    List<String> bestDocumentaryFeatureList = new ArrayList<String>();
	    bestDocumentaryFeatureList.add("The Act of Killing (Joshua Oppenheimer, Signe Byrge Sørensen)");
	    bestDocumentaryFeatureList.add("Cutie and the Boxer (Zachary Heinzerling, Lydia Dean Pilcher)");
	    bestDocumentaryFeatureList.add("Dirty Wars (Richard Rowley, Jeremy Scahill)");
	    bestDocumentaryFeatureList.add("The Square (Jehane Noujaim, Karim Amer)");
	    bestDocumentaryFeatureList.add("20 Feet from Stardom (Nominees to be determined)");
	    referenceData.put("bestDocumentaryFeatureList", bestDocumentaryFeatureList);


	    List<String> bestDocumentaryShortList = new ArrayList<String>();
	    bestDocumentaryShortList.add("CaveDigger (Jeffrey Karoff)");
	    bestDocumentaryShortList.add("Facing Fear (Jason Cohen)");
	    bestDocumentaryShortList.add("Karama Has No Walls (Sara Ishaq)");
	    bestDocumentaryShortList.add("The Lady in Number 6: Music Saved My Life (Malcolm Clarke, Nicholas Reed)");
	    bestDocumentaryShortList.add("Prison Terminal: The Last Days of Private Jack Hall (Edgar Barens)");
	    referenceData.put("bestDocumentaryShortList", bestDocumentaryShortList);


	    List<String> bestFilmEditingList = new ArrayList<String>();
	    bestFilmEditingList.add("American Hustle (Jay Cassidy, Crispin Struthers, Alan Baumgarten)");
	    bestFilmEditingList.add("Captain Phillips (Christopher Rouse)");
	    bestFilmEditingList.add("Dallas Buyers Club (John Mac McMurphy, Martin Pensa)");
	    bestFilmEditingList.add("Gravity (Alfonso Cuarón, Mark Sanger)");
	    bestFilmEditingList.add("12 Years a Slave (Joe Walker)");
	    referenceData.put("bestFilmEditingList", bestFilmEditingList);


	    List<String> bestForeignLanguageFilmList = new ArrayList<String>();
	    bestForeignLanguageFilmList.add("The Broken Circle Breakdown (Belgium)");
	    bestForeignLanguageFilmList.add("The Great Beauty (Italy)");
	    bestForeignLanguageFilmList.add("The Hunt (Denmark)");
	    bestForeignLanguageFilmList.add("The Missing Picture (Cambodia)");
	    bestForeignLanguageFilmList.add("Omar (Palestine)");
	    referenceData.put("bestForeignLanguageFilmList", bestForeignLanguageFilmList);


	    List<String> bestMakeupandHairstylingList = new ArrayList<String>();
	    bestMakeupandHairstylingList.add("Dallas Buyers Club (Adruitha Lee, Robin Mathews)");
	    bestMakeupandHairstylingList.add("Jackass Presents: Bad Grandpa (Stephen Prouty)");
	    bestMakeupandHairstylingList.add("The Lone Ranger (Joel Harlow, Gloria Pasqua-Casny)");
	    referenceData.put("bestMakeupandHairstylingList", bestMakeupandHairstylingList);


	    List<String> bestOriginalScoreList = new ArrayList<String>();
	    bestOriginalScoreList.add("The Book Thief (John Williams)");
	    bestOriginalScoreList.add("Gravity (Steven Price)");
	    bestOriginalScoreList.add("Her (William Butler, Owen Pallett)");
	    bestOriginalScoreList.add("Philomena (Alexandre Desplat)");
	    bestOriginalScoreList.add("Saving Mr. Banks (Thomas Newman)");
	    referenceData.put("bestOriginalScoreList", bestOriginalScoreList);


	    List<String> bestOriginalSongList = new ArrayList<String>();
	    bestOriginalSongList.add("Alone Yet Not Alone (Alone Yet Not Alone)");
	    bestOriginalSongList.add("Happy (Despicable Me 2)");
	    bestOriginalSongList.add("Let It Go (Frozen)");
	    bestOriginalSongList.add("The Moon Song (Her)");
	    bestOriginalSongList.add("Ordinary Love (Mandela: Long Walk to Freedom)");
	    referenceData.put("bestOriginalSongList", bestOriginalSongList);


	    List<String> bestProductionDesignList = new ArrayList<String>();
	    bestProductionDesignList.add("American Hustle (Judy Becker, Heather Loeffler)");
	    bestProductionDesignList.add("Gravity (Andy Nicholson, Rosie Goodwin, Joanne Woollard)");
	    bestProductionDesignList.add("The Great Gatsby (Catherine Martin, Beverley Dunn)");
	    bestProductionDesignList.add("Her (K.K. Barrett, Gene Serdena)");
	    bestProductionDesignList.add("12 Years a Slave (Adam Stockhausen, Alice Baker)");
	    referenceData.put("bestProductionDesignList", bestProductionDesignList);


	    List<String> bestAnimatedShortFilmList = new ArrayList<String>();
	    bestAnimatedShortFilmList.add("Feral (Daniel Sousa, Dan Golden)");
	    bestAnimatedShortFilmList.add("Get a Horse! (Lauren MacMullan, Dorothy McKim)");
	    bestAnimatedShortFilmList.add("Mr. Hublot (Laurent Witz, Alexandre Espigares)");
	    bestAnimatedShortFilmList.add("Possessions (Shuhei Morita)");
	    bestAnimatedShortFilmList.add("Room on the Broom (Max Lang, Jan Lachauer)");
	    referenceData.put("bestAnimatedShortFilmList", bestAnimatedShortFilmList);


	    List<String> bestLiveActionShortFilmList = new ArrayList<String>();
	    bestLiveActionShortFilmList.add("Aquel No Era Yo (That Wasn't Me) (Esteban Crespo)");
	    bestLiveActionShortFilmList.add("Avant Que De Tout Perdre (Just Before Losing Everything) (Xavier Legrand, Alexandre Gavras)");
	    bestLiveActionShortFilmList.add("Helium (Anders Walter, Kim Magnusson)");
	    bestLiveActionShortFilmList.add("Pitääkö Mun Kaikki Hoitaa? (Do I Have to Take Care of Everything?) (Selma Vilhunen, Kirsikka Saari)");
	    bestLiveActionShortFilmList.add("The Voorman Problem (Mark Gill, Baldwin Li)");
	    referenceData.put("bestLiveActionShortFilmList", bestLiveActionShortFilmList);


	    List<String> bestSoundEditingList = new ArrayList<String>();
	    bestSoundEditingList.add("All Is Lost (Steve Boeddeker, Richard Hymns)");
	    bestSoundEditingList.add("Captain Phillips (Oliver Tarney)");
	    bestSoundEditingList.add("Gravity (Glenn Freemantle)");
	    bestSoundEditingList.add("The Hobbit: The Desolation of Smaug (Brent Burge, Chris Ward)");
	    bestSoundEditingList.add("Lone Survivor (Wylie Stateman)");
	    referenceData.put("bestSoundEditingList", bestSoundEditingList);


	    List<String> bestSoundMixingList = new ArrayList<String>();
	    bestSoundMixingList.add("Captain Phillips (Chris Burdon, Mark Taylor, Mike Prestwood Smith, Chris Munro)");
	    bestSoundMixingList.add("Gravity (Skip Lievsay, Niv Adiri, Christopher Benstead, Chris Munro)");
	    bestSoundMixingList.add("The Hobbit: The Desolation of Smaug (Christopher Boyes, Michael Hedges, Michael Semanick, Tony Johnson)");
	    bestSoundMixingList.add("Inside Llewyn Davis (Skip Lievsay, Greg Orloff, Peter F. Kurland)");
	    bestSoundMixingList.add("Lone Survivor (Andy Koyama, Beau Borders, David Brownlow)");
	    referenceData.put("bestSoundMixingList", bestSoundMixingList);


	    List<String> bestVisualEffectsList = new ArrayList<String>();
	    bestVisualEffectsList.add("Gravity (Tim Webber, Chris Lawrence, Dave Shirk, Neil Corbould)");
	    bestVisualEffectsList.add("The Hobbit: The Desolation of Smaug (Joe Letteri, Eric Saindon, David Clayton, Eric Reynolds)");
	    bestVisualEffectsList.add("Iron Man 3 (Christopher Townsend, Guy Williams, Erik Nash, Dan Sudick)");
	    bestVisualEffectsList.add("The Lone Ranger (Tim Alexander, Gary Brozenich, Edson Williams, John Frazier)");
	    bestVisualEffectsList.add("Star Trek Into Darkness (Roger Guyett, Patrick Tubach, Ben Grossmann, Burt Dalton)");
	    referenceData.put("bestVisualEffectsList", bestVisualEffectsList);


	    List<String> bestAdaptedScreenplayList = new ArrayList<String>();
	    bestAdaptedScreenplayList.add("Before Midnight (Richard Linklater, Julie Delpy, Ethan Hawke)");
	    bestAdaptedScreenplayList.add("Captain Phillips (Billy Ray)");
	    bestAdaptedScreenplayList.add("Philomena (Steve Coogan, Jeff Pope)");
	    bestAdaptedScreenplayList.add("12 Years a Slave (John Ridley)");
	    bestAdaptedScreenplayList.add("The Wolf of Wall Street (Terence Winter)");
	    referenceData.put("bestAdaptedScreenplayList", bestAdaptedScreenplayList);


	    List<String> bestOriginalScreenplayList = new ArrayList<String>();
	    bestOriginalScreenplayList.add("American Hustle (Eric Warren Singer, David O. Russell)");
	    bestOriginalScreenplayList.add("Blue Jasmine (Woody Allen)");
	    bestOriginalScreenplayList.add("Dallas Buyers Club (Craig Borten, Melisa Wallack)");
	    bestOriginalScreenplayList.add("Her (Spike Jonze)");
	    bestOriginalScreenplayList.add("Nebraska (Bob Nelson)");
	    referenceData.put("bestOriginalScreenplayList", bestOriginalScreenplayList);


		
		return referenceData;
		
	}
	
}