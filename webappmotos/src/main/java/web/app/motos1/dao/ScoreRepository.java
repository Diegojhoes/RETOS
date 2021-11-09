/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.app.motos1.entities.Score;
import web.app.motos1.entities.ScoreCrud;


/**
 *
 * @author HP
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrud scoreCrudRepository;
    
    public List<Score> getAll() {return (List<Score>) scoreCrudRepository.findAll();};
    
    public Optional<Score> getScore(int id) {return scoreCrudRepository.findById(id);};
    
    public Score save(Score score) {return scoreCrudRepository.save(score);};
    
    public void delete(Score score) {scoreCrudRepository.delete(score);}
    }