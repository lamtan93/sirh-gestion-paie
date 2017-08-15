package dev.paie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.spring.mapper.GradeMapper;

@Service
public class GradeServiceJdbcTemplate implements GradeService{

	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate jdbcNamedParameterTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource datasource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(datasource);
		jdbcNamedParameterTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	
	
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		
		//--------------------1er methode---------------------------------------------------
		
	/*	
	 String sql = "INSERT INTO Grade (id, code, nbHeuresBase, tauxBase) VALUES (?,?,?,?)";
		
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	*/
		
		
		
//---------------------------2eme Methode with Spring Named Parameters------------------------
		
		String sql1 = "INSERT INTO Grade (id, code, nbHeuresBase,tauxBase ) VALUES(:id, :code, :nbHrBase, :taux)";
		
		Map<String,Object> paramMap = new HashMap<>();
		
		paramMap.put("id", nouveauGrade.getId());
		paramMap.put("code", nouveauGrade.getCode());
		paramMap.put("nbHrBase", nouveauGrade.getNbHeuresBase());
		paramMap.put("taux", nouveauGrade.getTauxBase());
		
		jdbcNamedParameterTemplate.update(sql1, paramMap);
		
		
	}

	@Override
	public void mettreAJour(Grade grade) {
	
		String sql = "UPDATE Grade SET code = ? WHERE id = ?";
		
		this.jdbcTemplate.update(sql, grade.getCode(), grade.getId());
		
	}

	@Override
	public List<Grade> lister() {
		
		String sql = "SELECT * from Grade";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}
	
	@Override
	public void  deleteTable(String table){
		String sql = "DELETE FROM " +table;
		
		this.jdbcTemplate.update(sql);
	}
	
	

}
