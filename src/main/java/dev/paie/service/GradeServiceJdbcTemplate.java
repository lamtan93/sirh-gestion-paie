package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.spring.mapper.GradeMapper;

@Service
public class GradeServiceJdbcTemplate implements GradeService{

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource datasource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	
	
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		
		String sql = "INSERT INTO Grade (id, code, nbHeuresBase, tauxBase) VALUES (?,?,?,?)";
		
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
		
		
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

}
