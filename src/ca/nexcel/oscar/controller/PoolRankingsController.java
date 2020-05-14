package ca.nexcel.oscar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.nexcel.oscar.dao.VoteDAO;
import ca.nexcel.oscar.model.Ranking;
import ca.nexcel.oscar.model.Vote;


public class PoolRankingsController  extends AbstractController {
	
	VoteDAO voteDAO; 

	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	private List obtainRankings() {
		List<Vote> votes = voteDAO.obtainAllVotes();
		List<Ranking> rankings = new ArrayList();
		Vote winner = voteDAO.findById("winner");
		
		for (int i = 0; i < votes.size(); i++) {
			Vote voter = votes.get(i);
			Ranking ranking = new Ranking(voter);
			
			
			if (voter.getBestPicture().equals(winner.getBestPicture()))                                       ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestActorinaLeadingRole().equals(winner.getBestActorinaLeadingRole()))               ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestActressinaLeadingRole().equals(winner.getBestActressinaLeadingRole()))           ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestActorinaSupportingRole().equals(winner.getBestActorinaSupportingRole()))         ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestActressinaSupportingRole().equals(winner.getBestActressinaSupportingRole()))     ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestAnimatedFeature().equals(winner.getBestAnimatedFeature()))                       ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestCinematography().equals(winner.getBestCinematography()))                         ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestCostumeDesign().equals(winner.getBestCostumeDesign()))                           ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestDirector().equals(winner.getBestDirector()))                                     ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestDocumentaryFeature().equals(winner.getBestDocumentaryFeature()))                 ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestDocumentaryShort().equals(winner.getBestDocumentaryShort()))                     ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestFilmEditing().equals(winner.getBestFilmEditing()))                               ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestForeignLanguageFilm().equals(winner.getBestForeignLanguageFilm()))               ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestMakeupandHairstyling().equals(winner.getBestMakeupandHairstyling()))             ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestOriginalScore().equals(winner.getBestOriginalScore()))                           ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestOriginalSong().equals(winner.getBestOriginalSong()))                             ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestProductionDesign().equals(winner.getBestProductionDesign()))                     ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestAnimatedShortFilm().equals(winner.getBestAnimatedShortFilm()))                   ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestLiveActionShortFilm().equals(winner.getBestLiveActionShortFilm()))               ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestSoundEditing().equals(winner.getBestSoundEditing()))                             ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestSoundMixing().equals(winner.getBestSoundMixing()))                               ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestVisualEffects().equals(winner.getBestVisualEffects()))                           ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestAdaptedScreenplay().equals(winner.getBestAdaptedScreenplay()))                   ranking.setCounter(ranking.getCounter()+1);
			if (voter.getBestOriginalScreenplay().equals(winner.getBestOriginalScreenplay()))                 ranking.setCounter(ranking.getCounter()+1);
			
			if ( !  ranking.getUserid().equals("winner")) rankings.add(ranking);
		}
		
	    Collections.sort(rankings);
		return rankings;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Vote winner = voteDAO.findById("winner");
		if (null == winner) {
			ModelAndView model = new ModelAndView("PageUnavailable");
			model.addObject("message","The pool rankings will be determined after Oscar winners are announced. Please come back later.");
			model.addObject("title","Pool Rankings");
			return model;
		}
		
		
		ModelAndView model = new ModelAndView("Rankings");
		model.addObject("rankings", obtainRankings());
		return model;
	}
}
