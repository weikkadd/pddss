# AutoUpdatePlugins Analysis Project

This project contains analysis of the Minecraft Spigot plugin `autoupdateplugins-12.0.1.jar`.

## Contents

- `README.md` - Project overview
- `ANALYSIS.md` - Detailed class analysis
- `src/` - Source code analysis
- `output/` - Generated reports

## Plugin Information

- **Name**: AutoUpdatePlugins
- **Version**: 12.0.1
- **Author**: NewAmazingPVP
- **Type**: Spigot/Folia Minecraft Plugin
- **Function**: Automatically updates plugins on Minecraft server

## Commands

- `/update` - Update all plugins in list.yml
- `/aup` - Manage AutoUpdatePlugins

## Permissions

- `autoupdateplugins.update` - Allows updating plugins (OP)
- `autoupdateplugins.manage` - Allows managing plugin list (OP)

## Dependencies

- Spigot API 1.18.2
- JNA 5.18.1 (bundled, Linux only)

## Build

Built with Maven 3.5.0, Java 17.
