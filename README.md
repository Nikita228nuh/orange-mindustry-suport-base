# Orange Support Base — Mindustry v8 Build 159.7

This is a Java mod targeted at Mindustry v8 Build 159.7.

## Features

- Orange Core:
  - 1,000 HP
  - 10 HP/s self-regeneration
  - 1,000,000 item capacity
  - +50 unit capacity
  - Spawns the Orange Support unit for the player
- Orange Support:
  - Player controllable
  - 100,000 HP
  - 60 blocks/s movement
  - Very fast building
  - Very fast mining
  - Mine tier 999 and all current items are listed as mine targets
  - Immune to every status effect loaded by the game
  - 10-block-radius force-field shield
  - 1,000,000 shield HP
  - 100,000 shield HP/s regeneration
  - Repairs friendly units and buildings for 100 HP/s within 10 blocks
  - Has no weapons and does not attack

## Important

The Core is the player-spawn base: when the player spawns at this core, Mindustry creates the configured unit and gives it to the player.

The +50 unit capacity is implemented with the core's unitCapModifier. The core itself does not behave like a conventional Unit Factory; it provides the controlled player unit.

## Building

The official Mindustry Java mod template targets Java 17 and supports v159.7. The recommended Android route is to build the JAR with GitHub Actions, then import the resulting cross-platform JAR into Mindustry.

See the main project instructions in the chat response for Android installation.
