package ca.nexcel.oscar.dao;

import java.util.List;
import java.util.Map;

import ca.nexcel.oscar.model.Vote;

public interface VoteDAO {
	public void insert(Vote vote);
	public void update(Vote vote);
	public Vote findById(String id);
	public Map obtainCounts(String subject);
	public List obtainAllVotes();
	public String obtainProperty(String propertyName);
}