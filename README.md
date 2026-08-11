# AutoUpdatePlugins

[![Build](https://github.com/weikkadd/pddss/actions/workflows/build.yml/badge.svg)](https://github.com/weikkadd/pddss/actions/workflows/build.yml)
[![Release](https://img.shields.io/github/v/release/weikkadd/pddss)](https://github.com/weikkadd/pddss/releases)
[![License: MIT](https://img.shields.io/github/license/weikkadd/pddss)](LICENSE)

Automatically update any Spigot/Paper/Folia/BungeeCord/Velocity plugin you wish!

## Features

- **One list, many sources** - Pull updates from GitHub Releases/Actions, Jenkins, SpigotMC (Spiget), dev.bukkit, Modrinth, Hangar, CurseForge, and more
- **Smart file selection** - Use `?get=`, `[N]`, `?artifact=2` for GitHub Actions artifacts
- **Auto restart** - Optional server restart after updates
- **Rollback support** - Keep backup of previous versions
- **Custom output directories** - Flexible deployment options

## Installation

1. Download the latest `.jar` from [Releases](https://github.com/weikkadd/pddss/releases)
2. Place it into your server's `plugins/` directory
3. Start the server to generate default config files
4. Edit `plugins/AutoUpdatePlugins/config.yml` and `list.yml`

## Commands

| Command | Permission | Description |
|---------|------------|-------------|
| `/update` | `autoupdateplugins.update` (OP) | Update all plugins in list.yml |
| `/aup` | `autoupdateplugins.manage` (OP) | Manage AutoUpdatePlugins |

## Configuration

### config.yml
```yaml
updates:
  interval: 120  # How often to check (minutes)
  delay: 10      # Delay after startup (seconds)
  
behavior:
  useUpdateFolder: true
  zipFileCheck: true
  allowPreRelease: false
```

### list.yml
```yaml
EssentialsX: https://github.com/EssentialsX/Essentials/releases
PlaceholderAPI: https://github.com/PlaceholderAPI/PlaceholderAPI/releases
```

## Building from Source

Requires JDK 17+ and Maven 3.6+:

```bash
git clone https://github.com/weikkadd/pddss.git
cd pddss
mvn clean package
```

The compiled JAR will be in `target/autoupdateplugins.jar`.

## License

MIT License - see LICENSE for details.

## Links

- [GitHub Repository](https://github.com/weikkadd/pddss)
- [Releases](https://github.com/weikkadd/pddss/releases)
- [Actions](https://github.com/weikkadd/pddss/actions)
