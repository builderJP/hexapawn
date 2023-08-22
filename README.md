# Hexapawn - COMP305 Final Project

##### Made by J.P. Tasto during Summer of 2023

## Brief Introduction

This project was made as the final project of COMP305 at the University of San Diego. It implements the game Hexapawn in the console, prompts for all user inputs appearing there along with the Hexapawn game board, which is displayed to the user using ASCII art.

## What *is* Hexapawn?

[Hexapawn](https://en.wikipedia.org/wiki/Hexapawn) is a game that was made by [Martin Gardner](https://en.wikipedia.org/wiki/Martin_Gardner) to demonstrate an artificial intelligence that could learn from previous mistakes/successes. It consists of a 3x3 chess board with three black pawns on one side and three white pawns on the other. The game pieces, called pawns, act like their namesake from chess; they can move forward one space if the space in front of them is empty and they can attack diagonally, the opponent's pawn being removed from the board and the attacking pawn moving into the space where the enemy pawn was. When playing against an artificial intelligence, it is always the human player who goes first. The objective of the game is to win, of course. There are three possible win conditions:
1. One of your pawns reaches the opposite side of the board.
2. You eliminate all of your opponents' pawns.
3. It is your opponent's turn to move one of their pawns, but the board is currently in stalemate (there are no possible moves either player can make).

![Hexapawn Game Board](https://cf.geekdo-images.com/okfZbuym9LFCzmE_fgdLTg__itemrep/img/YoK_T9jrf7GZucmm4Fk0S3BddAI=/fit-in/246x300/filters:strip_icc()/pic276154.jpg "Standard Setup for a Hexapawn Board")

Martin Gardner's inspiration for Hexapawn was the [MENACE mechanical computer](https://en.wikipedia.org/wiki/Matchbox_Educable_Noughts_and_Crosses_Engine) that used matchboxes that had every possible layout of the game for the AI player drawn atop them and beads that were in each matchbox to determine the moves an artifical intelligence should make to play tic-tac-toe perfectly. As more games are played with the artifical intelligence, MENACE would perform better moves and get better at the game due to beads being added for each successful game or beads being taken away if it lost.

My implementation of Hexapawn doesn't have an artifical intelligence that learns like MENACE did. The black artificial intelligence just follows the best moves from the Hexapawn game tree so that it always wins. Along with this, the moves white can do are those only available if black plays perfectly. If, somehow, either the player or the AI were to put a state of the game board that isn't on the game tree of black playing perfectly, the game would cease to function.

## Inspirations/Special Thanks

The inspiration for this project was a video made by one of my favorite Youtubers: VSauce2. He made a [video that showcased the game Hexapawn](https://youtu.be/sw7UAZNgGg8) in part of it, which is what inspired me to eventually make this version of the game.

To see the game in action, I used [this](https://www.mrozilla.cz/lab/hexapawn/) iteration of the game.
