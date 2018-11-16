package com.example.demo.controller;

import com.example.demo.common.Group;
import com.example.demo.common.SaveGroup;
import com.example.demo.common.UpdateGroup;
import com.example.demo.model.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hmq on 2018/11/13.
 */
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/team/save")
    public String saveTeam(@RequestBody @Validated({SaveGroup.class}) Team team, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }

//        teamService.saveTeam(team);
        return "ok";
    }

    @PutMapping("/team/edit")
    public String editTeam(@RequestBody @Validated({UpdateGroup.class}) Team team, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
//        teamService.updateTeam(team);
        return "ok";
    }
    @ResponseBody
    @DeleteMapping("/team/delete")
    public String deleteTeam(@RequestParam Integer id){
        teamService.deleteTeam(id);
        return "ok";
    }
    @GetMapping("/team/query")
    public List<Team> queryTeam(@RequestParam(value = "name" ,required = false)String name,
                                @RequestParam(value = "coach",required = false) String coach,@RequestParam(value = "id",required = false) Integer id){
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        team.setCoach(coach);
        return teamService.queryTeamList(team);
    }

    @GetMapping("/team/test")
    public Team testDevTools(){
        Team team = new Team();
        team.setName("戴维斯");
        return team;
    }
}
