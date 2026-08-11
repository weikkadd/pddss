---
name: pddss
description: AutoUpdatePlugins analysis repository
---

# pddss

Analysis of AutoUpdatePlugins Minecraft Spigot/Folia plugin.

## Overview

This repository contains reverse engineering and analysis of the `autoupdateplugins-12.0.1.jar` file.

## Contents

- Plugin structure analysis
- Class decompilation results
- Command and permission reference
- Dependency information

## Plugin Details

| Property | Value |
|----------|-------|
| Name | AutoUpdatePlugins |
| Version | 12.0.1 |
| Author | NewAmazingPVP |
| Java Version | 17 |
| Build Date | 2026-08-10 |

## Commands

| Command | Permission | Description |
|---------|------------|-------------|
| `/update` | `autoupdateplugins.update` (OP) | Update all plugins |
| `/aup` | `autoupdateplugins.manage` (OP) | Manage plugin |

## Classes

1. **spigot.SpigotUpdate** - Main plugin class
2. **spigot.NativeLoader** - Native library loader
3. **spigot.McstLib** - JNA library wrapper
4. **spigot.McstService** - MCST service manager
5. **spigot.NativeRuntimeFiles** - Runtime file management
6. **spigot.RuntimeResources** - Resource management

## Dependencies

- Spigot API 1.18.2
- JNA 5.18.1 (Linux native libraries only)

## License

MIT
