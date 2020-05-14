package ca.nexcel.oscar.dao;

import ca.nexcel.oscar.model.Vote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcVoteDAOImpl implements VoteDAO {

		private DataSource dataSource;
		private JdbcTemplate jdbcTemplate;
	 
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		public void insert(Vote vote) {
			String sql = "INSERT INTO votes ("
					+  "bestPicture"
					+ ",bestActorinaLeadingRole"
					+ ",bestActressinaLeadingRole"
					+ ",bestActorinaSupportingRole"
					+ ",bestActressinaSupportingRole"
					+ ",bestAnimatedFeature"
					+ ",bestCinematography"
					+ ",bestCostumeDesign"
					+ ",bestDirector"
					+ ",bestDocumentaryFeature"
					+ ",bestDocumentaryShort"
					+ ",bestFilmEditing"
					+ ",bestForeignLanguageFilm"
					+ ",bestMakeupandHairstyling"
					+ ",bestOriginalScore"
					+ ",bestOriginalSong"
					+ ",bestProductionDesign"
					+ ",bestAnimatedShortFilm"
					+ ",bestLiveActionShortFilm"
					+ ",bestSoundEditing"
					+ ",bestSoundMixing"
					+ ",bestVisualEffects"
					+ ",bestAdaptedScreenplay"
					+ ",bestOriginalScreenplay"
					+ ",userid)"
					+ " VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			  
		    	    insertOrUpdate(vote, sql);
		}
		
		
		public void update(Vote vote) {
			String sql = "UPDATE votes SET "
					+  "bestPicture = ?"
					+ ",bestActorinaLeadingRole = ?"
					+ ",bestActressinaLeadingRole = ?"
					+ ",bestActorinaSupportingRole = ?"
					+ ",bestActressinaSupportingRole = ?"
					+ ",bestAnimatedFeature = ?"
					+ ",bestCinematography = ?"
					+ ",bestCostumeDesign = ?"
					+ ",bestDirector = ?"
					+ ",bestDocumentaryFeature = ?"
					+ ",bestDocumentaryShort = ?"
					+ ",bestFilmEditing = ?"
					+ ",bestForeignLanguageFilm = ?"
					+ ",bestMakeupandHairstyling = ?"
					+ ",bestOriginalScore = ?"
					+ ",bestOriginalSong = ?"
					+ ",bestProductionDesign = ?"
					+ ",bestAnimatedShortFilm = ?"
					+ ",bestLiveActionShortFilm = ?"
					+ ",bestSoundEditing = ?"
					+ ",bestSoundMixing = ?"
					+ ",bestVisualEffects = ?"
					+ ",bestAdaptedScreenplay = ?"
					+ ",bestOriginalScreenplay = ?"
					+ " WHERE userid = ?";
					
    	    insertOrUpdate(vote, sql);
		}


		private void insertOrUpdate(Vote vote, String sql) {
			jdbcTemplate = new JdbcTemplate(dataSource);
			 	  
			jdbcTemplate.update(sql, new Object[] { 
					vote.getBestPicture(),
					vote.getBestActorinaLeadingRole(),
					vote.getBestActressinaLeadingRole(),
					vote.getBestActorinaSupportingRole(),
					vote.getBestActressinaSupportingRole(),
					vote.getBestAnimatedFeature(),
					vote.getBestCinematography(),
					vote.getBestCostumeDesign(),
					vote.getBestDirector(),
					vote.getBestDocumentaryFeature(),
					vote.getBestDocumentaryShort(),
					vote.getBestFilmEditing(),
					vote.getBestForeignLanguageFilm(),
					vote.getBestMakeupandHairstyling(),
					vote.getBestOriginalScore(),
					vote.getBestOriginalSong(),
					vote.getBestProductionDesign(),
					vote.getBestAnimatedShortFilm(),
					vote.getBestLiveActionShortFilm(),
					vote.getBestSoundEditing(),
					vote.getBestSoundMixing(),
					vote.getBestVisualEffects(),
					vote.getBestAdaptedScreenplay(),
					vote.getBestOriginalScreenplay(),
					vote.getUserid()
			  	    });
		}


		public Vote findById(String userid) {
	        String sql = "SELECT * FROM VOTES WHERE USERID = ?";
	        Vote vote = null;
	        	 
	        try {
	        	jdbcTemplate = new JdbcTemplate(dataSource);
	        	vote = jdbcTemplate.queryForObject(sql
	        	                , new Object[] { userid }
	        	                , new BeanPropertyRowMapper<Vote>(Vote.class));
	        } catch (EmptyResultDataAccessException e) {
	        	//not found
	        }
	        	      
	        return vote;
		}

		public Map obtainCounts(String subject) {
			String sql = "SELECT "+ subject + ", COUNT(1) AS counter FROM votes where USERID <> 'winner' GROUP BY " + subject;
			Map results = new HashMap();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				results.put(row.get(subject), row.get("counter"));
			}

			return results;
		}

		public List<Vote> obtainAllVotes() {
			String sql = "SELECT * FROM votes";
			return jdbcTemplate.query(sql,	new BeanPropertyRowMapper<Vote>(Vote.class));
		}

		public String obtainProperty(String propertyName) {
	        String sql = "SELECT value FROM config WHERE name = ?";
   	        String propertyValue = (String)jdbcTemplate.queryForObject(sql, new Object[] { propertyName }, String.class);
   	        return propertyValue;
		}
	
	}
