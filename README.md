# rps-game
DB: pgSQL running locally

APIs: 

 - **user/register  (register user)**
 - **user/login  (login user)**
 - **user/history  (get user play history)**
 - **user/register  (register user)**
 - **game/rps  (user play with app)**

Highlight:
The app use game engine for shape generation, which is initiated with a configured strategy.
Just implemented a simple strategy so as not to complicate things. The strategy is build to be injected to the game engine. It can evolve.
Every round of the game is recorded which can be accessed with game/rps.

