package com.simbirsoft.fitness.controller;
import com.simbirsoft.fitness.model.Workout;
import com.simbirsoft.fitness.model.dto.CoachDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.model.user.Coach;
import com.simbirsoft.fitness.service.CoachService;
import com.simbirsoft.fitness.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class CoachController {
    private final CoachService coachService;
    private final WorkoutService workoutService;

    @GetMapping("/coaches")
    public String getUsers(Model model){
        List<Coach> coaches= coachService.getCoaches();
        model.addAttribute("coaches",coaches);
        model.addAttribute("coachInfo",new Coach());
        return "coach-update";
    }

    @RequestMapping(path = "/coach/update/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Long id) {
        Coach coach = coachService.getCoach(id);
        model.addAttribute("coach", coach);
        return "coach-edit-form";
    }

    @RequestMapping(path = "/coach/delete/{id}", method = RequestMethod.GET)
    public String getDeleteUser(@PathVariable("id") Long id, Model model) {
        coachService.deleteCoach(id);
        return "redirect:/api/coaches";
    }

    @RequestMapping(path = "/coach/update/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @ModelAttribute CoachDTO coachDTO) {
        coachService.updateCoach(id, coachDTO);
        String message = "Updated " + " user <b>" + coachDTO.getName() + " " + coachDTO.getSurname() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/api/coaches", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @GetMapping("/coach/{id}")
    public String getUser(@PathVariable Long id, Model model){
        Coach coach=coachService.getCoach(id);
        List<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("coach",coach);
        model.addAttribute("workouts",workouts);
        return "coach-view";
    }
}
