package com.simbirsoft.fitness.controller;

import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/workout")
public class WorkoutController {
    private final ClientService clientService;

    @RequestMapping(path = "/remove/client/{wid}/{cid}", method = RequestMethod.GET)
    public String removeClientFromTable(@PathVariable("wid") Long wid,
                                        @PathVariable("cid") Long cid) {
        clientService.clientWorkoutRemove(wid,cid);
        return "redirect:/api/client/{id}";
    }
}
