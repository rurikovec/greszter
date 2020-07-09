package com.greenfoxacademy.programmerfoxclub.Controller;

import com.greenfoxacademy.programmerfoxclub.Model.Drink;
import com.greenfoxacademy.programmerfoxclub.Model.Food;
import com.greenfoxacademy.programmerfoxclub.Service.FoxService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxClubController {

  private FoxService foxService;

  @Autowired
  public FoxClubController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String getMain(@RequestParam (required = false) String name, Model model) {
    if (name.equals(null)) {
      return "redirect:/login";
    } else {
      model.addAttribute("name", name);
      model.addAttribute("food", foxService.getFox(name).getFood());
      model.addAttribute("drink", foxService.getFox(name).getDrink());
      model.addAttribute("trickNumber", foxService.getFox(name).getTrickNumber());
      model.addAttribute("trick", foxService.getFox(name).getTricks());
      foxService.setLoggedInFox(name);
      return "index";
    }
  }

  @GetMapping("/information")
  public String getInfo() {
    return "information";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String loginPost(@RequestParam String name) {
    if (name.isEmpty()) {
      return "redirect:/login";
    } else if (foxService.toString().contains(name)) {
      return "redirect:/?name=" + name;
    } else {
      return "redirect:/register";
    }
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/register")
  public String registerFox(@RequestParam String name, @RequestParam String food,
                            @RequestParam String drink) {
    foxService.addFox(name, food, drink);
    return "redirect:/login";
  }

  @GetMapping("/nutritionStore")
  public String getNutrition(Model model){
    model.addAttribute("foodOptions", Arrays.asList(Food.values()));
    model.addAttribute("drinkOptions", Arrays.asList(Drink.values()));

    return "nutrition";
  }

  @PostMapping("/nutritionStore")
  public String setNutrition(@RequestParam String food, @RequestParam String drink){
    return "nutritionStore";
  }



}
