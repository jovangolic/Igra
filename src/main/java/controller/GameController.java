package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import model.Game;
import model.Grid;

@Controller
public class GameController {

    private Game game;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Connect Four! Click to start.");
        return "index"; // Index page
    }

    @GetMapping("/startGame")
    public String startGame(Model model) {
        Grid grid = new Grid(6, 7);
        game = new Game(grid, 42);
        model.addAttribute("message", "Game started! Player 1's turn.");
        model.addAttribute("gameState", game.getGameState());
        return "game";
    }

    @PostMapping("/makeMove")
    public String makeMove(@RequestParam int column, Model model) {
        if (game != null) {
            String result = game.makeMove(column);
            model.addAttribute("gameState", game.getGameState());
            model.addAttribute("message", result);
        }
        return "game"; // Same game page
    }
}
