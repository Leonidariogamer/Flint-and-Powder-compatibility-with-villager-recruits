# Recruits x Flint'N'Powder

Forge 1.20.1 compatibility mod: **Villager Recruits crossbowmen can load, aim and fire
[Flint'N'Powder](https://www.curseforge.com/minecraft/mc-mods/flintnpowder) guns.**

Requires Villager Recruits 1.15.x and Flint'N'Powder 1.0.0 (both on client and server).

## How to use
1. Give a **Crossbowman** recruit the gun. Drop it near them, or put it in their inventory: it equips itself
   (a crossbow in hand does not block it). Removing the crossbow is not required.
2. Put the gun’s ammo in the recruit’s **inventory** (not the offhand): gunpowder + shot for muzzle
   loaders, cartridges/magazines for the rest. A ramrod item is optional by default.
3. Let it fight. Between fights it loads on its own; in a fight it loads, cocks/primes and fires.
   Loading is invisible (no animation); watch the ammo count drop in the recruit’s inventory.

Supported guns: every hand-held Flint’N’Powder gun except the Log Cannon.
- Muzzle loaders (gunpowder, shot, ramrod): Musket, Bayonet Musket, Rifle, Pistol, Arquebus, Hand Gonne,
  Blunderbuss, Bruttbuss, Big Game, Flinter, Volleygun.
  Arquebus, Hand Gonne, Flinter and Volleygun also need **Flint and Steel** in the recruit's inventory to ignite;
  Flinter and Volleygun also use **flint** and **sticks** (flint and steel is only used when firing, and wears down).
- Cartridge guns: Bolt Action Rifle (and bayonet version), Trapdoor Rifle, Shotgun, Break Action
  Coachgun, Single Action Revolver. Give the recruit rifle rounds / shotgun shells / pistol rounds.
- Magazine guns: Closed Bolt Mag Rifle, Blowback Handgun, Open Bolt SMG, Gas Operated Shotgun.
  Give the recruit loaded magazines; an empty magazine is dropped when the gun runs dry.

Settings are in `config/recruits_flintnpowder-common.toml`.

## How it works
Flint'N'Powder runs each gun's right click through `<Gun>RightclickedProcedure.execute(...)`. The
mod calls that same procedure reflectively with the recruit as the shooter, lending a recruit's
offhand to each reload step (gunpowder, shot, ramrod), then trigger. A step counts as accepted when the gun's NBT changes,
so damage, projectiles, sounds and enchantments are all Flint'N'Powder's own.

## Building and testing
`./gradlew build` (JDK 17). The jar is in `build/libs/`. Every push also builds it in GitHub
Actions (Actions tab -> latest run -> Artifacts). Project layout and Gradle setup follow
[Recruits Use Boomsticks](https://github.com/iwosw/recruits-use-boomsticks) (MIT).

`./gradlew runClient` / `runServer` start a dev game with Recruits and Flint’N’Powder loaded
(Flint’N’Powder is a runtime-only dev dependency fetched from Modrinth). The project has no unit tests.

## Status
Builds and starts on Forge 1.20.1 (47.4.22) with Recruits 1.15.2 and Flint’N’Powder 1.0.0. Recruits equip
and reload guns and fire at targets in-game (play-tested with the bolt action rifle); the other guns
were checked headlessly through their reload steps only.

## License
MIT, see [LICENSE](LICENSE).
