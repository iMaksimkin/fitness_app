package com.simbirsoft.fitness.controller;

import com.simbirsoft.fitness.model.Workout;
import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.service.CardService;
import com.simbirsoft.fitness.service.ClientService;
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
public class ClientController {
    private final ClientService clientService;
    private final WorkoutService workoutService;
    private final CardService cardService;

    @GetMapping("/clients")
    public String getUsers(Model model){
        List<Client> clients=clientService.getClients();
        model.addAttribute("clients",clients);
        model.addAttribute("clientInfo",new Client());
        return "client-update";
    }

    @RequestMapping(path = "/client/update/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Long id) {
        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "client-edit-form";
    }

    @RequestMapping(path = "/client/delete/{id}", method = RequestMethod.GET)
    public String getDeleteUser(@PathVariable("id") Long id, Model model) {
        clientService.deleteClient(id);
        return "redirect:/api/clients";
    }

    @RequestMapping(path = "/client/update/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @ModelAttribute ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
        String message = "Updated " + " user <b>" + clientDTO.getName() + " " + clientDTO.getSurname() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/api/clients", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @GetMapping("/client/{id}")
    public String getUser(@PathVariable Long id, Model model){
        Client client=clientService.getClient(id);
        List<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("client",client);
        model.addAttribute("workouts",workouts);
        return "client-view";
    }
}
