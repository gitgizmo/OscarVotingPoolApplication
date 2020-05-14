package ca.nexcel.oscar.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import ca.nexcel.oscar.dao.VoteDAO;
import ca.nexcel.oscar.model.Vote;

public class PoolStatsController extends SimpleFormController{
	
	VoteDAO voteDAO; 

	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   Vote winner = voteDAO.findById("winner");
		   if (null == winner) {
			 ModelAndView model = new ModelAndView("PageUnavailable");
			 model.addObject("message","Pool statistics will be calculated after Oscar award winners are announced. Please come back later.");
			 model.addObject("title","Pool Statistics");
			 return model;
		   }

		   Map winnerMap = BeanUtils.describe(winner);
		
		   ModelAndView model = new ModelAndView("Stats");
		   Map categories = new LinkedHashMap();
	       categories.put("Best Picture",voteDAO.obtainCounts("bestPicture"));
		   categories.put("Best Actor in a Leading Role",voteDAO.obtainCounts("BestActorinaLeadingRole"));
		   categories.put("Best Actress in a Leading Role",voteDAO.obtainCounts("bestActressinaLeadingRole"));
		   categories.put("Best Actor in a Supporting Role",voteDAO.obtainCounts("bestActorinaSupportingRole"));
		   categories.put("Best Actress in a Supporting Role",voteDAO.obtainCounts("bestActressinaSupportingRole"));
		   categories.put("Best Animated Feature",voteDAO.obtainCounts("bestAnimatedFeature"));
		   categories.put("Best Cinematography",voteDAO.obtainCounts("bestCinematography"));
		   categories.put("Best Costume Design",voteDAO.obtainCounts("bestCostumeDesign"));
		   categories.put("Best Director",voteDAO.obtainCounts("bestDirector"));
		   categories.put("Best Documentary Feature",voteDAO.obtainCounts("bestDocumentaryFeature"));
		   categories.put("Best Documentary Short",voteDAO.obtainCounts("bestDocumentaryShort"));
		   categories.put("Best Film Editing",voteDAO.obtainCounts("bestFilmEditing"));
		   categories.put("Best Foreign Language Film",voteDAO.obtainCounts("bestForeignLanguageFilm"));
		   categories.put("Best Makeup and Hairstyling",voteDAO.obtainCounts("bestMakeupandHairstyling"));
		   categories.put("Best Original Score",voteDAO.obtainCounts("bestOriginalScore"));
		   categories.put("Best Original Song",voteDAO.obtainCounts("bestOriginalSong"));
		   categories.put("Best Production Design",voteDAO.obtainCounts("bestProductionDesign"));
		   categories.put("Best Animated Short Film",voteDAO.obtainCounts("bestAnimatedShortFilm"));
		   categories.put("Best Live Action Short Film",voteDAO.obtainCounts("bestLiveActionShortFilm"));
		   categories.put("Best Sound Editing",voteDAO.obtainCounts("bestSoundEditing"));
		   categories.put("Best Sound Mixing",voteDAO.obtainCounts("bestSoundMixing"));
		   categories.put("Best Visual Effects",voteDAO.obtainCounts("bestVisualEffects"));
		   categories.put("Best Adapted Screenplay",voteDAO.obtainCounts("bestAdaptedScreenplay"));
		   categories.put("Best Original Screenplay",voteDAO.obtainCounts("bestOriginalScreenplay"));
		   
		   model.addObject("statsMap", categories);
		   model.addObject("winnerMap", winnerMap);
		   
		   return model;
	}
}