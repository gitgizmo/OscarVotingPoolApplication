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


public class OscarWinnerController  extends AbstractController {
	
	VoteDAO voteDAO; 

	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Vote winner = voteDAO.findById("winner");
		if (null == winner) {
			ModelAndView model = new ModelAndView("PageUnavailable");
			model.addObject("message","The oscar winners have not been announced. Please come back later.");
			model.addObject("title","2014 Oscar Award Results");
			return model;
		}
		
		ModelAndView model = new ModelAndView("OscarWinner");
		model.addObject("vote", voteDAO.findById("winner"));
		return model;
	}
}
