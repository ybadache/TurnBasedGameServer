/*******************************************************************************
 * This server holds all the components so the
 * specified client will be able to communicate with it to run, create, join
 * or leave a game that the server allows. It also implements the game factory
 * TurnBasedGame, created by Raphael Bauduin and Celia Cacciatore last year.
 * 
 *     Copyright (C) 2015 
 *     Initiators : Gauvin Marquet and Yoann Dufresne
 *     Developper : Yassine Badache
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
 
 
# Context #
This is a personal project into a learning unit (UE) called PJI (Projet Individuel,
or Individual Project). The idea is to use the already existing project, named TurnBasedGame,
which allows a developer to create a turn-based game using states machines in JAVA, in order
to make the created games runnable into a Java Virtual Machine. The server is written in JAVA.

In order to do so, I used an already existing server that was originally used for FTP request
processing -you can access it into the "CAR" folder on this Github-, and turned it into what
it is at the moment. The process behind request response isn't that different from the FTP
process, so that's why I used this basis. In fact, it is even easier to understand, as there
is at the moment only one socket and a single reader / writer.



# Design #
FTP server used Chain of Responsibility in order to treat a request. This server rests on a
Factory pattern, where the good command will be created whenever it is necessary. The advantage
of this pattern is that it won't go through all the request-processing classes to access the right
one, instead it will directly create a single instance of the class.


# ChangeLog #
V0.5: Possibility to send the following messages: "create tictactoe", "list", "exit", "leave", "join".
You can communicate with the TicTacToe game, but as you're the only player, it doesn't work very well.

V0.4: The game is created on the server, but communication aren't working: the built game is in his initial
state and cannot receive any exterior messages.

V0.3: The whole server project is now compiling with Maven and is submitted on my personnal Github.

V0.2: The client that comes aside with the server is ready and functional.

V0.1: Imported the FTP server basis and modified it to respect the turn-based game server specifications. 