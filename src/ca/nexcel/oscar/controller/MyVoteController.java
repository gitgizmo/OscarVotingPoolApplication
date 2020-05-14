package ca.nexcel.oscar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.nexcel.oscar.dao.VoteDAO;
import ca.nexcel.oscar.model.Vote;


public class MyVoteController  extends AbstractController {
	
	VoteDAO voteDAO; 

	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String username = obtainLoginUserName();
		Vote myVote = voteDAO.findById(username);
		if (null == myVote) {
			ModelAndView model = new ModelAndView("PageUnavailable");
			model.addObject("message","You haven't voted yet. Please go to the <a href=\"vote.htm\">Voting Booth</a>");
			model.addObject("title","My Oscar Choices");
			model.addObject("username",username);
			return model;
		}

		ModelAndView model = new ModelAndView("VoteSuccess");
		model.addObject("vote", myVote);
		model.addObject("username",username);
		return model;
	}
	
	private String obtainLoginUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return auth.getName();
	}
}
