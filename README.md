Source: https://www.codurance.com/katalyst/battleships

# Rules
- When all ships have been sunk the game ends
- when the game is finished the game should display a battle report the number of shots fired by each player, including hit/miss ship sunk.
- Ships sunk should show the lowest possible coordinate for the given ship, for example:
  - A horizontal destroyer on grid reference (2,3), (3,3) and (4,3), but when reporting the sinking of the ship, you only need to reference the first coordinate.
  - A vertical destroyer on ref (5,5), (5,6) and (5,7) but you'll only need to reference (5,5) when reporting.


# Restrictions
- use outside-in
- Each player has:
  - 1 Carrier
  - 2 Destroyers
  - 4 gunships
- Grid is 10x10