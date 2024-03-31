package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VideoController {

    @Autowired
    private VideoManager videoManager;
    @Autowired
    private CreatorManager creatorManager;

    // Afficher la liste des vidéos
    @GetMapping("/videosList")
    public String showVideos(Model model) {
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("videos", videos);
        return "videosList";
    }


    // Ajouter une nouvelle
    @GetMapping("/addVideo")
    public String showAddVideoForm(Model model) {
        model.addAttribute("video", new Video());
        List<Creator> allCreators = creatorManager.getAllCreator();
        model.addAttribute("allCreators", allCreators);
        return "addVideo";
    }

    @PostMapping("/addVideo")
    public String addVideo(@ModelAttribute("video") Video video) {
        videoManager.addVideo(video);
        return "redirect:/videosList";
    }

    // Modifier une vidéo
    @GetMapping("/editVideo/{id}")
    public String showEditVideoForm(@PathVariable("id") int id, Model model) {
        Video video = videoManager.findVideoById(id);

        Creator selectedCreator = video.getCreator();
        List<Creator> allCreators = creatorManager.getAllCreator();

        model.addAttribute("video", video);
        model.addAttribute("selectedCreator", selectedCreator);
        model.addAttribute("allCreators", allCreators);

        model.addAttribute("video", video);
        return "editVideo";
    }

    @PostMapping("/editVideo/{id}")
    public String updateVideo(@PathVariable("id") int id, @ModelAttribute("video") Video video) {
        video.setId(id);
        videoManager.updateVideo(video);
        return "redirect:/videosList";
    }

    // Supprimer une vidéo
    @GetMapping("/deleteVideo/{id}")
    public String showDeleteVideoForm(@PathVariable("id") int id, Model model) {
        Video video = videoManager.findVideoById(id);
        model.addAttribute("video", video);
        return "deleteVideo";
    }

    @PostMapping("/deleteVideo/{id}")
    public String deleteVideo(@PathVariable("id") int id, @RequestParam(name = "confirm", required = false) String confirm) {
        if ("yes".equals(confirm)) {
            Video video = videoManager.findVideoById(id);
            videoManager.deleteVideo(video);
        }
        return "redirect:/videosList";
    }
}