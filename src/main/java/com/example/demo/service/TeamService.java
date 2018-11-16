package com.example.demo.service;

import com.example.demo.mapper.TeamMapper;
import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hmq on 2018/11/13.
 */
@Service
public class TeamService {

    @Autowired
    private TeamMapper teamMapper;

    public void saveTeam(Team team){
        int i = teamMapper.insert(team);
        System.out.println(i);
    }

    public void updateTeam(Team team){
        int i = teamMapper.updateByPrimaryKey(team);
        System.out.println(i);
    }

    public void deleteTeam(Integer id){
        int i = teamMapper.deleteByPrimaryKey(id);
        System.out.println(i);
    }

    public List<Team> queryTeamList(Team team){
        return teamMapper.select(team);
    }

}
