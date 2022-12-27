package com.sevensevengsi.Tournament.RecordSystem.controller;

import com.sevensevengsi.Tournament.RecordSystem.model.Game;
import com.sevensevengsi.Tournament.RecordSystem.repository.GameRepository;
import com.sevensevengsi.Tournament.RecordSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Controller
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;

    // Retrieve all games
    @GetMapping("/games")
    public String listOfGames(ModelMap model) {

        List<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);

        return "games";
    }

    // Form to add a game
    @GetMapping("/games/add")
    public ModelAndView gameForm() {
        return new ModelAndView("game", "gameForm", new Game());
    }

    // Form submit to add a game
    @PostMapping("/games/addAction")
    public String addGame(@ModelAttribute("gameForm") Game game, BindingResult result, ModelMap model) {
        gameRepository.save(game);
        return "home";
    }

    //
    @GetMapping("/games/update/{game_id}")
    public String updateGame(ModelMap model, @PathVariable int game_id) throws InterruptedException, ExecutionException {

        Optional<Game> game = gameRepository.findById(game_id);

        model.addAttribute("game", game);

        return "game_edit";

    }

    @PostMapping("/games/updateAction")
    public String updateGamePost(@ModelAttribute("game") Game game, BindingResult result, ModelMap model) throws InterruptedException, ExecutionException {

        gameRepository.save(game);
        return "games";
    }

}
