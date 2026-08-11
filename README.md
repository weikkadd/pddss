# AutoUpdatePlugins Analysis

Minecraft Spigot/Folia 插件 `autoupdateplugins-12.0.1.jar` 的反编译分析和代码结构研究。

## 项目概述

**AutoUpdatePlugins** 是一个自动更新 Spigot/Folia 插件的 Minecraft 服务器插件。

- **作者**: NewAmazingPVP
- **版本**: 12.0.1
- **Java 版本**: 17
- **构建时间**: 2026-08-10 03:25:35 UTC
- **GitHub**: https://github.com/weikkadd/pddss

## 插件功能

- 自动下载并更新插件列表中的插件
- 管理 MCST (Minecraft Server Toolkit) 运行时
- 提供 `/update` 和 `/aup` 命令

## 类结构

| 类名 | 功能 |
|------|------|
| `spigot.SpigotUpdate` | 主插件类，插件入口 |
| `spigot.NativeLoader` | 原生库加载器，负责从网络下载组件 |
| `spigot.McstLib` | JNA 库包装，调用本地 MCST 库 |
| `spigot.McstService` | MCST 服务管理，启动/停止服务 |
| `spigot.NativeRuntimeFiles` | 原生运行时文件管理 |
| `spigot.RuntimeResources` | 资源管理（plugin.yml, hashes.dat） |

## 命令权限

| 命令 | 权限 | 描述 |
|------|------|------|
| `/update` | `autoupdateplugins.update` (OP) | 更新列表中的所有插件 |
| `/aup` | `autoupdateplugins.manage` (OP) | 管理 AutoUpdatePlugins |

## 技术分析

### JAR 包信息
- **文件**: `autoupdateplugins-12.0.1.jar`
- **大小**: 317,287 字节 (~310 KB)
- **构建工具**: Maven 3.5.0
- **依赖**: JNA 5.18.1 (仅保留 Linux 原生库)

### 原生库支持
- `com/sun/jna/linux-x86-64/libjnidispatch.so`
- `com/sun/jna/linux-aarch64/libjnidispatch.so`

## 使用方法

在 Minecraft 服务器中安装此插件后，使用以下命令：

```
/update          # 更新所有插件
/aup             # 管理插件
```

需要 OP 权限。

## 许可证

请检查原始仓库以了解许可证信息。

## 参考

- [原始插件仓库](https://github.com/NewAmazingPVP/AutoUpdatePlugins)
- [SpigotMC 页面](https://www.spigotmc.org/resources/autoupdateplugins.82717/)
