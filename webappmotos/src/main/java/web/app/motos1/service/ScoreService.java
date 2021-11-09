/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import web.app.motos1.dao.ScoreRepository;
import web.app.motos1.entities.Score;
import web.app.motos1.entities.ScoreCrud;



/**
 *
 * @author HP
 */
@Service
@SpringBootApplication(scanBasePackages = "web.app.motos1.dao")
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll() {return (List<Score>) scoreRepository.getAll();};
    
    public Optional<Score> getScore(int id) {return scoreRepository.getScore(id);};
    
    public Score save(Score score) {
        if(score.getId()==null){
            return scoreRepository.save(score);
            
        }else{
            Optional<Score> co = scoreRepository.getScore(score.getId());
            if(co.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
    }
  }   
    
    public Score update (Score score){
        if(score.getId() != null){
            Optional<Score> e = scoreRepository.getScore(score.getId());
            if(!e.isEmpty()){
                if (score.getQualification()!= null){
                    e.get().setQualification(score.getQualification());
                }
                if (score.getMessageScore()!= null){
                    e.get().setMessageScore(score.getMessageScore());
                }
                if (score.getQualification()!= null){
                    e.get().setQualification(score.getQualification());
                }
                scoreRepository.save(e.get());
                return e.get();
            }
            else{
                return score;
            }
        }
        else{
            return score;
        }
    }
    
    public boolean deleteScore (int id){
        
        /*Optional<Admin> admin=adminRepository.getAdmin(id);
        if(admin.isEmpty()){
            return false;
        }else{
            adminRepository.delete(admin.get());
            return true;
        }*/
        Boolean aBoolean = getScore(id).map(
            score->{
                scoreRepository.delete(score);
                return true;
            }).orElse(false);
        return aBoolean;
    }
}
