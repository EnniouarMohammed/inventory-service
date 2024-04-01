package ma.xproce.inventoryservice.web;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/index")
    public String Home() {
        return "index";
    }

    @GetMapping("")
    public String Home2() {
        return "redirect:/index";
    }
}
