package com.simbirsoft.fitness.controller;

import com.simbirsoft.fitness.model.Card;
import com.simbirsoft.fitness.model.dto.CoachDTO;
import com.simbirsoft.fitness.model.enums.ClientStatus;
import com.simbirsoft.fitness.model.dto.ClientDTO;
import com.simbirsoft.fitness.model.user.Client;
import com.simbirsoft.fitness.model.user.Coach;
import com.simbirsoft.fitness.service.ClientService;
import com.simbirsoft.fitness.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final ClientService clientService;
    private final CoachService coachService;

    @GetMapping
    public String getClients(Model model){
        List<Client> clients=clientService.getClientsByStatus(ClientStatus.INSIDE);
        model.addAttribute("clients",clients);
        model.addAttribute("card", new Card());
        return "admin-view";
    }

    @RequestMapping(path = "/save/client", method = RequestMethod.GET)
    public String saveClient(Model model) {
        model.addAttribute("client", new ClientDTO());
        return "client-add-form";
    }

    @RequestMapping(path = "/save/client", method = RequestMethod.POST)
    public RedirectView createClient(RedirectAttributes redirectAttributes, @ModelAttribute ClientDTO clientDTO) {
        clientService.saveClient(clientDTO);
        String message = "Created user <b>" + clientDTO.getName() + " " + clientDTO.getSurname() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/api/admin/save/client", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @RequestMapping(path = "/add/client", method = RequestMethod.POST)
    public String addClientInTable(@ModelAttribute Card card) {
        clientService.clientVisit(card);
        return "redirect:/api/admin";
    }

    @RequestMapping(path = "/remove/client/{id}", method = RequestMethod.GET)
    public String removeClientFromTable(@PathVariable("id") Long id) {
        clientService.clientLeave(id);
        return "redirect:/api/admin";
    }

    @RequestMapping(path = "/save/coach", method = RequestMethod.GET)
    public String saveCoach(Model model) {
        model.addAttribute("coach", new Coach());
        return "coach-add-form";
    }

    @RequestMapping(path = "/save/coach", method = RequestMethod.POST)
    public RedirectView createCoach(RedirectAttributes redirectAttributes, @ModelAttribute CoachDTO coachDTO) {
        coachService.saveCoach(coachDTO);
        String message = "Created user <b>" + coachDTO.getName() + " " + coachDTO.getSurname() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/api/admin/save/coach", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }


}
