package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.service.CreatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CreatorController {
    @Autowired
    private CreatorManager creatorManager;

    // Afficher la liste des Creators
    @GetMapping("/creatorsList")
    public String showCreators(Model model) {
        List<Creator> creators = creatorManager.getAllCreator();
        model.addAttribute("creators", creators);
        return "creatorsList";
    }


    // Ajouter Creator
    @GetMapping("/addCreator")
    public String showAddCreatorForm(Model model) {
        model.addAttribute("creator", new Creator());
        return "addCreator";
    }

    @PostMapping("/addCreator")
    public String addCreator(@ModelAttribute("creator") Creator creator) {
        creatorManager.addCreator(creator);
        return "redirect:/creatorsList";
    }

    // Modifier Creator
    @GetMapping("/editCreator/{id}")
    public String showEditCreatorForm(@PathVariable("id") int id, Model model) {
        Creator creator = creatorManager.findCreatorById(id);
        model.addAttribute("creator", creator);
        return "editCreator";
    }

    @PostMapping("/editCreator/{id}")
    public String updateCreator(@PathVariable("id") int id, @ModelAttribute("creator") Creator creator) {
        creator.setId(id);
        creatorManager.updateCreator(creator);
        return "redirect:/creatorsList";
    }

    // Supprimer Creator
    @GetMapping("/deleteCreator/{id}")
    public String showDeleteCreatorForm(@PathVariable("id") int id, Model model) {
        Creator creator = creatorManager.findCreatorById(id);
        model.addAttribute("creator", creator);
        return "deleteCreator";
    }

    @PostMapping("/deleteCreator/{id}")
    public String deleteCreator(@PathVariable("id") int id, @RequestParam(name = "confirm", required = false) String confirm) {
        if ("yes".equals(confirm)) {
            Creator creator = creatorManager.findCreatorById(id);
            creatorManager.deleteCreator(creator);
        }
        return "redirect:/deleteCreator";
    }
}
